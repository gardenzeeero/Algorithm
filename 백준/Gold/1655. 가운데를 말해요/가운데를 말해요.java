import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> first = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> second = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            Integer middle = first.peek();

            if (middle == null) {
                first.add(num);
            } else if (num < middle) {
                if (first.size() > second.size()) second.add(first.poll());
                first.add(num);
            } else {
                second.add(num);
                if (first.size() < second.size()) first.add(second.poll());
                
            }

            sb.append(first.peek()).append('\n');
        }
        System.out.println(sb);
    }
}