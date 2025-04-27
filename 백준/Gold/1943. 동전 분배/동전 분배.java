import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; i++) {

            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int n = input[0];
            int sum = 0;

            int[] coins = new int[100001];
            for (int j=0; j<n; j++) {
                input = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                coins[input[0]] = input[1];
                sum += input[0] * input[1];
            }

            if (sum % 2 != 0) {
                System.out.println(0);
                continue;
            }

            sum /= 2;

            boolean[] prices = new boolean[sum+1];
            prices[0] = true;
            for(int j=1; j<100001; j++) {
                if (coins[j] == 0) continue;
                for (int k=sum; k>=0; k--) {
                    if (!prices[k]) continue;
                    for (int l=1; l<=coins[j]; l++){
                        if (k + j * l <= sum) prices[k + j*l] = true;
                    }
                }
            }

            if (prices[sum]){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
