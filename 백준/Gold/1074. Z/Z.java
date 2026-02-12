import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, tr, tc;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tr = Integer.parseInt(st.nextToken());
        tc = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        find(0, 0, size, 0);

        System.out.println(result);
    }

    public static void find(int r, int c, int size, int count) {
        if (size == 1) {
            result = count;
            return;
        }

        int half = size / 2;
        int area = half * half;

        if (tr < r + half && tc < c + half) {
            find(r, c, half, count);
        } else if (tr < r + half && tc >= c + half) {
            find(r, c + half, half, count + area);
        } else if (tr >= r + half && tc < c + half) {
            find(r + half, c, half, count + area * 2);
        } else {
            find(r + half, c + half, half, count + area * 3);
        }
    }
}