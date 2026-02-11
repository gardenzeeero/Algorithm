import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int fiveCount = n / 5; fiveCount >= 0; fiveCount--) {
            int threeCount = (n - fiveCount * 5) / 3;
            if (fiveCount * 5 + threeCount * 3 == n) {
                System.out.println(fiveCount + threeCount);
                return;
            }
        }
        System.out.println(-1);
    }
}