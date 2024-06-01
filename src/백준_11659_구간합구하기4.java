import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 구간 합 Prefix sum : 주어진 값이 변경되지 않는 한 구간합을 구하는 가장 빠른 방법
 *    저장하는 시간 : O[N]
 *    구간 합을 구하는 시간 : O[1]
 * => 세그먼트 트리 : 주어진 값이 변경되는 경우 가장 빠른 방법
 *    저장하는 시간 : O[N]
 *    구간 합을 구하는 시간 : O[logN]
 *    값 변경 시간 : O[logN]
 */
public class 백준_11659_구간합구하기4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = ReaderUtil.inputInReader();
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = ReaderUtil.newTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 수의 개수 N, 1 <= N <= 100,000
    int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수 M, 1 <= M <= 100,000

    int[] prefixSum = new int[N + 1]; // 0번 안씀
    st = ReaderUtil.newTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken()); // 수는 1,000보다 작거나 같은 자연수
    }

    for (int i = 0; i < M; i++) {
      st = ReaderUtil.newTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
    }
    System.out.println(sb);
  }
}