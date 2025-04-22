import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, a, b;
    static LinkedList<Integer> building = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();


        if (a + b - 1 > n) {
            System.out.println(-1);
            return;
        }

        if (a > b) {
            for(int i=1; i<=a; i++) {
                building.add(i);
            }
            for (int i=b-1; i>=1; i--) {
                building.add(i);
            }
        } else {
            for(int i=1; i<=a-1; i++) {
                building.add(i);
            }
            for (int i=b; i>=1; i--) {
                building.add(i);
            }
        }
        int loop = n - (a + b - 1);
        if (a != 1) {
            for (int i=0; i<loop; i++) {
                building.add(0, 1);
            }
        } else {
            for (int i=0; i<loop; i++) {
                building.add(a, 1);
            }
        }




        for (Integer num : building) {
            System.out.print(num + " ");
        }

    }

    static void init() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0]; a = input[1]; b = input[2];
    }
}
