import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static LinkedList<String> list;
    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();
        list = new LinkedList<>();

        int idx = 0;
        while (idx < input.length) {
            idx = makeNumber(idx);
        }

        while (true) {
            if (list.size() == 1) break;
            if (list.size() == 3) {
                long result = calculate(Long.parseLong(list.get(0)), Long.parseLong(list.get(2)), list.get(1));
                removeThree(0);
                list.add(String.valueOf(result));
                break;
            }

            int priority = getPriority(list.get(1)) - getPriority(list.get(list.size() - 2));
            if (priority > 0) {
                long result = calculate(Long.parseLong(list.get(0)), Long.parseLong(list.get(2)), list.get(1));
                removeThree(0);
                list.addFirst(String.valueOf(result));
            } else if (priority < 0) {
                long result = calculate(Long.parseLong(list.get(list.size() - 3)), Long.parseLong(list.get(list.size() - 1)), list.get(list.size() - 2));
                removeThree(-1);
                list.addLast(String.valueOf(result));
            } else {
                long p1 = calculate(Long.parseLong(list.get(0)), Long.parseLong(list.get(2)), list.get(1));
                long p2 = calculate(Long.parseLong(list.get(list.size() - 3)), Long.parseLong(list.get(list.size() - 1)), list.get(list.size() - 2));
                if (p1 >= p2) {
                    removeThree(0);
                    list.addFirst(String.valueOf(p1));
                } else {
                    removeThree(-1);
                    list.addLast(String.valueOf(p2));
                }
            }
        }

        System.out.println(Long.parseLong(list.getFirst()));
    }

    static void removeThree(int idx) {
        if (idx < 0) {
            for (int i = 0; i < 3; i++) {
                list.removeLast();
            }
        } else {
            for (int i = 0; i < 3; i++) {
                list.removeFirst();
            }
        }
    }

    static long calculate(long a, long b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        if (op.equals("*")) return a * b;
        return a / b;
    }

    static int getPriority(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    static int makeNumber(int idx) {
        StringBuilder sb = new StringBuilder();
        int newIdx;
        for (newIdx = idx; newIdx < input.length; newIdx++) {
            char c = input[newIdx];
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (newIdx == 0) {
                    sb.append(input[newIdx]);
                    continue;
                } else if (newIdx == idx) {
                    sb.append(input[newIdx]);
                    newIdx++;
                }
                break;
            }
            sb.append(input[newIdx]);
        }
        list.add(sb.toString());

        return newIdx;
    }
}