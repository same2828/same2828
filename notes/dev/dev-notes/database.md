# Table of Contents

- [Table of Contents](#table-of-contents)
- [Database](#database)
  - [Database Internals](#database-internals)
    - [B-Trees](#b-trees)
    - [Indexing](#indexing)
  - [Database Scaling](#database-scaling)
    - [Data Consistency](#data-consistency)
      - [Strong Consistency](#strong-consistency)
      - [Eventual Consistency](#eventual-consistency)
    - [Master-slave replication](#master-slave-replication)
    - [Master-Master replication](#master-master-replication)
    - [Database Sharding](#database-sharding)

# Database

## Database Internals

A database has the requirements of storing data and being able to retrieve that data when queried

A simple database outlined in Designing Data Intensive Applications shows a simple append only file to store key-value pairs.
A Set function appends a key-value pair to the end of the file which is a fast operation.
However the Get function needs to scan the entire file to find the latest occurrence of the key it is looking for.

In order to efficiently find the value for a particular key in the database we need an _index_ data structure. The index works similarly to a dictionary, if we need to find a word _'cat'_ we don't just read the entire dictionary from front to back. We first go to the section of the book that contains words starting with 'c', then from that look through the words that have 'a' as their second letter and so on. Searching becomes much faster which means reads become faster.

The index is an additional data structure that tracks where these keys are stored in disk. Maintaining an index incurs overhead, especially on writes as we now need to update the index file as well to keep track of additions and deletion of data. Trade off to reduce write speed to increase read speeds.

### B-Trees

The most common data structure used to keep track of indexes in SQL databases are B-trees.

Database rows are stored in fixed-size blocks or pages which closely resembles how disks are arranged. Each page can be identified by an address, just like a pointer in C but on the disk instead of in memory.
![](https://miro.medium.com/v2/resize:fit:720/format:webp/1*PTLysQ_HMSaUw1OHRZwtWg.png)

The index is stored on a B-Tree structure on disk. A page is designated as the root of the B-tree and contains several keys and references to children pages. Each child page is responsible for a continuous range of keys.

If we were to lookup user_id = 251, in the root table we find the reference that stores the pages containing the user_id's from 200 to 300. Then that table contains references for the user_ids from 200 to 300 in steps of 20. We continue through the reference containing keys from 250 to 270 which brings us to the leaf page containing the reference for the page with user_id = 251
![](https://miro.medium.com/v2/resize:fit:720/format:webp/1*rq_1M02oNhuJajT3M0LNLw.png)

This tree always rebalanced as required when data is inserted or deleted. A B-tree with $n$ keys will always have a depth of $O(\log n)$. Most databases can fit into a B-tree that is three or four levels deep, so you don't need to follow many page references to find the page you are looking for. (A four-level tree of 4 KB pages with a branching factor of 500 can store up to 256 TB.)

### Indexing

Indexes are commonly made for primary keys. For example if we had the following example table **Users**.

| id (PK) | name   |
| ------- | ------ |
| 1       | Alice  |
| 2       | Bob    |
| 3       | Calvin |
| 4       | Devon  |
| 5       | Edward |
| ...     | ....   |
| 1000000 | Aaron  |

For the Users table the primary key is id and we have 1,000,000 users.
For the query: _select _ from Users where id = 5;\*
The database would recognise that the id column has been indexed so it can scan the index data structure and find the correct id quickly in $O(\log n)$.

Now for the query: _select _ from Users where name = 'Aaron';\*
The name column has not been indexed, therefore the database has no idea where the table row containing a name Aaron is located. It also isn't guaranteed for the name Aaron to occur only once so it must do a linear scan, $O(n)$, of the entire database in order to find all table rows containing Aaron which takes far longer than looking up an index. To solve this we can actually create an index for the name column as well if we wanted to. The database will store and manage another B-tree in order to get faster reads for any queries filtering by name.

The trade off for having another B-tree is having higher reads for the name column but will reduce overall write speeds for any data being added or deleted from the Users table as the database now needs to also update the indexing for two B-tree structures. A table can contain many columns, introducing indexes on every single column will increase read speed but will also drastically harm write speeds. Adding indexes is part of performance tuning, it should be used to speed up common query operations that are not indexed.

- Resources
  - [Architecture of SQLite](https://www.sqlite.org/arch.html)
  - https://15445.courses.cs.cmu.edu/fall2019/notes/
  - [Write an SQLite Clone in C from Scratch - cstack](https://cstack.github.io/db_tutorial/)
  - [HelinDb - Basic Database written in Go](https://github.com/thetarby/helindb)
  - [Understanding Database Indexing](https://aws.plainenglish.io/database-indexing-secrets-d1f93e67bb1b)
  - [Database Indexing Explained (with PostgreSQL)](https://www.youtube.com/watch?v=-qNSXK7s7_w)
  - [How do SQL Indexes Work](https://www.youtube.com/watch?v=YuRO9-rOgv4)
  - Designing Data Intensive Applications

## Database Scaling

### Data Consistency

A system with data consistency strives for every service to see the same data at the same time. This is simple when you have one database but when you have multiple replica databases it becomes more difficult.

There are two main types of consistency. **Strong Consistency** and **Eventual Consistency**.

#### Strong Consistency

Strong consistency means that every read request for the data **must** return the most up to date value.
Typically used in applications where transactions occur to ensure data integrity and fairness.

There are some strategies to achieve strong consistency

- **Master Database**
  - Designate one of the database as the primary database which is the only database that accepts writes. All other databases are read replicas.
  - When data is written, updates are applied **synchronously** to all other replicas
    - While an update is occurring read/write requests will be **blocked** until the update is propagated across all replicas. This ensures that read operations only see the latest state of data.
      - This guarantees strong consistency but can reduce availability and latency of the system. Can also cause read/write timeouts
    - An alternative to that is to send all read/writes to the primary DB as it is guaranteed to be up to date and requests will not be blocked. However can cause overload to the server.
- **Two Phase Commit**
  - The process involves the following steps:
    - **Prepare phase:** The coordinating node (usually the primary replica) sends a "prepare" message to all participant nodes (secondary replicas), asking them to prepare to commit the transaction.
    - **Commit phase:** If all participants successfully prepare, the coordinating node sends a "commit" message to all participants, and they apply the updates. If any participant fails, the coordinating node sends a "rollback" message, and the participants undo the changes.

#### Eventual Consistency

Eventual consistency is when a data value is updated, eventually all the read requests will return the most up to date value. Allows for greater availability and scalability in distributed systems by relaxing the synchronization requirements between nodes.

### Master-slave replication

Pattern where only one master database is responsible for writes while remainder are read replicas. Same pattern mentioned in [[#Strong Consistency]]. If the master goes offline, the system can continue to operate in read-only mode until a slave is promoted to a master or a new master is provisioned.
**Disadvantages**

- Potential for loss of data if the master fails before any newly written data can be replicated to other nodes.
- Writes are replayed to the read replicas. If there are a lot of writes, the read replicas can get bogged down with replaying writes and can't do as many reads.
- The more read slaves, the more you have to replicate, which leads to greater replication lag.
- On some systems, writing to the master can spawn multiple threads to write in parallel, whereas read replicas only support writing sequentially with a single thread.
- Replication adds more hardware and additional complexity.

### Master-Master replication

Master-master replication is where multiple databases have read/write permissions. If either master goes down, the system can continue to operate with both reads and writes.

In addition to the master-slave replication disadvantages we also have the following disadvantages.
**Disadvantages**

- Need a load balancer or make changes to your application logic to determine where to write.
- Most master-master systems are either loosely consistent (violating ACID) or have increased write latency due to synchronization.
- Conflict resolution comes more into play as more write nodes are added and as latency increases.

### Database Sharding

Sharding is a horizontal scaling technique that separates a single database into smaller parts called shards, where each shard shares the same schema but contain a different range of data. E.g if we were sorting by name and had two databases, we could say Shard 1 is responsible for all names starting with A-M and Shard 2 is responsible for N-Z.

The data on each shard is unique. Anytime data is accessed a hash function is used to find the corresponding shard similar to a hashmap. E.g if we shard a database based on user id and have 4 total shards we can use a hash function such as $user\_id \  \% \  4$ to get the corresponding shard.

However sharding is not a perfect solution
**Resharding Data:**

- Resharding data is needed when a single shard can no longer hold more data. Certain shards may experience shard exhaustion faster than others due to uneven data distribution.
- To reshard data the hash function needs to be updated to distribute the data among shards more evenly. Updating the sharding function means that some existing data will need to be moved in order to match the hash function. A common technique to solve this is [[notes/Consistent Hashing|Consistent Hashing]].
  **Celebrity Problem:**
- Excessive access to the same shard can cause server overload. For a social application if many celebrities are on the same shard then that shard may be overwhelmed with read operations. Celebrities may need their own shard each.
  **Join and de-normalization**:
- Once a database is sharded it is harder to perform join operations across database shards. A common workaround is to de-normalise the database so that queries can be performed in a single table.

- Resources
  - [Consistency Patterns - Neo Kim](https://systemdesign.one/consistency-patterns/)
  - [Data Consistency and Tradeoffs in Distributed Systems - Gaurav Sen](https://www.youtube.com/watch?v=m4q7VkgDWrM)
