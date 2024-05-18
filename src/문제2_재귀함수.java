public class 문제2_재귀함수 {

  private static int[] arr = {9,2,5,3,8,1,6,4,7};

  private static int sum = 0;

  public static void main(String[] args) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

//    arrPrint(2);
//    arrSum(1);
//    binaryPrint(0, "");
    System.out.println(fibo(7));
  }

  /**
   * 피보나치 수열
   */
  private static int fibo(int i) {
    if (i <= 2) {   // 종료파트
      return 1;
    } else {  // 재귀파트
      return fibo(i - 1) + fibo(i - 2);
    }
  }

  /** step : (단계)자리수, val: 지금까지 만들어온 2진수 값 */
  private static void binaryPrint(int step, String val) {
    if (step == 3) {    // 종료 파트
      System.out.println(val);
    } else {    // 재귀 파트
      binaryPrint(step + 1, val + 0);   // step 번째 자리값을 0으로 설정
      binaryPrint(step + 1, val + 1);   // step 번째 자리값을 1으로 설정
    }
  }

  /**
   * index 위치부터 더하기
   */
  private static void arrSum(int index) {
    if (index >= arr.length) {    // 종료 파트
      System.out.println(sum);
    } else {  // 재귀 파트
      sum += arr[index];
      arrSum(index + 1);
    }
  }

  private static void arrPrint(int index) {
    if (index >= arr.length) {  // 종료 파트
      System.out.println();
    } else {  // 재귀 파트
      System.out.print(arr[index] + " ");
      arrPrint(index + 1);
    }
  }
}
