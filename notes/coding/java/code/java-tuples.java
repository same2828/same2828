//------------------------------------------------------------------------------
//                                  BFS
//------------------------------------------------------------------------------
public class Solution {
  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount < 1) {
      return 0;
    }

    Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
    Set<Integer> seen = new HashSet<>();
    queue.addFirst(new AbstractMap.SimpleEntry<Integer, Integer>(amount, 0));
    seen.add(amount);

    while (!queue.isEmpty()) {
      Map.Entry<Integer, Integer> tuple = queue.removeFirst();
      int remaining = tuple.getKey(), numCoins = tuple.getValue();
      if (remaining == 0) {
        return numCoins;
      }

      for (int coin : coins) {
        if (remaining - coin >= 0 && !seen.contains(remaining - coin)) {
          queue.addLast(new AbstractMap.SimpleEntry<Integer, Integer>(remaining - coin, numCoins + 1));
          seen.add(remaining - coin);
        }
      }
    }

    return -1;
  }
}