#include <bits/stdc++.h>

//------------------------------------------------------------------------------
//                                Union by Rank
//------------------------------------------------------------------------------
class UnionFind {
private:
  std::vector<int> root;
  std::vector<int> rank;

public:
  UnionFind(int size)
  : root(size)
  , rank(size) {
    for (int i = 0; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  int find(int x) {
    // while (x != root[x]) {
    //   x = root[x];
    // }
    // return x;
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  void unionise(int x, int y) {
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

  bool isConnected(int x, int y) {
    return find(x) == find(y);
  }
};

// Test Case
int main1() {
  // for displaying booleans as literal strings, instead of 0 and 1
  std::cout << std::boolalpha;
  UnionFind uf(10);
  // 1-2-5-6-7 3-8-9 4
  uf.unionise(1, 2);
  uf.unionise(2, 5);
  uf.unionise(5, 6);
  uf.unionise(6, 7);
  uf.unionise(3, 8);
  uf.unionise(8, 9);
  std::cout << uf.isConnected(1, 5) << std::endl; // true
  std::cout << uf.isConnected(5, 7) << std::endl; // true
  std::cout << uf.isConnected(4, 9) << std::endl; // false
  // 1-2-5-6-7 3-8-9-4
  uf.unionise(9, 4);
  std::cout << uf.isConnected(4, 9) << std::endl; // true

  return 0;
}

//------------------------------------------------------------------------------
//                              Path Compression
//------------------------------------------------------------------------------
class UnionFind {
private:
  std::vector<int> root;

public:
  UnionFind(int size)
  : root(size) {
    for (int i = 0; i < size; i++) {
      root[i] = i;
    }
  }

  int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  void unionise(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      root[rootY] = rootX;
    }
  }

  bool isConnected(int x, int y) {
    return find(x) == find(y);
  }
};

// Test Case
int main2() {
  // for displaying booleans as literal strings, instead of 0 and 1
  std::cout << std::boolalpha;
  UnionFind uf(10);
  // 1-2-5-6-7 3-8-9 4
  uf.unionise(1, 2);
  uf.unionise(2, 5);
  uf.unionise(5, 6);
  uf.unionise(6, 7);
  uf.unionise(3, 8);
  uf.unionise(8, 9);
  std::cout << uf.isConnected(1, 5) << std::endl; // true
  std::cout << uf.isConnected(5, 7) << std::endl; // true
  std::cout << uf.isConnected(4, 9) << std::endl; // false
  // 1-2-5-6-7 3-8-9-4
  uf.unionise(9, 4);
  std::cout << uf.isConnected(4, 9) << std::endl; // true

  return 0;
}

//------------------------------------------------------------------------------
//                      Union by Rank + Path Compression
//------------------------------------------------------------------------------
class UnionFind {
private:
  std::vector<int> root;
  std::vector<int> rank;

public:
  UnionFind(int size)
  : root(size)
  , rank(size) {
    for (int i = 0; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  void unionise(int x, int y) {
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

  bool isConnected(int x, int y) {
    return find(x) == find(y);
  }
};

// Test Case
int main() {
  // for displaying booleans as literal strings, instead of 0 and 1
  std::cout << std::boolalpha;
  UnionFind uf(10);
  // 1-2-5-6-7 3-8-9 4
  uf.unionise(1, 2);
  uf.unionise(2, 5);
  uf.unionise(5, 6);
  uf.unionise(6, 7);
  uf.unionise(3, 8);
  uf.unionise(8, 9);
  std::cout << uf.isConnected(1, 5) << std::endl; // true
  std::cout << uf.isConnected(5, 7) << std::endl; // true
  std::cout << uf.isConnected(4, 9) << std::endl; // false
  // 1-2-5-6-7 3-8-9-4
  uf.unionise(9, 4);
  std::cout << uf.isConnected(4, 9) << std::endl; // true

  return 0;
}

//------------------------------------------------------------------------------
//                    Path Compression + Union by Rank (Boolean)
//------------------------------------------------------------------------------
class UnionFind {
private:
  std::vector<int> root;
  std::vector<int> rank;

public:
  UnionFind(int size)
  : root(size)
  , rank(size) {
    for (int i = 0; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  bool unionise(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY) {
      return false;
    }
    if (rank[rootX] >= rank[rootY]) {
      root[rootY] = rootX;
      rank[rootX] += rank[rootY];
      rank[rootY] = 0; // Needed if we do NOT sort array to be unionised
    } else if (rank[rootX] < rank[rootY]) {
      root[rootX] = rootY;
      rank[rootY] += rank[rootX];
      rank[rootX] = 0; // Needed if we do NOT sort array to be unionised
    }
    return true;
  }

  bool isConnected(int x, int y) {
    return find(x) == find(y);
  }

  int getSize(int x) {
    return rank[find(x)];
  }
};
