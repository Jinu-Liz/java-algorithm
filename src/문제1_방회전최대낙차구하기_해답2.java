/**
 * 방 회전 최대낙차 구하기
 * 맨 위에 위치한 박스끼리 비교.
 * 나보다 오른쪽에 나보다 낮은 높이의 박스 개수를 구한다
 */
public class 문제1_방회전최대낙차구하기_해답2 {
  public static void main(String[] args) {
    int[] box = { 7, 4, 2, 0, 0, 6, 0, 7, 0};
    int max = 0;
    for (int i = 0; i < box.length; i++) {
      int cnt = 0;

      // 나보다 오른쪽에 나보다 낮은 높이의 박스 개수 = 꼭대기 박스가 떨어지는 낙차
      for (int j = i + 1; j < box.length; j++) {
        if (box[i] > box[j]) cnt++;
      }

      max = Math.max(max, cnt);
    }

    System.out.println("최대 낙차 : " + max);
  }
}
