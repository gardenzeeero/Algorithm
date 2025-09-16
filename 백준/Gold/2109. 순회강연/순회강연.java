import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

import static java.lang.System.in;

public class Main {

    static int n;
    static int maxDay = 0;
    static PriorityQueue<Offer> offers = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.day, o1.day));

    static class Offer {
        int day, price;

        public Offer(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        int answer = 0;
        PriorityQueue<Offer> canDo = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.price, o1.price));
        for (int i = maxDay; i >= 1; i--) {
            while (!offers.isEmpty()) {
                if (offers.peek().day < i) break;
                canDo.add(offers.poll());
            }

            if (canDo.isEmpty()) continue;
            answer += canDo.poll().price;
        }

        System.out.println(answer);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int p = input[0];
            int d = input[1];

            offers.add(new Offer(d, p));
        }
        if (n != 0) {
            maxDay = offers.peek().day;
        } else {
            maxDay = 0;
        }

    }
}
