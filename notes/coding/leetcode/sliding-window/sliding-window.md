# Table of Contents

- [Table of Contents](#table-of-contents)
- [Sliding Window](#sliding-window)
- [The 4 Patterns to Memorize](#the-4-patterns-to-memorize)
- [1. Longest / Maximum Window](#1-longest--maximum-window)
  - [Example - Longest Substring Without Repeating Characters](#example---longest-substring-without-repeating-characters)
  - [Optimization: Store Last Seen Index](#optimization-store-last-seen-index)
- [2. Shortest / Minimum Window](#2-shortest--minimum-window)
  - [Example - Minimum Size Subarray Sum](#example---minimum-size-subarray-sum)
    - [Dealing/Handling with Negative Numbers](#dealinghandling-with-negative-numbers)
- [3. Fixed Window Size K](#3-fixed-window-size-k)
  - [Example - Maximum Sum of Subarray of Size K](#example---maximum-sum-of-subarray-of-size-k)
- [4. At Most K](#4-at-most-k)
  - [Example - Longest Substring with At Most K Distinct Characters](#example---longest-substring-with-at-most-k-distinct-characters)
- [5. Exactly K](#5-exactly-k)
  - [At Most K vs Exactly K](#at-most-k-vs-exactly-k)
  - [Example - Subarrays With K Different Integers](#example---subarrays-with-k-different-integers)
- [Why `right - left + 1` Counts Subarrays](#why-right---left--1-counts-subarrays)
- [Minimum Window / Cover Problems](#minimum-window--cover-problems)
  - [Example - Minimum Window Substring](#example---minimum-window-substring)
- [Longest Repeating Character Replacement](#longest-repeating-character-replacement)
  - [Generalized](#generalized)
- [Monotonic Deque (FixedSize Sliding Window)](#monotonic-deque-fixedsize-sliding-window)
  - [Why Remove Smaller Elements?](#why-remove-smaller-elements)
  - [Monotonic Decreasing Deque for Maximum](#monotonic-decreasing-deque-for-maximum)
  - [Monotonic Increasing Deque for Minimum](#monotonic-increasing-deque-for-minimum)
  - [Summary](#summary)
- [Count Frequencies in a Fixed Window](#count-frequencies-in-a-fixed-window)
  - [Example Permutation in Strine](#example-permutation-in-strine)
- [Product / Sum Constraints](#product--sum-constraints)
- [Sliding Window Constraints/Limitations](#sliding-window-constraintslimitations)
  - [Rule](#rule)
- [HashMap vs Array](#hashmap-vs-array)
- [Common Mistakes](#common-mistakes)
  - [Forgetting `+1`](#forgetting-1)
  - [Using `if` instead of `while`](#using-if-instead-of-while)
  - [Updating at the wrong time](#updating-at-the-wrong-time)
  - [Letting `left` move backwards](#letting-left-move-backwards)
    - [Ignoring monotonicity](#ignoring-monotonicity)
- [Sliding Window Invariant](#sliding-window-invariant)
  - [Longest](#longest)
  - [Shortest](#shortest)
- [Decision Tree](#decision-tree)
- [Complexity](#complexity)
- [Space Complexity](#space-complexity)
  - [Array frequency](#array-frequency)
  - [HashMap](#hashmap)
  - [Deque](#deque)
- [Cheat Sheet](#cheat-sheet)
- [Pattern Recognition Cheat Sheet](#pattern-recognition-cheat-sheet)
  - ["Longest substring with..."](#longest-substring-with)
  - ["Maximum length after at most K changes"](#maximum-length-after-at-most-k-changes)
  - ["Minimum length subarray whose..."](#minimum-length-subarray-whose)
  - ["Minimum window containing..."](#minimum-window-containing)
  - ["Exactly K..."](#exactly-k)
  - ["Every window of size K"](#every-window-of-size-k)
  - ["Maximum/minimum in each window"](#maximumminimum-in-each-window)
- [Sliding Window Checklist](#sliding-window-checklist)
  - [Template 1 - Longest](#template-1---longest)
  - [Template 2 - Shortest](#template-2---shortest)
  - [Template 3 - At Most K Count](#template-3---at-most-k-count)
  - [Template 4 - Fixed K](#template-4---fixed-k)
  - [Template 5 - Monotonic Deque](#template-5---monotonic-deque)

# Sliding Window

Sliding Window = **two pointers maintaining a contiguous window `[left, right]`**.

Core idea:

```text
EXPAND right
↓
Update window state
↓
Repair / shrink with left if needed
↓
Update answer
```

# The 4 Patterns to Memorize

| Goal                          | Pattern                      |
| ----------------------------- | ---------------------------- |
| **Longest / Maximum length**  | Shrink while **INVALID**     |
| **Shortest / Minimum length** | Shrink while **VALID**       |
| **Exactly K**                 | `atMost(K) - atMost(K - 1)`  |
| **Fixed window K**            | Keep window size exactly `K` |

For max/min inside every fixed window: use a **monotonic deque**.

# 1. Longest / Maximum Window

Use for longest substring/subarray, maximum window length, or "at most K" problems.

```java
int left = 0;
int result = 0;
for (int right = 0; right < n; right++) {
  // add right
  while (left > 0/* invalid */) {
    // remove left
    left++;
  }
  result = Math.max(result, right - left + 1);
}
```

```cpp
int left = 0;
int result = 0;

for (int right = 0; right < n; right++) {
  // add right
  while (/* invalid */) {
    // remove left
    left++;
  }
  result = std::max(result, right - left + 1);
}
```

> **LONGEST -> shrink while INVALID**

Common problems:

- LeetCode 3 - Longest Substring Without Repeating Characters
- LeetCode 424 - Longest Repeating Character Replacement
- LeetCode 1004 - Max Consecutive Ones III
- LeetCode 340 - Longest Substring with At Most K Distinct Characters

## Example - Longest Substring Without Repeating Characters

Invalid when:

```text
count[s[right]] > 1
```

```java
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int result = 0;
    int[] count = new int[128];
    for (int right = 0; right < s.length(); right++) {
      count[s.charAt(right)]++;
      while (count[s.charAt(right)] > 1) {
        count[s.charAt(left)]--;
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }
}
```

```cpp
class Solution {
public:
  int lengthOfLongestSubstring(std::string s) {
    int left = 0;
    int result = 0;
    std::vector<int> count(128, 0);
    for (int right = 0; right < s.size(); right++) {
      count[s[right]]++;
      while (count[s[right]] > 1) {
        count[s[left]]--;
        left++;
      }
      result = std::max(result, right - left + 1);
    }
    return result;
  }
};

```

## Optimization: Store Last Seen Index

For "longest substring without repeating characters", we don't actually need to move `left` one character at a time.

Instead, remember the most recent index of every character.

For example:

```text
a b c a
0 1 2 3
```

When we see `a` at index `3`, we know the previous `a` was at index `0`.

Therefore:

```text
left = max(left, previous_a + 1)
     = max(0, 0 + 1)
```

Instead of:

```text
left++
left++
left++
```

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int result = 0;
    Map<Character, Integer> lastSeen = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      if (lastSeen.containsKey(c)) {
        left = Math.max(left, lastSeen.get(c) + 1);
      }
      lastSeen.put(c, right);
      result = Math.max(result, right - left + 1);
    }
    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  int lengthOfLongestSubstring(std::string s) {
    int left = 0;
    int result = 0;
    std::vector<int> lastSeen(128, -1);
    for (int right = 0; right < s.size(); right++) {
      unsigned char c = s[right];
      left = std::max(left, lastSeen[c] + 1);
      lastSeen[c] = right;
      result = std::max(result, right - left + 1);
    }
    return result;
  }
};
```

Notice the:

```java
left = Math.max(left, lastSeen.get(c) + 1);
```

rather than:

```java
left = lastSeen.get(c) + 1;
```

Why?

Because `left` should **never move backwards**.

# 2. Shortest / Minimum Window

Use for minimum length, shortest subarray, or minimum window.

```java
int left = 0;
int result = Integer.MAX_VALUE;

for (int right = 0; right < n; right++) {
  // add right
  while (/* valid */) {
    result = Math.min(result, right - left + 1);
    // remove left
    left++;
  }
}
```

```cpp
int left = 0;
int result = INT_MAX;

for (int right = 0; right < n; right++) {
    // add right
    while (/* valid */) {
      result = std::min(result, right - left + 1);
      // remove left
      left++;
    }
}
```

> **SHORTEST -> shrink while VALID**

## Example - Minimum Size Subarray Sum

LeetCode 209.Minimum Size Subarray Sum

Condition:

```text
sum >= target
```

This classic version works because **all numbers are positive**:

```text
move right -> sum increases
move left  -> sum decreases
```

```java
class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int sum = 0;
    int result = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];

      while (sum >= target) {
        result = Math.min(result, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
```

```cpp
class Solution {
public:
  int minSubArrayLen(int target, vector<int> &nums) {
    int left = 0;
    int sum = 0;
    int result = INT_MAX;

    for (int right = 0; right < nums.size(); right++) {
      sum += nums[right];

      while (sum >= target) {
        result = min(result, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    return result == INT_MAX ? 0 : result;
  }
};
```

### Dealing/Handling with Negative Numbers

What changes with negative numbers?

The problem becomes:

Find the shortest subarray whose sum is at least target.

For arbitrary integers, the standard solution uses prefix sums + a monotonic deque.

Let

```
prefix[i] = nums[0] + nums[1] + ... + nums[i-1]
```

equal the prefix sum UP TO but NOT including `nums[i]`

Then the sum of subarray `[j, i-1]` is:

```
prefix[i] - prefix[j]
```

We want:

```txt
prefix[i] - prefix[j] >= target
```

or equivalently:

```
prefix[j] <= prefix[i] - target
```

We maintain candidate prefix indices in a deque.

```java
class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    long[] prefixSum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    Deque<Integer> dq = new ArrayDeque<>();
    int result = n + 1;
    for (int i = 0; i <= n; i++) {
      // Found a valid subarray
      while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= target) {
        result = Math.min(result, i - dq.pollFirst()); // no +1 because we are NOT including index i
      }
      // Remove earlier prefixSums that are worse: the currrent prefixSum is smaller (better for reaching target) and occurs later (gives a shorter subarray)
      while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
        dq.pollLast();
      }
      // offerLast because dq needs to maintain prefix indices in increasing order from front -> back.
      dq.offerLast(i);
    }
    return result == n + 1 ? 0 : result;
  }
}
```

Summary

```
nums[i] >= 0
    -> sliding window / two pointers
    -> O(n)

nums[i] can be negative
    -> prefix sum + monotonic deque
    -> O(n)
```

# 3. Fixed Window Size K

Use when every window must have exactly `k` elements.

Sometimes the window has exactly size `k`.

There is no "invalid/valid" concept that determines the size.

The window is always: `[right - k + 1, right]`

```
right - (right - k + 1) + 1
= right - right + k - 1 + 1
= k
```

Once the window exceeds size `k`, remove the leftmost element.

Template:

```java
int left = 0;

for (int right = 0; right < n; right++) {
    // add right
    if (right - left + 1 > k) {
      // remove left
      left++;
    }
    if (right - left + 1 == k) {
      // process window
    }
}
```

Common problems:

- LeetCode 567 - Permutation in String
- LeetCode 438 - Find All Anagrams in a String
- LeetCode 239 - Sliding Window Maximum

## Example - Maximum Sum of Subarray of Size K

Suppose:

```text
nums = [2,1,5,1,3,2]
k = 3
```

Windows:

```text
[2,1,5] = 8
[1,5,1] = 7
[5,1,3] = 9
[1,3,2] = 6
```

Answer: 9

```java
class Solution {
  public int maxSumSubarrayOfSizeK(int[] nums, int k) {
    int left = 0;
    int sum = 0;
    int result = Integer.MIN_VALUE;
    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      // Window is too large
      if (right - left + 1 > k) {
        sum -= nums[left];
        left++;
      }
      // Window size is exactly k
      if (right - left + 1 == k) {
        result = Math.max(result, sum);
      }
    }
    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int maxSumSubarrayOfSizeK(std::vector<int> &nums, int k) {
    int left = 0;
    int sum = 0;
    int result = INT_MIN;
    for (int right = 0; right < nums.size(); right++) {
      sum += nums[right];
      // Window is too large
      if (right - left + 1 > k) {
        sum -= nums[left];
        left++;
      }
      // Window size is exactly k
      if (right - left + 1 == k) {
        result = max(result, sum);
      }
    }
    return result;
  }
};
```

# 4. At Most K

A huge pattern:

```text
maximize length
subject to constraint <= K
```

Examples:

- at most K zeros
- at most K distinct characters
- at most K replacements
- at most K odd numbers

Template:

```java
add(right);

while (constraint > k) {
  remove(left);
  left++;
}

result = Math.max(result, right - left + 1);
```

> **AT MOST K -> longest valid window**

## Example - Longest Substring with At Most K Distinct Characters

```java
import java.util.*;

class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int left = 0;
    int result = 0;
    Map<Character, Integer> count = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);
      // Invalid if more than k distinct characters
      while (count.size() > k) {
        char leftChar = s.charAt(left);
        count.put(leftChar, count.get(leftChar) - 1);
        if (count.get(leftChar) == 0) {
          count.remove(leftChar);
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  int lengthOfLongestSubstringKDistinct(std::string s, int k) {
    int left = 0;
    int result = 0;
    std::unordered_map<char, int> count;
    for (int right = 0; right < s.size(); right++) {
      char rightChar = s[right];
      count[rightChar]++;
      // Invalid if distinct characters > k
      while (count.size() > k) {
        char leftChar = s[left];
        count[leftChar]--;
        if (count[leftChar] == 0) {
          count.erase(leftChar);
        }
        left++;
      }
      result = max(result, right - left + 1);
    }
    return result;
  }
};
```

# 5. Exactly K

## At Most K vs Exactly K

This is another very important LeetCode trick.

Sometimes a problem asks:

> Number of subarrays with **exactly K** something

Sliding Window naturally handles **at most K** much more easily

Use:

```text
exactly(K) = atMost(K) - atMost(K - 1)
```

## Example - Subarrays With K Different Integers

LeetCode 992.

We want:

```text
exactly K distinct integers
```

Instead of directly counting exactly `K`, calculate:

```text
number of subarrays with at most K
-
number of subarrays with at most K - 1
```

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int subarraysWithKDistinct(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
  }

  private int atMost(int[] nums, int k) {
    if (k == 0) {
      return 0;
    }
    int left = 0;
    int result = 0;
    Map<Integer, Integer> count = new HashMap<>();
    for (int right = 0; right < nums.length; right++) {
      count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
      while (count.size() > k) {
        count.put(nums[left], count.get(nums[left]) - 1);
        if (count.get(nums[left]) == 0) {
          count.remove(nums[left]);
        }
        left++;
      }
      // Every subarray ending at right
      // starting from left..right is valid.
      //
      // Number of valid subarrays:
      // right - left + 1
      result += right - left + 1;
    }

    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int subarraysWithKDistinct(std::vector<int> &nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
  }

private:
  int atMost(std::vector<int> &nums, int k) {
    if (k == 0) {
      return 0;
    }
    int left = 0;
    int result = 0;
    std::unordered_map<int, int> count;
    for (int right = 0; right < nums.size(); right++) {
      count[nums[right]]++;
      while (count.size() > k) {
        count[nums[left]]--;
        if (count[nums[left]] == 0) {
          count.erase(nums[left]);
        }
        left++;
      }
      // Number of valid subarrays ending at right
      result += right - left + 1;
    }
    return result;
  }
};
```

# Why `right - left + 1` Counts Subarrays

When `[left, right]` is valid, the number of valid subarrays **ending at `right`** is:

```text
right - left + 1
```

Example:

```text
left = 2
right = 5

[2..5]
[3..5]
[4..5]
[5..5]

count = 4
```

which is:

```text
right - left + 1
= 5 - 2 + 1
= 4
```

# Minimum Window / Cover Problems

Some of the hardest sliding-window problems involve a window that must **contain enough of certain elements**.

## Example - Minimum Window Substring

LeetCode 76

> Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string ""

Given:

```text
s = "ADOBECODEBANC"
t = "ABC"
```

Answer:

```text
min substring = "BANC"
```

The window is valid when it contains all characters required by `t`.

This is still:

```text
expand right
↓
become valid
↓
shrink left while valid
↓
record smallest valid window
```

```text
expand right
↓
window becomes VALID
↓
while VALID:
  update minimum
  remove left
```

Usually maintain:

```text
need[c]   = required frequency
window[c] = current frequency
```

We also track: `formed` which tells us how many character requirements are currently satisfied.

```java
class Solution {
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }
    Map<Character, Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    // Build required character frequencies
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    int left = 0;
    // Number of character requirements currently satisfied
    int formed = 0;
    // Number of distinct character requirements
    int required = need.size();
    int bestLength = Integer.MAX_VALUE;
    int bestLeft = 0;
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      // Add c to window
      window.put(c, window.getOrDefault(c, 0) + 1);
      // Requirement for c has just been satisfied
      if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
        formed++;
      }
      // Window is valid
      while (formed == required) {
        // Update answer
        if (right - left + 1 < bestLength) {
          bestLength = right - left + 1;
          bestLeft = left;
        }
        // Remove s[left]
        char leftChar = s.charAt(left);
        window.put(
          leftChar,
          window.get(leftChar) - 1);
        // Removing this character broke a requirement
        if (need.containsKey(leftChar)
          && window.get(leftChar) < need.get(leftChar)) {
          formed--;
        }
        left++;
      }
    }

    return bestLength == Integer.MAX_VALUE
      ? ""
      : s.substring(bestLeft, bestLeft + bestLength);
  }
}
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  std::string minWindow(std::string s, std::string t) {
    if (t.size() > s.size()) {
      return "";
    }
    std::unordered_map<char, int> need;
    std::unordered_map<char, int> window;
    // Required frequencies
    for (char c : t) {
      need[c]++;
    }
    int left = 0;
    int formed = 0;
    int required = need.size();
    int bestLength = INT_MAX;
    int bestLeft = 0;
    for (int right = 0; right < s.size(); right++) {
      char c = s[right];
      // Add c
      window[c]++;
      // Requirement satisfied
      if (need.count(c) && window[c] == need[c]) {
        formed++;
      }
      // Window is valid
      while (formed == required) {
        // Update best answer
        if (right - left + 1 < bestLength) {
          bestLength = right - left + 1;
          bestLeft = left;
        }
        // Remove left character
        char leftChar = s[left];
        window[leftChar]--;
        // Requirement is no longer satisfied
        if (need.count(leftChar) && window[leftChar] < need[leftChar]) {
          formed--;
        }
        left++;
      }
    }
    if (bestLength == INT_MAX) {
      return "";
    }
    return s.substr(bestLeft, bestLength);
  }
};
```

# Longest Repeating Character Replacement

LeetCode 424.

Problem:

> You can replace at most `k` characters. Find the longest substring that can become all the same character.

Example:

```text
s = "AABABBA"
k = 1
```

Answer:

```text
4
```

For a window to be valid:

```text
windowLength - maxFreqOfMostCommonChar <= k
```

because everything except the most frequent character must be replaced.

Why?

Suppose:

```text
window = "AABAB"
```

Length:

```text
5
```

Most frequent character:

```text
A -> 4
```

So we need:

```text
5 - 4 = 1
```

replacements.

```java
class Solution {
  public int characterReplacement(String s, int k) {
    int left = 0;
    int result = 0;
    int[] count = new int[26];
    int maxFrequency = 0;
    for (int right = 0; right < s.length(); right++) {
      int index = s.charAt(right) - 'A';
      count[index]++;
      maxFrequency = Math.max(maxFrequency, count[index]);
      // Characters that must be replaced
      int numReplacements = (right - left + 1) - maxFrequency;
      // Invalid
      while (numReplacements > k) {
        count[s.charAt(left) - 'A']--;
        left++;
        numReplacements = (right - left + 1) - maxFrequency;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  int characterReplacement(std::string s, int k) {
    int left = 0;
    int result = 0;
    std::vector<int> count(26, 0);
    int maxFrequency = 0;
    for (int right = 0; right < s.size(); right++) {
      int index = s[right] - 'A';
      count[index]++;
      maxFrequency = max(maxFrequency, count[index]);
      int numReplacements = (right - left + 1) - maxFrequency;
      while (numReplacements > k) {
        count[s[left] - 'A']--;
        left++;
        numReplacements = (right - left + 1) - maxFrequency;
      }
      result = max(result, right - left + 1);
    }

    return result;
  }
};
```

## Generalized

A very general way to recognize sliding window is:

```text
maximize length
subject to cost <= k
```

Examples:

```text
# zeros <= k
# distinct chars <= k
# replacements <= k
# odd numbers <= k
# bad elements <= k
```

The code almost always becomes:

```java
add(right);

while (cost > k) {
  remove(left);
  left++;
}

result = Math.max(result, right - left + 1);
```

# Monotonic Deque (FixedSize Sliding Window)

Use when you need the **maximum/minimum value in every fixed-size window of size `k`**.

For maximum:

> Keep deque values in **decreasing order**.

The front is always the maximum.

---

A normal sliding window can efficiently track:

- sum
- frequency
- number of distinct values
- etc.

But what if you need:

> maximum value inside every window of size `k`

Example:

```text
nums = [1,3,-1,-3,5,3,6,7]
k = 3
```

Answer:

```text
[3,3,5,5,6,7]
```

A naive solution scans every window:

```text
[1,3,-1] -> max = 3
[3,-1,-3] -> max = 3
...
```

That is:

```text
O(nk)
```

We can do it in:

```text
O(n)
```

using a **monotonic decreasing deque**.

Maintain indices in the deque such that:

```text
nums[dq[0]] >= nums[dq[1]] >= nums[dq[2]] ...
```

Therefore:

```text
dq.front()
```

always gives the maximum value.

For example:

```text
nums = [1, 3, -1]
```

After processing:

```text
deque = [3, -1]
          ↑
        maximum
```

## Why Remove Smaller Elements?

Suppose the deque contains:

```text
[5, 3, 2]
```

and the new number is:

```text
6
```

Then:

```text
[5, 3, 2]
```

are all useless.

Why?

Because `6`:

- is larger than all of them
- is newer, so it will remain in the window longer

So we remove them:

```text
[6]
```

This is the key idea behind the monotonic deque.

## Monotonic Decreasing Deque for Maximum

```java
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();
    for (int right = 0; right < n; right++) {
      // Remove indices outside the window
      while (!dq.isEmpty() && dq.peekFirst() <= right - k) {
        dq.pollFirst();
      }
      // Remove smaller values from the back
      while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {
        dq.pollLast();
      }
      // Add current index
      dq.offerLast(right);
      // Window has size k
      if (right >= k - 1) {
        result[right - k + 1] = nums[dq.peekFirst()];
      }
    }

    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  std::vector<int> maxSlidingWindow(std::vector<int> &nums, int k) {
    int n = nums.size();
    std::vector<int> result;
    std::deque<int> dq;
    for (int right = 0; right < n; right++) {
      // Remove indices outside the window
      while (!dq.empty() && dq.front() <= right - k) {
        dq.pop_front();
      }
      // Remove smaller values
      while (!dq.empty() && nums[dq.back()] <= nums[right]) {
        dq.pop_back();
      }
      // Add current index
      dq.push_back(right);
      // Window size is k
      if (right >= k - 1) {
        result.push_back(nums[dq.front()]);
      }
    }
    return result;
  }
};
```

Complexity:

```text
Time:  O(n)
Space: O(k)
```

Each element enters and leaves the deque at most once.

## Monotonic Increasing Deque for Minimum

For minimum, reverse the comparison:

```cpp
while (!dq.empty() && nums[dq.back()] >= nums[right]) { // Minimum
  dq.pop_back();
}
```

instead of

```cpp
while (!dq.empty() && nums[dq.back()] <= nums[right]) { // Maximum
  dq.pop_back();
}
```

## Summary

**Maximum**:

```text
decreasing deque
```

```text
[large -> small]
```

**Minimum**:

```text
increasing deque
```

```text
[small -> large]
```

# Count Frequencies in a Fixed Window

A common string problem is:

> Does some substring of length `k` contain the same character frequencies as target?

This shows up in:

- permutation in string
- find all anagrams
- frequency matching

Examples:

- LeetCode 567 - Permutation in String
- LeetCode 438 - Find All Anagrams in a String

The window size is fixed:

```text
window size = t.length()
```

and we maintain frequencies.

## Example Permutation in Strine

LeetCode 567. Permutation in String

> Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise. In other words, return true if one of s1's permutations is the substring of s2.

```text
s1 = "ab"
s2 = "eidbaooo"
```

Return `true` because:

```text
"ba"
```

is a permutation of `"ab"`.

```java
class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] need = new int[26];
    int[] slidingWindow = new int[26];
    for (char ch : s1.toCharArray()) {
      need[ch - 'a']++;
    }
    int k = s1.length();
    for (int right = 0; right < s2.length(); right++) {
      // Add right
      slidingWindow[s2.charAt(right) - 'a']++;
      // Keep slidingWindow size <= k
      if (right >= k) {
        slidingWindow[s2.charAt(right - k) - 'a']--;
      }
      // Check fixed-size slidingWindow
      if (right >= k - 1 && same(need, slidingWindow)) {
        return true;
      }
    }
    return false;
  }

  private boolean same(int[] a, int[] b) {
    for (int i = 0; i < 26; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
}
```

```cpp
#include <bits/stdc++.h>

class Solution {
public:
  bool checkInclusion(std::string s1, std::string s2) {
    if (s1.size() > s2.size()) {
      return false;
    }
    std::vector<int> need(26, 0);
    std::vector<int> window(26, 0);
    for (char &c : s1) {
      need[c - 'a']++;
    }
    int k = s1.size();
    for (int right = 0; right < s2.size(); right++) {
      // Add right
      window[s2[right] - 'a']++;
      // Remove element outside fixed-size window
      if (right >= k) {
        window[s2[right - k] - 'a']--;
      }
      if (right >= k - 1 && need == window) {
        return true;
      }
    }
    return false;
  }
};
```

# Product / Sum Constraints

Sliding window can also work for products when all values are positive.

Example:

> Number of subarrays with product less than `k`

LeetCode 713.

Because all numbers are positive:

```text
expand right -> product increases
shrink left  -> product decreases
```

That gives us the required monotonic behavior.

```java
class Solution {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int left = 0;
    int product = 1;
    int result = 0;
    for (int right = 0; right < nums.length; right++) {
      product *= nums[right];
      // Invalid
      while (product >= k) {
        product /= nums[left];
        left++;
      }
      // Every subarray ending at right
      // and starting between left..right is valid
      result += right - left + 1;
    }
    return result;
  }
}
```

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int numSubarrayProductLessThanK(vector<int> &nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int left = 0;
    long long product = 1;
    int result = 0;
    for (int right = 0; right < nums.size(); right++) {
      product *= nums[right];
      while (product >= k) {
        product /= nums[left];
        left++;
      }
      result += right - left + 1;
    }
    return result;
  }
};
```

# Sliding Window Constraints/Limitations

Not every subarray problem can use Sliding Window.

For example:

```text
nums = [2, -1, 2]
```

If the condition is based on the sum, adding an element does not necessarily increase the sum.

For arbitrary integers:

```text
sum += nums[right]
```

does not guarantee monotonicity.

Likewise, removing from the left does not necessarily behave predictably.

So this:

```java
while (sum >= target) {
  ...
}
```

is not automatically valid for arbitrary positive/negative arrays.

## Rule

Classic sum-based sliding window generally requires a condition with useful monotonic behavior, such as:

```text
all numbers positive
```

When negative numbers are present, you may need:

- prefix sums
- prefix-sum + deque
- binary search
- hash maps
- monotonic stack/deque
- other techniques

# HashMap vs Array

Use an array when the values come from a small known domain.

Examples:

```text
'a' - 'z'   -> int[26]
'A' - 'Z'   -> int[26]
ASCII       -> int[128]
```

Example:

```java
int[] count = new int[26];

count[s.charAt(right) - 'a']++;
```

Use a `HashMap` when:

- values are arbitrary integers
- character set is unknown/large
- you need dynamic keys

```java
Map<Integer, Integer> count = new HashMap<>();
```

If `map.size()` represents distinct elements, remove zero-count entries:

```java
if (count.get(x) == 0) {
  count.remove(x);
}
```

# Common Mistakes

## Forgetting `+1`

Correct:

```java
right - left + 1
```

## Using `if` instead of `while`

Usually:

```java
while (invalid) {
  remove(left);
  left++;
}
```

because `left` may need to move multiple times.

## Updating at the wrong time

Longest:

```java
while (invalid) {
  remove(left);
  left++;
}
updateMax();
```

Shortest:

```java
while (valid) {
  updateMin();
  remove(left);
  left++;
}
```

## Letting `left` move backwards

With last-seen indices:

```java
left = Math.max(left, lastSeen[c] + 1);
```

### Ignoring monotonicity

Classic sum-based sliding window generally needs something like **all numbers positive**.

If negatives can appear, consider:

- prefix sums
- prefix sum + deque
- HashMap
- binary search
- other techniques

# Sliding Window Invariant

An **invariant** is a property that remains true at a particular point in the algorithm.

The key question is:

> **What is guaranteed to be true after the `while` loop?**

## Longest

```java
while (invalid) { ... }
```

After the loop:

```text
window is VALID
```

Then maximize.

## Shortest

```java
while (valid) { ... }
```

During the loop:

```text
window is VALID
```

So measure first, then shrink.

# Decision Tree

```text
Is it contiguous?
|
+-- NO -> probably not sliding window
|
+-- YES
    |
    v
Is window size fixed?
    |
    +-- YES -> fixed-size window
    |
    +-- NO
        |
        v
Longest / maximum length?
        |
        +-- YES -> shrink while INVALID
        |
        +-- NO
            |
            v
Shortest / minimum length?
            |
            +-- YES -> shrink while VALID
            |
            +-- NO
                |
                v
Counting subarrays?
                |
                +-- YES -> try "at most"
                |          exactly K =
                |          atMost(K) - atMost(K-1)
                |
                +-- NO
                    |
                    v
Need max/min in every window?
                    |
                    +-- YES -> monotonic deque
```

# Complexity

Typical sliding window:

```text
Time:  O(n)
Space: O(1) / O(k)
```

Why O(n)? `right` moves at most `n` times and `left` also moves at most `n` times.

Even with a nested `while`, total pointer movement is usually linear.

---

For a typical sliding window:

```java
for (right = 0; right < n; right++)
```

looks like `O(n)`.

Then:

```java
while (...)
```

looks like another loop.

But do **not** automatically conclude `O(n^2)`.

`left` only moves forward.

For example:

```text
right: 0 -> 1 -> 2 -> ... -> n-1
left:  0 -> 1 -> 2 -> ... -> n-1
```

Each element is:

- added once
- removed once

Therefore:

```text
Time = O(n)
```

for the normal case.

# Space Complexity

Depends on how much state the window stores.

## Array frequency

```text
O(1)
```

## HashMap

```text
O(k)
```

## Deque

```text
O(k)
```

for a window of size `k`.

or up to the number of distinct elements.

# Cheat Sheet

```text
LONGEST       -> Shrink while INVALID
SHORTEST      -> Shrink while VALID
AT MOST K     -> Longest valid window
EXACTLY K     -> atMost(K) - atMost(K-1)
COUNT         -> Often += right - left + 1
FIXED K       -> Remove when size > K
MAX/MIN       -> Monotonic deque
```

And always ask:

```text
1. What is my window state?
2. What makes the window invalid?
3. When do I move left?
4. When do I update the answer?
```

> The hardest part of Sliding Window is usually not the code. It is identifying the **correct window invariant**.

Sliding Window technique works when the window's state can be maintained incrementally and moving `left`/`right` has the monotonic behavior needed to discard impossible candidates.

# Pattern Recognition Cheat Sheet

## "Longest substring with..."

Think:

```text
Shrink while INVALID
```

Example: Longest substring with at most K distinct chars

## "Maximum length after at most K changes"

Think:

```text
Shrink while INVALID
```

## "Minimum length subarray whose..."

Think:

```text
Shrink while VALID
```

## "Minimum window containing..."

Think:

```text
Shrink while VALID
```

with frequency bookkeeping.

## "Exactly K..."

Think:

```text
atMost(K) - atMost(K - 1)
```

## "Every window of size K"

Think:

```text
Fixed-size sliding window
```

## "Maximum/minimum in each window"

Think:

```text
Monotonic deque
```

# Sliding Window Checklist

Before coding, identify these five things:

```text
1. left
2. right
3. window state
4. invalid/valid condition
5. when to update result
```

For example, Longest At Most K Distinct:

```text
left   = 0
right  = loop variable
state  = frequency map
invalid = distinct > k
result = maximum window length
```

## Template 1 - Longest

```text
for each right:
  add right

  while invalid:
      remove left
      left++

  update MAX
```

## Template 2 - Shortest

```text
for each right:
  add right

  while valid:
    update MIN
    remove left
    left++
```

## Template 3 - At Most K Count

```text
for each right:
  add right

  while invalid:
      remove left
      left++

  answer += right - left + 1
```

## Template 4 - Fixed K

```text
for each right:
  add right

  if window size > k:
    remove left
    left++

  if window size == k:
    process window
```

## Template 5 - Monotonic Deque

For maximum:

```text
for each right:
  remove expired indices from front

  while deque back is smaller:
    remove back

  add right

  front = maximum
```
