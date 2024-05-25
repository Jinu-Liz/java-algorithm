package homework.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4 {
  private static int[][] A;
  private static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int TC = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= TC; testCase++) {
      N = Integer.parseInt(br.readLine());
      A = new int[N][N];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N; j++) {
          A[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int max = 0; // 최대 이동할 수 있는 방의 수
      int num = Integer.MAX_VALUE; // 최대 이동을 위해 처음 출발해야하는 방의 위치 (이동수가 같다면, 작은 방번호 선택)
      for (int r = 0; r < N; r++) {   // 모든 칸에서 탐색해보자
        for (int c = 0; c < N; c++) {
          int val = go(r, c);   // 최대 이동할 수 있는 방의 수
          if (max < val || (max == val && num > A[r][c])) {
            max = val;
            num = A[r][c];
          }
        }
      }


      sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
    }

    System.out.println(sb);
  }

  private static int[] dr = { -1, 1, 0, 0 };  // 상하좌우
  private static int[] dc = { 0, 0, -1, 1 };  // 상하좌우

  /**
   * (r, c)에서 출발할 때 최대 이동할 수 있는 방의 수를 리턴하는 메서드
   */
  private static int go(int r, int c) {
    int result = 1;
    int num = A[r][c]; // 현재 방의 번호
    for (int i = 0; i < dr.length; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if (0 <= nr && nr < N && 0 <= nc && nc < N && num + 1 == A[nr][nc]) {   //  배열 내, 나보다 1 큰수
        result += go(nr, nc);
        break;  // 외길임
      }
    }

    return result;
  }
}
