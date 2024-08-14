- [Table of Contents](#table-of-contents)
- [Array](#array)
  - [Maximum Subarray](#maximum-subarray)
- [Dynamic Programming](#dynamic-programming)
  - [Bottom Up](#bottom-up)
- [Heap Priority Queue](#heap-priority-queue)
  - [K'th Largest](#kth-largest)
  - [K'th Smallest](#kth-smallest)

# Table of Contents

# Array

## Maximum Subarray

- Kadane's Algorithm

# Dynamic Programming

## Bottom Up

- Initialise `dp[n+1][n+1]`
- Can go from
  - `1 -> n` inclusive
  - `n-1 -> 0` inclusive
- Example
  - 2218

# Heap Priority Queue

- `k'th` largest = `(n - k)'th` smallest
- `k'th` smallest = `(n - k)'th` largest
- See interview-questions/2023/atlassian/q4.java

## K'th Largest

- Use **MIN** heap of size `k` so that k'th largest element will be at the top of the heap
  - Min heap order goes `[k'th, (k-1)'th, (k-2)th, ..., 2nd, 1st]` largest
  - Elements that come after will be LARGER, so `k-1`th largest element comes next
    - I.e. if `k == 3`, then second largest element comes next, then largest element comes last
  - Largest element will be at bottom of the heap
- Insert elements into pq and restrict `pq.size()` to k

```java
class Solution {
  int getKthLargestElement(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }
}
```

## K'th Smallest

- Use **MAX** heap of size `k` so that k'th smallest element will be at the top of the heap
  - Max heap order goes `[k'th, (k-1)'th, (k-2)th, ..., 2nd, 1st]` smallest
  - Elements that come after will be SMALLER, so `k-1`th smallest element comes next
    - I.e. if `k == 3`, then second smallest element comes next, then smallest element comes last
  - Smallest element will be at bottom of the heap
- Insert elements into pq and restrict `pq.size()` to k

```java
class Solution {
  int getKthSmallestElement(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    for (int num : nums) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    return pq.poll();
  }
}
```
