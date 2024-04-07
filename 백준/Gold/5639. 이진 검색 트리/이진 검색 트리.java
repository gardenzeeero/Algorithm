//22012163 정원영

import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr = new int[10000];
    public static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

    public static void recursive(int start, int endNext) throws IOException{
        if(start >= endNext){ return; }
        else{
            int idx;
            for(idx=start+1; idx<endNext; idx++){
                if(arr[start] < arr[idx]) break;
            }
            recursive(start+1, idx);
            recursive(idx, endNext);
            bw.write(arr[start] + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        int idx = 0;
        while((input = br.readLine()) != null){
            arr[idx++] = Integer.parseInt(input);
        }

        recursive(0, idx);
        bw.flush();
    }
}