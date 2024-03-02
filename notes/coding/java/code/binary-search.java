/*
--------------------------------------------------------------------------------
https://www.reddit.com/r/leetcode/comments/y0r9n6/binary_search_while_left_right_vs_while_left_right/
https://stackoverflow.com/questions/30928268/binary-search-condition/30928332#30928332
--------------------------------------------------------------------------------
Both versions are correct, what differs is how we update "left" and "right" inside the loop

Usually it just depends on a implementation, e.g. if you pass right = arr.length
then you'd rather write while (left < right) than while (left <= right)
--------------------------------------------------------------------------------
Version 1: range [left, right)
------------------------------
int left = 0;
int right = n; // int right = arr.length;
while (left < right) {
  if (...) {
    left = mid + 1;
  } else {
    right = mid;
  }
}
return left;

Version 2: range [left, right]
------------------------------
int left = 0;
int right = n - 1;
while (left <= right) {
  if (...) {
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}
return left;

Version 2 seems to be more popular online

LeetCode Cheatsheet
-------------------
Version 1 == Duplicate Elements
Version 2 == Non-Duplicate Elements
--------------------------------------------------------------------------------
*/

import java.util.*;

//------------------------------------------------------------------------------
//                            Range = [left, right]
//------------------------------------------------------------------------------
class Solution {
  public int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n - 1; // int right = arr.length - 1;
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
    // "left" = insertion point
    return left;
  }
}

//------------------------------------------------------------------------------
//    Range = [left, right) + Duplicate Elements + Left-Most Insertion Point
//------------------------------------------------------------------------------
class Solution2 {
  public int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length;
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
}

//------------------------------------------------------------------------------
//    Range = [left, right) + Duplicate Elements + Right-Most Insertion Point
//------------------------------------------------------------------------------
class Solution3 {
  public int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length;
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
}

//------------------------------------------------------------------------------
//                  Find LOWER Bound / MINIMUM (Greedy Problem)
//------------------------------------------------------------------------------
// Find FIRST index >= target (V1)
class Solution4 {
  public int binarySearchForMin(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n - 1; // int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < target) {
        left = mid + 1;
      } else { //  if (arr[mid] >= target) {
        right = mid - 1;
      }
    }
    // return arr[left];
    return left;
  }
}

// Find FIRST index >= target (V2)
class Solution5 {
  public int binarySearchForMin(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < target) {
        left = mid + 1;
      } else { //  if (arr[mid] >= target) {
        right = mid;
      }
    }
    // return arr[left];
    return left;
  }
}

// Find FIRST index > target (V1)
class Solution6 {
  public int binarySearchForMin(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n - 1; // int right = arr.length;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= target) {
        left = mid + 1;
      } else { // if (arr[mid] > target) {
        right = mid - 1;
      }
    }
    // return arr[left];
    return left;
  }
}

// Find FIRST index > target (V2)
class Solution7 {
  public int binarySearchForMin(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] <= target) {
        left = mid + 1;
      } else { // if (arr[mid] > target) {
        right = mid;
      }
    }
    // return arr[left];
    return left;
  }
}

//------------------------------------------------------------------------------
//                  Find UPPER Bound / MAXIMUM (Greedy Problem)
//------------------------------------------------------------------------------
// Find LAST index <= target (V1)
class Solution8 {
  public int binarySearchForMax(int[] arr) {
    int n = arr.length;
    int left = 0;
    int right = n - 1; // int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > target) {
        right = mid - 1;
      } else { // if (arr[mid] <= target) {
        left = mid + 1;
      }
    }
    // return arr[right];
    return right;
  }
}

// Find LAST index <= target (V2)
class Solution8 {
  public int binarySearchForMax(int[] arr) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > target) {
        right = mid - 1;
      } else { // if (arr[mid] <= target) {
        left = mid;
      }
    }
    // return arr[right];
    return right;
  }
}

// Find LAST index < target (V1)
class Solution8 {
  public int binarySearchForMax(int[] arr) {
    int n = arr.length;
    int left = 0;
    int right = n - 1; // int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        right = mid - 1;
      } else { // if (arr[mid] < target) {
        left = mid + 1;
      }
    }
    // return arr[right];
    return right;
  }
}

// Find LAST index < target (V2)
class Solution9 {
  public int binarySearchForMax(int[] arr) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        right = mid - 1;
      } else { // if (arr[mid] < target) {
        left = mid;
      }
    }
    // return arr[right];
    return right;
  }
}

//------------------------------------------------------------------------------
//      Find First Index of Value > Target (Target = Exclusive Lower Bound)
//------------------------------------------------------------------------------
// Range = (target, std::max_element(nums)]
class Solution10 {
  public int func(int[] arr) {
    int idx = binarySearch(arr, value);
    if (idx != arr.length) {
      //...
    }
  }

  public int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length;
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
}

//------------------------------------------------------------------------------
//      Find First Index of Value < Target  (Target = Exclusive Upper Bound)
//------------------------------------------------------------------------------
// Range = [Math.min(nums[]), target)
class Solution11 {
  public int func(int[] arr) {
    int idx = binarySearch(arr, value);
    if (idx != -1) {
      //...
    }
  }

  public int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int left = 0;
    int right = n; // int right = arr.length;
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
}
