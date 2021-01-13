public class Radix {
  public static int nth(int n, int col) {
    return Math.abs(n) / (int)Math.pow(10, col) % 10;
  }

  public static int length(int n) {
    String s = Integer.toString(Math.abs(n));
    return s.length();
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    int passes = 0;
    for (int i = 0; i < data.size(); i++) {
      passes = Math.max(length(data.get(i)), passes);
    }
    SortableLinkedList[] bucket = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      bucket[i] = new SortableLinkedList(); //make 10 lists for digit's 10 different values
    }
    for (int i = 0; i < passes; i++) {  //i is ones column, tens column, etc
      while(data.size() != 0) {
        int value = data.get(0);
        int digit = nth(value, i);  //find the bucket to put it in
        bucket[digit].add(value);
        data.remove(0);
      }
      merge(data, buckets);
    }
  }
}
