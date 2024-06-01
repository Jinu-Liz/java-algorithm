package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 순차탐색
 *  N 배열
 *  key가 M개
 *  key 1개당 순차검색 O[N]
 *  key M개 순차검색 O[NM]
 *
 * 이진탐색
 *  N 배열
 *  key가 M개
 *
 *  정렬 O[NlogN]
 *  key 1개당 이진탐색 O[logN]
 *  key M개 이진탐색 O[MlogN]
 *  O[NlogN + MlogN] = O[(N+M)logN]
 */
public class 백준_1920_수찾기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());  // 1 <= N <= 100,000
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());  // 모든 정수는 int형 범위 내
    }
    Arrays.sort(A);

    int M = Integer.parseInt(br.readLine());  // 1 <= M <= 100,000
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      int key = Integer.parseInt(st.nextToken());   // int형 범위 내
      int ret = Arrays.binarySearch(A, key);
      sb.append(ret >= 0 ? 1 : 0).append("\n");
    }

    System.out.println(sb);
  }
}
