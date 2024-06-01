import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열_D3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = ReaderUtil.inputInReader();
    StringBuilder sb = new StringBuilder();
    int TC = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= TC; testCase++) {
      int N = Integer.parseInt(br.readLine());  // 수열의 길이 1 ~ 1000
      int[] arr = new int[N + 1];
      StringTokenizer st = ReaderUtil.newTokenizer(br.readLine());
      for (int i = 1; i < arr.length; i++) {
        arr[i] = Integer.parseInt(st.nextToken());    // 원소 자연수, int형 범위 이내
      }

      int[] LIS = new int[N + 1];   // i번째 숫자를 LIS 수열의 마지막 원소로 사용할 경우 LIS 길이를 저장
      int[] path = new int[N + 1];

      for (int i = 1; i < LIS.length; i++) {
        LIS[i] = 1;

        for (int j = 0; j < LIS.length; j++) {  // 나보다 앞위치의 숫자 중
          if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
            LIS[i] = LIS[j] + 1;
            path[i] = j;    // 최장증가수열 작성 시 내 앞에 누구 원소 있는지 index 기록
          }
        }
      }

      int lastIndex = -1;
      int maxLIS = 0;
      for (int i = 1; i < LIS.length; i++) {
        if (maxLIS < LIS[i]) {
          maxLIS = LIS[i];
          lastIndex = i;
        }
      }
      sb.append("#").append(testCase).append(" ").append("\n");

      // LIS 수열의 내용을 얻기
      String resultLIS = "";
      for (int i = lastIndex; i != 0; i = path[i]) {
        resultLIS = arr[i] + " " + resultLIS;
      }
      System.out.println(Arrays.toString(path));
      System.out.println(resultLIS);
    }

    System.out.println(sb);
  }
}
