public class Radix {
  public static int nth(int n, int col) {
    return Math.abs(n) / (int)Math.pow(10, col) % 10;
  }

  public static int length(int n) {
    String s = Integer.toString(Math.abs(n));
    return s.length();
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }
}
