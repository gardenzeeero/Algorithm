import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.*;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.*;

public class Main {

    static PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    static PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];


        int inputNum = Integer.parseInt(br.readLine());
        left.add(inputNum);
        System.out.println(left.peek());
        for (int i=1; i<n; i++) {
            inputNum = Integer.parseInt(br.readLine());

            int leftNum = left.peek();
            if (leftNum < inputNum) {
                right.add(inputNum);
                if (right.size() > left.size()) left.add(right.poll());
            } else {
                left.add(inputNum);
                if (left.size() - 1 > right.size()) {
                    right.add(left.poll());
                }
            }
            System.out.println(left.peek());
        }
    }
}
