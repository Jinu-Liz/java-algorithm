public class 문제3_하노이탑 {
  public static void main(String[] args) {
    hanoi(3, 1, 2, 3);
  }

  /**
   * 하노이탑, from 기둥의 원반을 to 기둥으로 이동시키는 과정을 출력
   *
   * @param n - 1 ~ n 쌓여있는 원반 갯수
   * @param from - 시작기둥
   * @param temp - 임시기둥
   * @param to - 도착기둥
   */
  private static void hanoi(int n, int from, int temp, int to) {
    if (n == 0) {   // 종료파트
      return;
    } else {    // 재귀파트
      hanoi(n - 1, from, to, temp);   // 1 ~ n-1을 잠깐 안쓰는 기둥으로 옮기기 from -> temp
      System.out.println(n + " : " + from + " -> " + to);   // n원반을 from -> to로 이동 출력
      hanoi(n - 1, temp, from, to);   // 1 ~ n-1을 temp -> to 옮기기
    }
  }
}
