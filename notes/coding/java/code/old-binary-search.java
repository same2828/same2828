/*
--------------------------------------------------------------------------------
L + ((R-L) / 2) == L + (R/2) - (L/2) == (L/2) + (R/2) == (L + R) / 2
--------------------------------------------------------------------------------
                                    Version 4
--------------------------------------------------------------------------------
Refer to 875.koko-eating-bananas for Version 4 (where we find lower bound given a target, 
i.e. find lowest valid value that is <= target)
--------------------------------------------------------------------------------

--------------------------------------------------------------------------------
*/

//------------------------------------------------------------------------------
//                          Binary Search To Find VALUE
//------------------------------------------------------------------------------
// Version 1
//----------
class Solution {
  int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
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
}

// Version 2
//----------
class Solution2 {
  int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length;
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
    if (left != nums.length && nums[left] == target) {
      return left;
    }
    return -1;
  }
}

// Version 3
//----------
class Solution3 {
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
    if (nums[left] == target) {
      return left;
    }
    if (nums[right] == target) {
      return right;
    }
    return -1;
  }
}

//------------------------------------------------------------------------------
//                        Binary Search To Find UPPER Bound
//------------------------------------------------------------------------------
// 1062.longest-repeating-substring

// Version 1
//----------
class Solution4 {
  // public int findLongestRepeatingSubstring(String s, int substrLength) {
  //   HashSet<Integer> set = new HashSet();
  //   for (int i = 0; i <= s.length() - substrLength; i++) {
  //     String substr = s.substring(i, i + substrLength);
  //     if (set.contains(substr)) {
  //       return i;
  //     }
  //     set.add(substr);
  //   }
  //   return -1;
  // }

  public int binarySearch(String s) {
    int n = s.length();
    int left = 0;
    int right = n;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (search(s, mid) != -1) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    // End Condition: left > right
    return left - 1; // left - 1 = length of longest repeating substring in s
    // return right // Also works
  }
}

// Version 2
//----------
class Solution5 {
  // public int findLongestRepeatingSubstring(String s, int substrLength) {
  //   HashSet<Integer> set = new HashSet();
  //   for (int i = 0; i <= s.length() - substrLength; i++) {
  //     String substr = s.substring(i, i + substrLength);
  //     if (set.contains(substr)) {
  //       return i;
  //     }
  //     set.add(substr);
  //   }
  //   return -1;
  // }

  public int binarySearch(String s) {
    int n = s.length();
    int left = 0;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (search(s, mid) != -1) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    // End Condition: left == right
    return left - 1; // left - 1 = length of longest repeating substring in s
    // return right - 1 // Also works
  }
}

//------------------------------------------------------------------------------
//                      Binary Search To Find LOWER Bound
//------------------------------------------------------------------------------
// 875.koko-eating-bananas

// Version 1
//----------
class Solution6 {
  public int minEatingSpeed(int[] piles, int h) {
    // Initalize the left and right boundaries 
    int left = 1, right = 1;
    for (int pile : piles) {
      right = Math.max(right, pile);
    }
    while (left < right) {
      // int middle = (left + right) / 2;
      int middle = left + (right - left) / 2;
      int hoursSpent = 0;
      for (int pile : piles) {
        hoursSpent += Math.ceil((double) pile / middle);
      }
      // If hoursSpent <= h, then minWorkableSpeed is to LEFT of MIDDLE (and cut search space by half)
      if (hoursSpent <= h) {
        right = middle;
        // If hoursSpent > h, then minWorkableSpeed is to RIGHT of MIDDLE (and cut search space by half)
      } else {
        left = middle + 1;
      }
    }
    // End Condition: left >= right
    // Keep increasing LEFT to find lower bound hence RIGHT holds last valid value
    return right;
  }
}

// Version 2
//----------
class Solution7 {
  public int minEatingSpeed(int[] piles, int h) {
    // Initalize the left and right boundaries 
    int left = 1, right = 1;
    for (int pile : piles) {
      right = Math.max(right, pile);
    }
    while (left <= right) {
      // int middle = (left + right) / 2;
      int middle = left + (right - left) / 2;
      int hoursSpent = 0;
      for (int pile : piles) {
        hoursSpent += Math.ceil((double) pile / middle);
      }
      // If hoursSpent <= h, then minWorkableSpeed is to LEFT of MIDDLE (and cut search space by half)
      if (hoursSpent <= h) {
        right = middle - 1;
        // If hoursSpent > h, then minWorkableSpeed is to RIGHT of MIDDLE (and cut search space by half)
      } else {
        left = middle + 1;
      }
    }
    // End Condition: right < left || left > right
    // Keep decreasing RIGHT to find lower bound hence LEFT holds last valid value
    return left;
  }
}
