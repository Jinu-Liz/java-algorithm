package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1074_Z {
  private static int r;
  private static int c;
  private static int[] bin = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768}; // 해싱
  private static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    go(N, 0, 0);
  }

  /**
   * @param N - 사각형의 가로세로 크기 2^n
   * @param sr - 사각형의 시작 위치
   * @param sc - 사각형의 시작 위치
   */
  private static void go(int N, int sr, int sc) {
    // 답이 포함되지 않은 영역은 방문하지 말 것
    if (r < sr || sr + bin[N] <= r || c < sc || sc + bin[N] <= c) {
      answer += bin[N] * bin[N];
      return;
    }
    if (N == 0) { // 종료파트, 1칸짜리 사각형 여부 확인
      if (sr == r && sc == c) {
        System.out.println(answer);
        System.exit(0);
      }

      answer++;
      return;
    }

    go(N - 1, sr, sc);  // 좌상
    go(N - 1, sr, sc + bin[N - 1]);  // 우상
    go(N - 1, sr + bin[N - 1], sc);  // 좌하
    go(N - 1, sr + bin[N - 1], sc + bin[N - 1]);  // 우하
  }
}
