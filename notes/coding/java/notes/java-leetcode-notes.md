> # HashMap

## Definition

```
Map<K, V> map = new HashMap<>();
```

## Insert / Update

```
.put(k1, v1);
```

## Delete

```
.remove(k1);
```

## Get

```
.get(k1);
```

## Size

```
.size();
```

## Check for Empty

```
.isEmpty();
```

## Value present

```
.containsKey(k1);
```

## Remove all map values

```
.clear();
```

> # ArrayList

## Definition

```
ArrayList list = new ArrayList<>();
```

## Insert

```
.add(element)
.add(int index, element);
```

## Delete

```
.remove(int index);
```

## Set

```
.set(int index, element);
```

## Get

```
.get(int index);
```

## Size

```
.size();
```

## Clear

```
.clear();
```

## Empty Check

```
.isEmpty();
```

## Value Check

```
.contains(element);
```

## Get Index of Value

```
.indexOf(t);
```

## Non Primitive to Primitive

```
.toArray();
```

## Sorting

- Ascending

```
Collections.sort(list, (a, b) -> a - b);
```

- Descending

```
Collections.sort(list, (a, b) -> b - a);
```

> # Array

## Definition

```
Type array[] = new Type[N];
```

## Insert

```
array[index] = v1;
```

## Update

```
array[index] = v2;
```

## Get

```
array[index]
```

## Size

```
array.length;
```

## Fill

```
Arrays.fill(array, 0);
```

## Sorting

### primitive (int[] ..)

- Ascending

```
Arrays.sort(array);
```

### non-primitive (Integer[] ..)

- Ascending

```
Arrays.sort(array);
```

- Aescending

```
Arrays.sort(array, (a,b) -> b-a);
```

> # Stack

## Definition

```
Stack st = new Stack<>();
```

## Insert

```
.push(element);
```

## Size

```
.size();
```

## Look

- Look up for head element

```
.peek();
```

## Remove

- Head element

```
.pop();
```

## Check

```
.isEmpty();
```

> # Queue

## Definition

```
Queue queue = new LinkedList<>();
```

## Insert

```
.add(t);
```

## Size

```
.size();
```

## Look up for head element

```
.peek();
```

## Remove head element

```
.poll();
```

## Check for Empty

```
.isEmpty();
```

## Points to remember

- We can define queue via LinkedList, PriorityQueue based on use case

```
queue.poll() == stack.pop()
queue.add() == stack.push()
```

> # String

## Definition

```
String str = new String();
```

## Size

```
int length();
```

## Convert to char Array

```
toCharArray();
```

## Value at specific index

```
charAt(int index);
```

## Substring from string

```
substring(a,b] // a : inclusive, b: Exclusive,
```

## Transform to Lowercase

```
toLowerCase();
```

## Transform to UpperCase

```
toUpperCase();
```

## Replace all characters in string

```
replaceAll(from, to)
```

## Some useful Character properties

```
Character.isLetter();
Character.isAlphabetic();
Character.isUpperCase();
Character.isLowerCase();
Character.isDigit();
```

## Concatenation

```
newStr = str1 + str2
```

> # StringBuilder

```
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder(existingString);
sb.append(char[])
sb.delete(startIndex, endIndex) // (startIndex -> endIndex-1)
sb.deleteCharAt(index)
sb.replace(startIndex, endIndex, newString) // (startIndex -> endIndex-1)
sb.reverse()
sb.setCharAt(index, char)
sb.toString()
```

> # HashSet

## Definition

```
Set set = new HashSet<>();
```

## Insert / Update

```
.add(t);
```

## Delete

```
.remove(t);
```

## Get

```
.contains(t);
```

## Size

```
.size();
```

## Check For Empty

```
.isEmpty();
```

## Remove All Set Values

```
.clear();
```

> # Miscellaneous

## Increment an occurrence in map

```
for(char ch : input.toCharArray()){
  hashmap.put(ch, hashmap.getOrDefault(ch, 0) + 1);
}
```

## Decrement the occurrence and when occurrence becomes zero, remove entry.

```
char charToRemove = 'c';
hashmap.put(charToRemove, count.get(charToRemove) - 1);
hashmap.remove(charToRemove, 0);
```
