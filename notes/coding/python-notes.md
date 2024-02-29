# Table of Contents

- [Table of Contents](#table-of-contents)
- [String Slice](#string-slice)

# String Slice

```python
# Slice position:    0   1   2   3   4   5   6
# Slice position:   -6  -5  -4  -3  -2  -1   0
#                    +---+---+---+---+---+---+
#                    | P | y | t | h | o | n |
#                    +---+---+---+---+---+---+
# Index position:      0   1   2   3   4   5
# Index position:     -6  -5  -4  -3  -2  -1


#  +---+---+---+---+---+---+
#  | P | y | t | h | o | n |
#  +---+---+---+---+---+---+
#  0   1   2   3   4   5   6
# -6  -5  -4  -3  -2  -1

s[startAt:endBefore:stepBy]
s[:i] + s[i:] = s

# startAt     defaults to 0
# endBefore   defaults to sizeOfString
# stepBy      defaults to 1

s[a:b]      # Items index a -> b-1
s[a:]       # Items index a -> end of array
s[:b]       # Items from index 0 -> b-1
s[:]        # A copy of the whole array
s[:-1]      # Copy from index 0 -> lastIndex-1 (inclusive)
s[1:]       # Copy from index 1 -> lastIndex (inclusive)

s[-1]       # Last item in the array (e.g. 'n')
s[-2:]      # Last two items in the array (from slice position -2 to 0) (e.g. 'on')
s[:-2]      # Everything except the last two items (from slice position -6 to -3) (e.g. 'Pyth')

s[::-1]    # All items in the array, reversed (e.g. 'nohtyP')
s[1::-1]   # The first two items, reversed (e.g. 'yp') (start from 1st index, stop at len(s), step by -1) (start from index 1 and move backwards by 1, stops after index 0, since we keep stepping by -1)
s[:-3:-1]  # The last two items, reversed (e.g. 'no')
s[-3::-1]  # Everything except the last two items, reversed (e.g. htyp')
```
