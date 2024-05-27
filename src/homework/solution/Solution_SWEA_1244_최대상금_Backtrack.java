package homework.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 최대상금 Backtrack으로 풀이
 */
public class Solution_SWEA_1244_최대상금_Backtrack {
  private static int max;
  private static int N;
  private static int[] num;
  private static HashSet<String> hs = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int TC = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= TC; testCase++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String s = st.nextToken();
      num = new int[s.length()];
      for (int i = 0; i < s.length(); i++) {

      }

      sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
    }
  }

  public static void go(int n) {
    int val = 0;
    for (int i = 0; i < num.length; i++) {
      val = val * 10 + num[i];
    }

    if (hs.contains(val+","+n)) return;

    hs.add(val+","+n);

    if (n == 0) {
      if (max < val) max = val;
      return;
    }

    for (int i = 0; i < num.length - 1; i++) {
      for (int j = i + 1; j < num.length; j++) {
       // i <-> j 방의 값을 교환
        swap(num, i, j);
        go(n - 1);
        swap(num, i, j);
      }
    }
  }

  public static void swap(int[] num, int i, int j) {
    int temp = num[i];
    num[i] = num[j];
    num[j] = temp;
  }
}
