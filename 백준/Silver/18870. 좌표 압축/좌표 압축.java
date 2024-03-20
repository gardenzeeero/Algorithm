import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> input = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);

        HashMap<Integer, Integer> hm = new HashMap<>();
        int prev = 1987654321, count = 0;
        for(int a : sorted){
            if(a != prev) hm.put(Integer.valueOf(a), Integer.valueOf(count++));
            prev = a;
        }


        for(int i=0; i<n; i++){
            bw.write(hm.get(Integer.valueOf(arr[i])) + " ");
        }
        bw.flush();

    }
}
