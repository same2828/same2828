# Table of Contents

- [Table of Contents](#table-of-contents)
- [Interview Notes](#interview-notes)
  - [Q1](#q1)

# Interview Notes

## Q1

- This is INVALID
- Can only `GROUP BY` attributes that are `SELECTED` (in the `SELECT` statement)

```sql
SELECT ID, FirstName, COUNT(ID)
From USERS
GROUP BY Lastname
```
