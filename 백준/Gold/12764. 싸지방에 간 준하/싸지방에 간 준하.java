import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int seatCount = 0;
    static User[] users;
    static PriorityQueue<Seat> seats = new PriorityQueue<>();
    static PriorityQueue<Integer> available = new PriorityQueue<>();
    static int[] count;

    static class User implements Comparable<User> {
        int st, end;
        public User (int st, int end) {
            this.st = st; this.end = end;
        }

        @Override
        public int compareTo(User user) {
            return Integer.compare(this.st, user.st);
        }
    }

    static class Seat implements Comparable<Seat>{
        int end, count, num;
        public Seat (int end, int num) {
            this.end = end; this.num = num;
            this.count = 1;
        }

        @Override
        public int compareTo(Seat seat) {
            if (this.end != seat.end) {
                return Integer.compare(this.end, seat.end);
            }
            return Integer.compare(this.num, seat.num);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        for (int i=0; i<n; i++) {
            User user = users[i];

            while(!seats.isEmpty()) {
                Seat seat = seats.peek();
                if (seat.end < user.st) {
                    available.add(seat.num);
                    seats.poll();
                } else {
                    break;
                }
            }

            Integer seatNum = available.poll();
            if (seatNum == null) {
                seats.add(new Seat(user.end, ++seatCount));
                count[seatCount]++;
            } else {
                seats.add(new Seat(user.end, seatNum));
                count[seatNum]++;
            }
        }

        System.out.println(seatCount);
        for (int i=1; i<=seatCount; i++) {
            System.out.print(count[i] + " ");
        }

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        users = new User[n];
        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            users[i] = new User(input[0], input[1]);
        }
        Arrays.sort(users);
        count = new int[n+1];
    }
}
