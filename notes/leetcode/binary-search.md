# Table of Contents

- [Table of Contents](#table-of-contents)
- [Binary Search](#binary-search)
  - [Version 1](#version-1)
    - [Java](#java)
    - [Python](#python)
  - [Version 2](#version-2)
    - [Java](#java-1)
    - [Python](#python-1)
  - [Version 3](#version-3)
    - [Java](#java-2)
    - [Python](#python-2)

# Binary Search

## Version 1

### Java

```java
int binarySearch(int[] nums, int target) {
  if (nums == null || nums.length == 0) {
    return -1;
  }

  int left = 0, right = nums.length - 1;
  while (left <= right) {
    // int mid = (left + right) / 2;
    // int mid = (left + right) >> 1;
    int mid = left + ((right - left) / 2); // Prevent (left + right) overflow
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  // End Condition: left > right
  return -1;
}
```

### Python

```python
def binarySearch(nums, target):
  if len(nums) == 0:
    return -1

  left, right = 0, len(nums) - 1
  while left <= right:
    mid = (left + right) // 2
    if nums[mid] == target:
      return mid
    elif nums[mid] < target:
      left = mid + 1
    else:
      right = mid - 1

  # End Condition: left > right
  return -1
```

## Version 2

### Java

```java
int binarySearch(int[] nums, int target) {
  if (nums == null || nums.length == 0) {
    return -1;
  }

  int left = 0, right = nums.length;
  while (left < right) {
    // int mid = (left + right) / 2;
    // int mid = (left + right) >> 1;
    int mid = left + ((right - left) / 2); // Prevent (left + right) overflow
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] < target) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }

  // Post-processing:
  // End Condition: left == right
  if (left != nums.length && nums[left] == target)
    return left;
  return -1;
}
```

### Python

```python
def binarySearch(nums, target):
  if len(nums) == 0:
    return -1

  left, right = 0, len(nums)
  while left < right:
    mid = (left + right) // 2
    if nums[mid] == target:
      return mid
    elif nums[mid] < target:
      left = mid + 1
    else:
      right = mid

  # Post-processing:
  # End Condition: left == right
  if left != len(nums) and nums[left] == target:
    return left
  return -1
```

## Version 3

### Java

```java
int binarySearch(int[] nums, int target) {
  if (nums == null || nums.length == 0) {
    return -1;
  }

  int left = 0, right = nums.length - 1;
  while (left + 1 < right) {
    // int mid = (left + right) / 2;
    // int mid = (left + right) >> 1;
    int mid = left + ((right - left) / 2); // Prevent (left + right) overflow
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] < target) {
      left = mid;
    } else {
      right = mid;
    }
  }

  // Post-processing:
  // End Condition: left + 1 == right
  if (nums[left] == target)
    return left;
  if (nums[right] == target)
    return right;
  return -1;
}
```

### Python

```python
def binarySearch(nums, target):
  if len(nums) == 0:
    return -1

  left, right = 0, len(nums) - 1
  while left + 1 < right:
    mid = (left + right) // 2
    if nums[mid] == target:
      return mid
    elif nums[mid] < target:
      left = mid
    else:
      right = mid

  # Post-processing:
  # End Condition: left + 1 == right
  if nums[left] == target:
    return left
  if nums[right] == target:
    return right
  return -1

```
