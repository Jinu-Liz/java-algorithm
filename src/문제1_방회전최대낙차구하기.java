/**
 * 방 회전 최대낙차 구하기
 *
 * 입력받기
 * 2차원 배열 생성(8행 9열)
 * 입력받은 상자 갯수만큼 아래부터 채우기, 상자1 / 빈공간0
 * 회전한 공간을 저장할 배열 생성(9행 8열) => 연산시 index 벗어나지 않도록 주의
 * 회전한 상황으로 배열 내용 옮김
 * 가장 아래쪽 바닥부터 위로 올라가면서 상자 떨어뜨리기
 * 상자떨어진 낙차를 구하고, 최대값 업데이트
 * 최대값 출력
 */
public class 문제1_방회전최대낙차구하기 {
  public static void main(String[] args) {
    int[] box = { 7, 4, 2, 0, 0, 6, 0, 7, 0};
    int[][] boxArr = new int[8][9];
    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[i]; j++) {
        boxArr[i][j] = 1;
      }
    }

    System.out.println(boxArr.toString());
  }
}
