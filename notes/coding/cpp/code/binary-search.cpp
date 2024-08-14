/*
--------------------------------------------------------------------------------
https://www.reddit.com/r/leetcode/comments/y0r9n6/binary_search_while_left_right_vs_while_left_right/
https://stackoverflow.com/questions/30928268/binary-search-condition/30928332#30928332
--------------------------------------------------------------------------------
Both versions are correct, what differs is how we update "left" and "right" inside the loop

Usually it just depends on a implementation, e.g. if you pass right = arr.length
then you'd rather write while (left < right) than while (left <= right)
--------------------------------------------------------------------------------
Version 1
---------
while (left < right) is used when you're searching the range [left, right)
left = mid + 1
right = mid

Version 2
---------
while (left <= right) is used when you're searching the range [left, right]
left = mid + 1
right = mid - 1

Version 2 seems to be more popular online

LeetCode Cheatsheet
-------------------
Version 1 == Duplicate Elements
Version 2 == Non-Duplicate Elements
--------------------------------------------------------------------------------
*/

#include <bits/stdc++.h>

//------------------------------------------------------------------------------
//                            Range = [left, right]
//------------------------------------------------------------------------------
class Solution {
public:
  int binarySearch(std::vector<int> &arr, int target) {
    int left = 0;
    int right = int(arr.size()) - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    // "left" = the insertion point
    return left;
  }
};

//------------------------------------------------------------------------------
//              Range = [left, right) + Left-Most Insertion Point
//------------------------------------------------------------------------------
class Solution2 {
public:
  int binarySearch(std::vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
};

//------------------------------------------------------------------------------
//              Range = [left, right) + Right-Most Insertion Point
//------------------------------------------------------------------------------
class Solution3 {
public:
  int binarySearch(std::vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
};

//------------------------------------------------------------------------------
//                          Find LOWER Bound / Minimum
//------------------------------------------------------------------------------
class Solution4 {
public:
  int binarySearchForMin(std::vector<int> &arr) {
    int left = MINIMUM_POSSIBLE_VALUE;
    int right = MAXIMUM_POSSIBLE_VALUE;
    int nextIndex = -1;
    // int nextIndex = INT_MAX;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (check(mid)) {
        right = mid - 1;
        nextIndex = mid;
      } else {
        left = mid + 1;
      }
    }
    // return nextIndex;
    return left;
  }

  // This function is implemented depending on the problem
  bool check(int x) {
    return BOOLEAN;
  }
};

//------------------------------------------------------------------------------
//                          Find UPPER Bound / Maximum
//------------------------------------------------------------------------------
class Solution5 {
public:
  int binarySearchForMax(std::vector<int> &arr) {
    int left = MINIMUM_POSSIBLE_VALUE;
    int right = MAXIMUM_POSSIBLE_VALUE;
    int nextIndex = -1;
    // int nextIndex = INT_MAX;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (check(mid)) {
        left = mid + 1;
        nextIndex = mid;
      } else {
        right = mid - 1;
      }
    }
    // return nextIndex;
    return right;
  }

  // This function is implemented depending on the problem
  bool check(int x) {
    return BOOLEAN;
  }
};

//------------------------------------------------------------------------------
//      Find First Index of Value > Target (Target = Exclusive Lower Bound)
//------------------------------------------------------------------------------
// Range = (target, std::max_element(nums)]
class Solution6 {
public:
  int func(std::vector<int> &arr) {
    int idx = binarySearch(arr, value);
    if (idx != arr.size()) {
      //...
    }
  }

  int binarySearch(std::vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= target) { // Keep moving "left" forwards to get first index of value > target
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
};

//------------------------------------------------------------------------------
//      Find First Index of Value < Target  (Target = Exclusive Upper Bound)
//------------------------------------------------------------------------------
// Range = [Math.min(nums[]), target)
class Solution6 {
public:
  int func(std::vector<int> &arr) {
    int idx = binarySearch(arr, value);
    if (idx != -1) {
      //...
    }
  }

  int binarySearch(std::vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) { // Keep moving "right" backwards to get first index of value < target
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return right;
  }
};
