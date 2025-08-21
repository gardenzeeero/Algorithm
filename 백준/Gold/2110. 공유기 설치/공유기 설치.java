import java.io.*;
import java.util.*;

public class Main {

    static int n, c;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; c = input[1];

        house = new int[n];
        for (int i=0; i<n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int answer = 1;
        int left = 1; int right = house[n-1] - house[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = findCount(mid);

            if (count >= c) {
                left = mid+1;
                answer = Math.max(answer, mid);
            }
            else right = mid-1;
        }

        System.out.println(answer);


    }

    static int findCount(int minDist) {
        int count = 1;
        int prev = house[0];
        for (int i=1; i<n; i++) {
            if (house[i] - prev >= minDist) {
                count++;
                prev = house[i];
            }
        }

        return count;
    }
}
