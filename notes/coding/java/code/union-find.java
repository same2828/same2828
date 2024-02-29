//------------------------------------------------------------------------------
//                                  Quick Find
//------------------------------------------------------------------------------
// UnionFind.class
class UnionFind {
  private int[] root;

  public UnionFind(int size) {
    this.root = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
    }
  }

  public int find(int x) {
    return root[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      for (int i = 0; i < root.length; i++) {
        if (root[i] == rootY) {
          root[i] = rootX;
        }
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}

// App.java
// Test Case
public class App {
  public static void main(String[] args) throws Exception {
    UnionFind uf = new UnionFind(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.isConnected(1, 5)); // true
    System.out.println(uf.isConnected(5, 7)); // true
    System.out.println(uf.isConnected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.isConnected(4, 9)); // true
  }
}

//------------------------------------------------------------------------------
//                                  Quick Union
//------------------------------------------------------------------------------
// UnionFind.class
class UnionFind {
  private int[] root;

  public UnionFind(int size) {
    this.root = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
    }
  }

  public int find(int x) {
    while (x != root[x]) {
      x = root[x];
    }
    return x;
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      root[rootY] = rootX;
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}

// App.java
// Test Case
public class App {
  public static void main(String[] args) throws Exception {
    UnionFind uf = new UnionFind(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.isConnected(1, 5)); // true
    System.out.println(uf.isConnected(5, 7)); // true
    System.out.println(uf.isConnected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.isConnected(4, 9)); // true
  }
}

//------------------------------------------------------------------------------
//                                Union by Rank
//------------------------------------------------------------------------------
// UnionFind.class
class UnionFind {
  private int[] root;
  // Use a rank array to record the height of each vertex (i.e. the "rank" of each vertex)
  private int[] rank;

  public UnionFind(int size) {
    this.root = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
      // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices
      rank[i] = 1;
    }
  }

  public int find(int x) {
    while (x != root[x]) {
      x = root[x];
    }
    return x;
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
        // Trees are equal, move one tree to be under another (hence increase height by 1)
      } else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}

// App.java
// Test Case
public class App {
  public static void main(String[] args) throws Exception {
    UnionFind uf = new UnionFind(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.isConnected(1, 5)); // true
    System.out.println(uf.isConnected(5, 7)); // true
    System.out.println(uf.isConnected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.isConnected(4, 9)); // true
  }
}

//------------------------------------------------------------------------------
//                                Path Compression
//------------------------------------------------------------------------------
// UnionFind.class
class UnionFind {
  private int[] root;

  public UnionFind(int size) {
    this.root = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      root[rootY] = rootX;
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}

// App.java
// Test Case
public class App {
  public static void main(String[] args) throws Exception {
    UnionFind uf = new UnionFind(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.isConnected(1, 5)); // true
    System.out.println(uf.isConnected(5, 7)); // true
    System.out.println(uf.isConnected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.isConnected(4, 9)); // true
  }
}

//------------------------------------------------------------------------------
//                    Path Compression + Union by Rank (Void)
//------------------------------------------------------------------------------
// UnionFind.class
class UnionFind {
  private int[] root;
  private int[] rank;

  public UnionFind(int size) {
    this.root = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
      } else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}

// App.java
// Test Case
public class App {
  public static void main(String[] args) throws Exception {
    UnionFind uf = new UnionFind(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.isConnected(1, 5)); // true
    System.out.println(uf.isConnected(5, 7)); // true
    System.out.println(uf.isConnected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.isConnected(4, 9)); // true
  }
}

//------------------------------------------------------------------------------
//                    Path Compression + Union by Rank (Boolean)
//------------------------------------------------------------------------------
/*
// Initialise each element as its own separate connected component
numSeparateComponents = n
if (uf.union(u, v)) {
  numSeparateComponents--;
}
*/

class UnionFind {
  private int[] root;
  private int[] rank;

  public UnionFind(int size) {
    this.root = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public boolean union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY) {
      return false;
    }
    if (rank[rootX] > rank[rootY]) {
      root[rootY] = rootX;
    } else if (rank[rootX] < rank[rootY]) {
      root[rootX] = rootY;
    } else {
      root[rootY] = rootX;
      rank[rootX] += 1;
    }
    return true;
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}

//------------------------------------------------------------------------------
//            Path Compression + Union by Rank (Largest Component Size)
//------------------------------------------------------------------------------
class UnionFind {
  private int[] root;
  // Use a rank array to record the height of each vertex, i.e. the "rank" of each vertex
  private int[] rank;

  public UnionFind(int size) {
    this.root = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
      // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] >= rank[rootY]) {
        root[rootY] = rootX;
        rank[rootX] += rank[rootY];
        rank[rootY] = 0; // Needed if we do NOT sort array to be unionised
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
        rank[rootY] += rank[rootX];
        rank[rootX] = 0; // Needed if we do NOT sort array to be unionised
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }

  public int getSize(int x) {
    return rank[find(x)];
  }

  public int getLargestComponentSize() {
    int maxSize = 0;
    for (int i = 0; i < root.length; i++) {
      if (root[i] == i && rank[i] > maxSize) {
        maxSize = rank[i];
      }
    }
    return maxSize;
  }
}

//------------------------------------------------------------------------------
// Path Compression + Union by Rank (Number of Connected Components / Separate Components)
//------------------------------------------------------------------------------
class UnionFind {
  private int[] root;
  // Use a rank array to record the height of each vertex, i.e. the "rank" of each vertex
  private int[] rank;
  // Number of connected components (numConnectedComponents)
  private int separateComponents;

  public UnionFind(int size) {
    this.root = new int[size];
    this.rank = new int[size];
    // Initialise each element as its OWN separate connected component
    this.separateComponents = size;
    for (int i = 0; i < size; i++) {
      root[i] = i;
      // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
      } else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
      separateComponents--;
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }

  public int getNumSeparateComponents() {
    return this.separateComponents;
  }
}

// V2
class UnionFind {
  private int[] root;
  // Use a rank array to record the height of each vertex, i.e. the "rank" of each vertex
  private int[] rank;
  // Number of connected components (numConnectedComponents)
  private int numConnectedComponents;

  public UnionFind(int size) {
    this.root = new int[size];
    this.rank = new int[size];
    // Initialise each element as its OWN separate connected component
    this.numConnectedComponents = size;
    for (int i = 0; i < size; i++) {
      root[i] = i;
      // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
      } else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
      numConnectedComponents--;
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }

  public int getNumConnectedComponents() {
    return this.numConnectedComponents;
  }
}
