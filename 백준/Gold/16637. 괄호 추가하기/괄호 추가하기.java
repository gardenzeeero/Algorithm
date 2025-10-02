import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.in;
import static java.util.Arrays.stream;


public class Main {
    static int n;
    static boolean[] used;
    static String input;
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<String> operators = new ArrayList<>();
    static long result = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] inputs = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = inputs[0];
        used = new boolean[n / 2];

        input = br.readLine();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums.add(input.charAt(i) - '0');
            } else {
                operators.add(String.valueOf(input.charAt(i)));
            }
        }


        find(0);
        System.out.print(result);
    }

    static void find(int idx) {
        if (idx == n / 2) {
            result = Math.max(result, calculate());
            return;
        }

        if (idx == 0 || !used[idx - 1]) {
            used[idx] = true;
            find(idx + 1);
            used[idx] = false;
        }

        find(idx + 1);
    }

    static long calculate() {
        long temp = 0;

        ArrayList<String> tempSick = new ArrayList<>();
        boolean[] numUsed = new boolean[n / 2 + 1];
        for (int i = 0; i < n / 2; i++) {
            if (used[i]) {
                int first = nums.get(i);
                int second = nums.get(i + 1);
                numUsed[i] = true;
                numUsed[i + 1] = true;
                String op = operators.get(i);
                int tempResult = 0;

                if (op.equals("+")) {
                    tempResult = first + second;
                } else if (op.equals("-")) {
                    tempResult = first - second;
                } else if (op.equals("*")) {
                    tempResult = first * second;
                }
                tempSick.add(String.valueOf(tempResult));
            } else {
                if (!numUsed[i]) {
                    tempSick.add(String.valueOf(nums.get(i)));
                }
                tempSick.add(operators.get(i));
            }
        }
        if (!numUsed[n / 2]) tempSick.add(String.valueOf(nums.get(n / 2)));

        temp = Integer.valueOf(tempSick.get(0));
        for (int i = 1; i < tempSick.size(); i += 2) {
            String op = tempSick.get(i);
            int second = Integer.valueOf(tempSick.get(i + 1));

            if (op.equals("+")) {
                temp += second;
            } else if (op.equals("-")) {
                temp -= second;
            } else if (op.equals("*")) {
                temp *= second;
            }
        }
        return temp;
    }
}
