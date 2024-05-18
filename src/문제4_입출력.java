import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader
 * Scanner
 * JOptionPane
 * 2 3 2 1 2 3 4
 * 2321234
 * 쪼개기, String.split(), StringTokenizer, 안쪼개기
 */
public class 문제4_입출력 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();  // 줄바꿈 전까지의 한 줄을 받아옴
    int age = Integer.parseInt(line);
    System.out.println(age);
  }
}
