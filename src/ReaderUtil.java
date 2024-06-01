import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReaderUtil {
  public static BufferedReader inputInReader() {
    return new BufferedReader(new InputStreamReader(System.in));
  }

  public static StringTokenizer newTokenizer(String brReadLine) {
    return new StringTokenizer(brReadLine, " ");
  }
}
