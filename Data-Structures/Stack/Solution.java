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
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) 
    {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= h.size(); i++) 
        {
            int currentHeight = (i == h.size()) ? 0 : h.get(i);

            while (!stack.isEmpty() && currentHeight < h.get(stack.peek())) 
            {
                int height = h.get(stack.pop());
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String outputPath = System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter = outputPath == null
            ? new BufferedWriter(new OutputStreamWriter(System.out))
            : new BufferedWriter(new FileWriter(outputPath));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
