import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int g, p;
    static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        max = new int[g + 1];

        for (int i = 1; i <= g; i++) {
            max[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int plane = Integer.parseInt(br.readLine());
            int available = find(plane);

            if (available == 0) {
                break;
            }

            result++;
            union(find(available - 1), available);
        }

        System.out.println(result);
    }

    static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);

        if (p1 < p2) {
            max[p2] = p1;
        } else {
            max[p1] = p2;
        }
    }

    static int find(int c) {
        int root = c;

        while (root != max[root]) {
            root = max[root];
        }

        while (c != root) {
            int temp = max[c];
            max[c] = root;
            c = temp;
        }

        return root;
    }
}


