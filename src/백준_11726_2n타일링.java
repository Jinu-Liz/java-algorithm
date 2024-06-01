import java.io.BufferedReader;
import java.io.IOException;

public class 백준_11726_2n타일링 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = ReaderUtil.inputInReader();
    int N = Integer.parseInt(br.readLine());  // 1 ~ 1000
    int[] memo = new int[N + 1];  // 메모이제이션
    memo[1] = 1;
    if (N > 1) memo[2] = 2;

    for (int i = 3; i < memo.length; i++) {
      memo[i] = (memo[i - 1] + memo[i - 2] * 2) % 10_007;
    }

    System.out.println(memo[N]);
  }
}

/**
 * (a + b) % p = (a % p + b % p) % p
 * (a - b) % p = (a % p - b % p) % p
 * (a * b) % p = (a % p * b % p) % p
 * (a / b) % p != (a % p / b % p) % p
 *
 * 나머지에는 분배연산이 적용하지 않는다.
 * 따라서 페르마의 소정리를 알아야 한다.
 *
 * 정수론
 * 페르마의 소정리
 */
