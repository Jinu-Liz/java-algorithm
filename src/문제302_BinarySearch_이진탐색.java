import java.util.Arrays;

public class 문제302_BinarySearch_이진탐색 {
  public static void main(String[] args) {
    int[] a = {2, 4, 7, 9, 11, 19, 23};
    int key = 20;

    System.out.println(binarySearch(a, 0, a.length - 1, key));
    System.out.println(binarySearch0(a, 0, a.length - 1, key));
  }

  /**
   * @param a - 탐색하고자 하는 배열 (오름차순 정렬)
   * @param low - 탐색 범위의 시작 인덱스
   * @param high - 탐색 범위의 끝 인덱스
   * @param key - 찾고자 하는 값
   * @return - key의 인덱스, 없으면 -1
   */
  private static int binarySearch(int[] a, int low, int high, int key) {
    while (low <= high) {
      int mid = (low + high) / 2;
      int midVal = a[mid];
      if (midVal < key) {
        low = mid + 1;
      } else if (midVal > key) {
        high = mid - 1;
      } else {
        return mid;  // key 찾음
      }
    }

    return -1;  // 못찾은 경우
  }

  // Array의 binarySearch 메소드
  private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                   int key) {
    int low = fromIndex;
    int high = toIndex - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;
      int midVal = a[mid];

      if (midVal < key)
        low = mid + 1;
      else if (midVal > key)
        high = mid - 1;
      else
        return mid; // key found
    }
    return -(low + 1);  // key not found.
  }
}
