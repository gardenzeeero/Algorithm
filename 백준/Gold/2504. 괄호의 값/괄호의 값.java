import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static ArrayDeque<String> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("");

        int temp = 1;
        int answer = 0;

        for (int i = 0; i < strs.length; i++) {
            String now = strs[i];

            if (now.equals("(")) {
                stack.addLast(now);
                temp *= 2;
            } else if (now.equals("[")) {
                stack.addLast(now);
                temp *= 3;
            } else if (now.equals(")")) {
                String last = stack.pollLast();
                if (isValid(now, last)) {
                    if (strs[i - 1].equals("(")) {
                        answer += temp;
                    }

                    temp /= 2;
                } else {
                    answer = 0;
                    break;
                }
            } else if (now.equals("]")) {
                String last = stack.pollLast();
                if (isValid(now, last)) {
                    if (strs[i - 1].equals("[")) {
                        answer += temp;
                    }
                    temp /= 3;
                } else {
                    answer = 0;
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
        
    }

    static boolean isValid(String now, String last) {
        if ("(".equals(last) && ")".equals(now)) return true;
        if ("[".equals(last) && "]".equals(now)) return true;

        return false;
    }
}
