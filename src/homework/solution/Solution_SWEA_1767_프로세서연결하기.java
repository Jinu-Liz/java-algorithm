package homework.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_SWEA_1767_프로세서연결하기 {
  private static class Point {
    int r, c;
    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  private static ArrayList<Point> coreList = new ArrayList<>();  // 전원이 연결되지 않은 core 좌표
  private static int N;
  private static int[][] m;
  private static int totalCoreCnt;
  private static int maxCoreCnt;
  private static int minWireSum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int TC = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= TC ; testCase++) {   // 60
      N = Integer.parseInt(br.readLine());  // 7 ~ 12
      m = new int[N][N];

      int outLineCoreCnt = 0;   // 외곽에 붙어있는 core 갯수
      for (int i = 0; i < m.length; i++) {
        String s = br.readLine();
        for (int j = 0, index = 0; j < m.length; j++, index += 2) {
          m[i][j] = s.charAt(index);  // 0: 빈셀, 1: 코어
          if (m[i][j] == '1') {   // core
            if (i == 0 || j == 0 || i == N-1 || j == N-1) {   // 외곽에 붙어있는
              outLineCoreCnt++;
            } else {  // 안쪽의 코어만 좌표를 따로 관리
              coreList.add(new Point(i, j));
            }
          }
        }
      }

      totalCoreCnt = outLineCoreCnt + coreList.size();  // 전체 core 갯수
      maxCoreCnt = 0;  // 최대 연결 core 갯수
      minWireSum = Integer.MAX_VALUE; // 전선 길이의 합
      dfs(0, outLineCoreCnt, 0, 0);
      sb.append("#").append(testCase).append(" ").append(minWireSum).append("\n");
    }

    System.out.println(sb);
  }

  private static int[] dr = { -1, 1, 0, 0 };  // 상하좌우
  private static int[] dc = { 0, 0, -1, 1 };  // 상하좌우

  /**
   * @param coreCnt - 현재까지 전원 연결된 코어 수
   * @param wireSum - 최대 코어 시 전선 길이의 합
   * @param noCore - 연결 안 한 코어 개수
   */
  private static void dfs(int index, int coreCnt, int wireSum, int noCore) {
    if (maxCoreCnt > totalCoreCnt - noCore) return;

    // 각 코어마다 반복 연결, 미연결

    if (index == coreList.size()) {   // 종료파트
      if (maxCoreCnt < coreCnt) {
        maxCoreCnt = coreCnt;
        minWireSum = wireSum;
      } else if (maxCoreCnt == coreCnt && minWireSum > wireSum) {
        minWireSum = wireSum;
      }
      return;
    }

    Point core = coreList.get(index);
    dfs(index + 1, coreCnt, wireSum, noCore + 1);   // 미연결
    for (int dir = 0; dir < dc.length; dir++) {   // 반복문 연결 상하좌우
      if (check(core.r, core.c, dir)) {   // 연결 가능하나?
        int cntWire = fill(core.r, core.c, dir, '2');   // 선을 깔기, 몇 개 깔았는지 확인

        dfs(index + 1, coreCnt + 1, wireSum + cntWire, noCore);// 재귀호출
        fill(core.r, core.c, dir, '0');   // 선을 원복
      }
    }
  }

  private static int fill(int r, int c, int dir, char val) {
    int cntWire = 0;
    for (int i = 1; ; i++) {
      int nr = r + dr[dir] * i;
      int nc = c + dc[dir] * i;
      if (0 > nr || nr >= N || 0 > nc || nc >= N) return cntWire;  // 외곽에 도달하면 종료 성공

      m[nr][nc] = val;
      cntWire++;
    }
  }

  /**
   * (r, c)에서 dir 방향으로 직선연결이 가능한지 확인 후 리턴, dir 0123 상하좌우
   */
  private static boolean check(int r, int c, int dir) {
    for (int i = 1; ; i++) {
      int nr = r + dr[dir] * i;
      int nc = c + dc[dir] * i;
      if (0 > nr || nr >= N || 0 > nc || nc >= N) return true;  // 연결 가능

      if (m[nr][nc] != '0') return false;     // 선을 깔 수 없음
    }
  }
}
