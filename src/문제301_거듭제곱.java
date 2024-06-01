public class 문제301_거듭제곱 {
  public static void main(String[] args) {
    //C^n
    int C = 2;
    int n = 1000000000;

    long time = System.currentTimeMillis();
    System.out.println(iterative(C, n));
    System.out.println("반복문 : " + (System.currentTimeMillis() - time));

    System.out.println(recursive(C, n));
    System.out.println("재귀함수 : " + (System.currentTimeMillis() - time));
  }

  public static int recursive(int C, int n) {
    if (n == 1) {   // 종료
      return C;
    }

    int y = recursive(C, n/2);
    if (n % 2 == 0) {   // 짝수
      return y * y;
    } else {  // 홀수
      return y * y * C;
    }
  }

  private static int iterative(int C, int n) {
    int result = 1;   // 연산자의 항등원으로 초기화
    for (int i = 0; i < n; i++) {
      result *= C;
    }

    return result;
  }
}
