package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수학적으로 풀이
 */
public class 백준_1074_Z_4 {
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

    for (int i = N - 1; i >= 0 ; i--) {
      answer <<= 2;
      answer |= ((r & (1 << i)) != 0 ? 1 : 0) << 1 | ((c & (1 << i)) != 0 ? 1 : 0);   // 자리수 추출해서 추가
    }

    System.out.println(answer);
  }
}
