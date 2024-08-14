import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'authEvents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts 2D_STRING_ARRAY events as parameter.
   */

  public static List<Integer> authEvents(List<List<String>> events) {
    // Write your code here

  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int eventsRows = Integer.parseInt(bufferedReader.readLine().trim());
    int eventsColumns = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<String>> events = new ArrayList<>();

    IntStream.range(0, eventsRows).forEach(i -> {
      try {
        events.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList()));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<Integer> result = Result.authEvents(events);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n");

    bufferedReader.close();
    bufferedWriter.close();
  }
}

public class Solution2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> stocksProfit = IntStream.range(0, stocksProfitCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    long target = Long.parseLong(bufferedReader.readLine().trim());

    int result = Result.stockPairs(stocksProfit, target);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
