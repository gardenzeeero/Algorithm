import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for (int i = 1; i <= 10; i++) {
            sb.append("#").append(i).append(" ");
            int n = Integer.parseInt(br.readLine());

            boolean isBad = false;
            for (int j = 1; j <= n; j++) {
                String[] input = br.readLine().split(" ");
                boolean hasChild = input.length > 2;
                boolean nodeIsNumber = isNumber(input[1]);

                if (hasChild) {
                    if (nodeIsNumber) isBad = true;
                } else {
                    if (!nodeIsNumber) isBad = true;
                }
            }

            if (isBad) sb.append("0\n");
            else sb.append("1\n");
        }

        System.out.println(sb);

    }

    static boolean isNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}