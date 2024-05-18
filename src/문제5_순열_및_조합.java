import java.util.Arrays;

public class 문제5_순열_및_조합 {

  private static int[] input = { 4, 2, 1, 5, 3};

  private static int total;

  public static void main(String[] args) {
    nPn(5);
    nPr(5, 3);
    nCr(5, 2);
  }

  private static void nPn(int N) {
    Arrays.sort(input);   // 오름차순 정렬
    int total = 0;
    do {
      System.out.println(Arrays.toString(input));
      total++;
    } while (nextPermutation(input));

    System.out.println("total = " + total);
  }

  private static void nPr(int N, int R) {
    Arrays.sort(input);   // 오름차순 정렬
    int total = 0;
    do {
      for (int i = 0; i < R; i++) {
        System.out.print(input[i] + " ");
      }

      System.out.println();
      total++;

      // R ~ 끝을 역순으로 swap
      int r = R;
      int n = N - 1;
      while (r < n) swap(input, r++, n--);
    } while (nextPermutation(input));
    System.out.println("total = " + total);
  }

  private static void nCr(int N, int R) {
    int[] p = new int[N];
    int total = 0;
    // 0: 출력 / 1: 출력안함
    for (int i = R; i < N; i++) {
      p[i] = 1;
    }
    Arrays.sort(input);
    do {
      for (int i = 0; i < N; i++) {
        if (p[i] == 0) System.out.print(input[i] + " ");
      }

      System.out.println();
      total++;
    } while (nextPermutation(p));
    System.out.println("total = " + total);
  }

  /**
   * 매개변수 arr 배열의 사전순 다음 순열을 만들어주는 메서드
   * 순열의 마지막이라 다음순열이 없으면 false 리턴 / 없으면 true 리턴
   */
  public static boolean nextPermutation(int[] arr) {
    int length = arr.length;

    // 꼭대기 (peak)찾기, 바꿀 위치(peak-1)
    int peak = length - 1;
    while (peak > 0 && arr[peak - 1] >= arr[peak]) peak--;

    // 사전순 순열의 끝이면? 다음이 없으면 return false
    if (peak == 0) return false;

    // 바꿀 숫자 찾기 (swapTarget) peak~끝 뒤에서부터 검색, peak-1 위치의 값보다 큰 값
    int swapTarget = length - 1;
    while (arr[peak - 1] >= arr[swapTarget]) swapTarget--;

    // 바꾸기 (peak-1) <-> swapTarget
    swap(arr, peak - 1, swapTarget);

    // peak~끝 오름차순으로 재정렬, swap
    int tail = length - 1;
    while (peak < tail) swap(arr, peak++, tail--);

    return true;
  }

  /**
   * 자리 스왑
   *
   * @param arr - 대상 배열
   * @param i - 변경할 첫번째 index
   * @param j - 변경할 두번째 index
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
