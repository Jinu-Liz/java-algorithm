import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * RGB 거리 구하기
 */
public class 백준_1149_RGB거리 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = ReaderUtil.inputInReader();
    int N = Integer.parseInt(br.readLine());
    int[][] a = new int[N + 1][3];  // [만][3] : [3][만]
    for (int i = 0; i < a.length; i++) {
      StringTokenizer st = ReaderUtil.newTokenizer(br.readLine());
      a[i][0] = Integer.parseInt(st.nextToken());
      a[i][1] = Integer.parseInt(st.nextToken());
      a[i][2] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      a[i][0] += Math.min(a[i - 1][1], a[i - 1][2]);  // i번째 집을 빨간색으로 칠할 때의 최소비용
      a[i][1] += Math.min(a[i - 1][0], a[i - 1][2]);  // i번째 집을 초록색으로 칠할 때의 최소비용
      a[i][2] += Math.min(a[i - 1][0], a[i - 1][1]);  // i번째 집을 파란색으로 칠할 때의 최소비용
    }

    int min = a[N][0];
    if (min > a[N][1]) min = a[N][1];
    if (min > a[N][2]) min = a[N][2];

    System.out.println(min);
  }
}

/**
 * a[만][3] 과 a[3][만] 배열 중 어느 배열이 메모리를 적게 먹는가?
 */
