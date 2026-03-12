import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    static Set<Long> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            ArrayDeque<String> q = new ArrayDeque<>();
            String[] input = br.readLine().split("");
            for (int i=0; i<n; i++) {
                q.add(input[i]);
            }

            Set<Long> set = new TreeSet<>();
            int loop = n/4;

            int init = 1;
            for (int i=0; i<loop-1; i++) {
                init *= 16;
            }

            for (int s=0; s<loop; s++) {
                for (int i=0; i<4; i++) {
                    long temp = 0;
                    int multi = init;
                    for (int j=0; j<loop; j++) {
                        String num = q.poll();
                        q.add(num);
                        temp += makeInt(num) * multi;
                        multi /= 16;
                    }
                    set.add(temp);
                }   
                q.addFirst(q.pollLast());
            }
            

            Long[] result = set.toArray(new Long[0]);

            Arrays.sort(result, Collections.reverseOrder());
            sb.append(result[k-1]).append("\n");
        }

        System.out.print(sb.toString());
    }

    static int makeInt(String s) {
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            return Integer.parseInt(s);
        }
        
        return s.charAt(0) - 'A' + 10;
    }
}