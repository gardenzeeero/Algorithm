import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        char[] balls = br.readLine().toCharArray();

        int answer = Integer.MAX_VALUE;

        answer = Math.min(answer, toLeft(n, 'R', balls));
        answer = Math.min(answer, toLeft(n, 'B', balls));
        answer = Math.min(answer, toRight(n, 'R', balls));
        answer = Math.min(answer, toRight(n, 'B', balls));

        System.out.println(answer);

    }

    static int toLeft(int n, char ballColor, char[] balls) {
        boolean otherColorFlag = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ballColor != balls[i]) {
                otherColorFlag = true;
                continue;
            }
            if (!otherColorFlag) continue;
            count++;
        }

        return count;
    }

    static int toRight(int n, char ballColor, char[] balls) {
        boolean otherColorFlag = false;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (ballColor != balls[i]) {
                otherColorFlag = true;
                continue;
            }
            if (!otherColorFlag) continue;
            count++;
        }

        return count;
    }
}
