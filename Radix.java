public class Radix {
  public static int nth(int n, int col) {
    return Math.abs(n) / (int)Math.pow(10, col) % 10;
  }
}
