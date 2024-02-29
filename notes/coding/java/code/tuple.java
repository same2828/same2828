/*
https://stackoverflow.com/questions/7316571/java-pairt-n-class-implementation
https://stackoverflow.com/questions/2670982/using-pairs-or-2-tuples-in-java
https://stackoverflow.com/questions/3642452/java-n-tuple-implementation
*/

public class Tuple<X, Y> {
  public final X x;
  public final Y y;

  public Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Tuple)) {
      return false;
    }
    Tuple<?, ?> p = (Tuple<?, ?>) o;
    return Objects.equals(p.x, x) && Objects.equals(p.y, y);
  }

  @Override
  public int hashCode() {
    return (x == null ? 0 : x.hashCode()) ^ (y == null ? 0 : y.hashCode()); // Bitwise XOR
    // return (x == null ? 0 : x.hashCode()) & (y == null ? 0 : y.hashCode()); // Bitwise AND
    // return (x == null ? 0 : x.hashCode()) | (y == null ? 0 : y.hashCode()); // Bitwise OR
    // return (x == null ? 0 : x.hashCode()) + (y == null ? 0 : y.hashCode()); // Addition
  }

  public static <A, B> Tuple<A, B> create(A a, B b) {
    return new Tuple<A, B>(a, b);
  }

  // If errors occur with above (uncomment below)
  public <A, B> Pair<A, B> create(A a, B b) {
    return new Pair<A, B>(a, b);
  }
}
