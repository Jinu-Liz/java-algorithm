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
public class 문제1_방회전최대낙차구하기_해답 {
  public static void main(String[] args) {
    int[] box = { 7, 4, 2, 0, 0, 6, 0, 7, 0};

    // 2차원 배열 생성 (8행 9열)
    int[][] map = new int[8][9];

    // 입력받은 상자 갯수만큼 아래부터 채우기
    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[i]; j++) {
        map[i][j] = 1;  // 박스
      }
    }

    // 회전한 공간을 저장할 배열 생성 (9행 8열)
    int[][] room = new int[9][8];

    // 회전한 상황으로 배열 내용 옮김
    for (int i = 0; i < room.length; i++) {
      for (int j = 0; j < room[i].length; j++) {
        room[i][j] = map[map.length - 1 - j][i];
      }
    }

    // 가장 아래쪽 바닥부터 위로 올라가면서 상자 떨어뜨리기

    // 상자 떨어진 낙차를 구하고, 최대값 업데이트
    int max = 0;
    for (int i = room.length - 2; i >= 0; i--) {
      for (int j = 0; j < room[i].length; j++) {
        int cnt = 0;
        for (int k = 0; i+k+1 < room.length; k++) {   // (r,c) 하나의 상자를 떨어뜨리기, 바닥에 도착할 때 까지
          if (room[i+k][j] == 1 && room[i+k+1][j] == 0) {   // 나는 상자이고, 아래는 빈 공간일 경우만
            room[i+k][j] = 0;
            room[i+k+1][j] = 1;
            cnt++;
          } else {
            break;
          }
        }

        max = Math.max(max, cnt);
      }
    }

    System.out.println("최대 낙차 : " + max);
  }
}
