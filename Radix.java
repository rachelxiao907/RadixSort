public class Radix {
  public static int nth(int n, int col) {
    return Math.abs(n) / (int)Math.pow(10, col) % 10;
  }

  public static int length(int n) {
    if (n == 0) return 1;
    return (int) Math.log10(Math.abs(n)) + 1;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] bucket = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      bucket[i] = new SortableLinkedList(); //make 10 lists for digit's 10 different values
    }
    int passes = 1;
    for (int i = 0; i < passes; i++) {  //i is ones column, tens column, etc
      while (data.size() != 0) {
        int value = data.remove(0);;  //just look at head because everything will shift left when removing from head
        passes = Math.max(length(value), passes); //gets rid of quadratic in finding passes
        int digit = nth(value, i);  //find the bucket to put it in
        bucket[digit].add(value);
      }
      merge(data, bucket);  //remember that merge calls extend which will clear bucket[col]
    }
  }

  public static void radixSort(SortableLinkedList data) {
    SortableLinkedList[] positive = new SortableLinkedList[10];
    SortableLinkedList[] negative = new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      positive[i] = new SortableLinkedList();
      negative[i] = new SortableLinkedList();
    }

    int passes = 1;
    for (int i = 0; i < passes; i++) {
      while (data.size() != 0) {
        int value = data.remove(0);;
        passes = Math.max(length(value), passes);
        int digit = nth(value, i);
        if (value < 0){
          negative[10 - digit - 1].add(value); //add backwards because smaller digit is greater in negatives
        } else {
          positive[digit].add(value);
        }
      }
      merge(data, negative);
      merge(data, positive);
    }
  }

}
