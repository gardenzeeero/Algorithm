import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);

        int[] st = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> arr = new HashMap<>();
        for(int i=0; i<n; i++) {
            arr.put(st[i], i);
        }

        int prevIdx = 0;
        int maxCount = 0, count = 0;
        for(int i=1; i<=n; i++) {
            int curIdx = arr.get(i);
            count++;
            if(curIdx < prevIdx) {
                maxCount = Math.max(maxCount, count-1);
                count = 1; //현재 수 포함
            }
            prevIdx = curIdx;
        }

        if(maxCount == 0) {
            System.out.println(0);
        } else{
            System.out.println(n - maxCount);
        }



    }
}
