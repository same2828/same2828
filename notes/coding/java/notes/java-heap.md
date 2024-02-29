# Construct Heap

- Constructing a Heap means initializing an instance of a Heap. All methods of Heap need to be performed on an instance. Therefore, we need to initialize an instance before applying the methods. When creating a Heap, we can simultaneously perform the heapify operation. Heapify means converting a group of data into a Heap.
- Time complexity: O(N)
- Space complexity: O(N)

```java
// In Java, a Heap is represented by a Priority Queue
import java.util.*;
class Solution {
  public int myFunction() {
    // MIN Heap
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
    // MAX Heap
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
  }
}

// Construct a Heap with initial elements.
// This process is named "Heapify".
// The Heap is a Min Heap
PriorityQueue<Integer> heapWithValues= new PriorityQueue<>(Arrays.asList(3, 1, 2));
```

# Insert Element

- Insertion means inserting a new element into the Heap. Note that, after the new element is inserted, properties of the Heap are still maintained.
- Time complexity: O(logN)
- Space complexity: O(1)

```java
// Insert an element to the Min Heap
minHeap.add(5);

// Insert an element to the Max Heap
maxHeap.add(5);
```

# Getting the Top Element of the Heap

- The top element of a Max heap is the maximum value in the Heap, while the top element of a Min Heap is the smallest value in the Heap. The top element of the Heap is the most important element in the Heap.
- Time complexity: O(1)
- Space complexity: O(1)

```java
// Get top element from the Min Heap i.e. the smallest element
minHeap.peek();
// Get top element from the Max Heap i.e. the largest element
maxHeap.peek();
```

# Deleting the top element

- Note that, after deleting the top element, the properties of the Heap will still hold. Therefore, the new top element in the Heap will be the maximum (for Max Heap) or minimum (for Min Heap) of the current Heap.
- Time complexity: O(logN)
- Space complexity: O(1)

```java
// Delete top element from the Min Heap
minHeap.poll();

// Delete top element from the Max Heap
maxheap.poll();
```

# Getting the Length of a Heap

- The length of the Heap can be used to determine the size of the current heap, and it can also be used to determine if the current Heap is empty. If there are no elements in the current Heap, the length of the Heap is zero.
- Time complexity: O(1)
- Space complexity: O(1)

```java
// Length of the Min Heap
minHeap.size();

// Length of the Max Heap
maxHeap.size();

// Note, in Java, apart from checking if the length of the Heap is 0, we can also use isEmpty()
// If there are no elements in the Heap, isEmpty() will return true;
// If there are still elements in the Heap, isEmpty() will return false;
```

# Space and Time Complexity

| Heap Method            | Time Complexity | Space Complexity |
| ---------------------- | --------------- | ---------------- |
| Construct a Heap       | O(N)            | O(N)             |
| Insert an element      | O(logN)         | O(1)             |
| Get the top element    | O(1)            | O(1)             |
| Delete the top element | O(logN)         | O(1)             |
| Get the size of a Heap | O(1)            | O(1)             |
