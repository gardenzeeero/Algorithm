import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int arrlen = Integer.parseInt(br.readLine());
            int[] arr = new int[arrlen];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }

            int sum = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < arrlen; i++) {
                for (int j = i + 1; j < arrlen; j++) {
                    if (arr[i] + arr[j] == sum) {
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
        catch (Exception o){

        }
    }
}
