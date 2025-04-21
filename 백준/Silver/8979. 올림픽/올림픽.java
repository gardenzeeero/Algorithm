import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;

    static Country[] rank;
    static int[] finalRank;

    static class Country {
        int cnum, gold, silver, dong;
        public Country(int cnum, int gold, int silver, int dong) {
            this.cnum = cnum; this.gold = gold; this.silver = silver; this.dong = dong;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        for (int i=0; i<n; i++) {
            if (rank[i].cnum == k) {
                System.out.print(finalRank[i]);
            }
        }
    }

    static void init() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0]; k = input[1];

        rank = new Country[n];
        for (int i=0; i<n; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            rank[i] = new Country(input[0], input[1], input[2], input[3]);
        }

        Arrays.sort(rank, (p1, p2) -> {
           if (p1.gold != p2.gold) return Integer.compare(p2.gold, p1.gold);
           if (p1.silver != p2.silver) return Integer.compare(p2.silver, p1.silver);
           return Integer.compare(p2.dong, p1.dong);
        });

        finalRank = new int[n];
        finalRank[0] = 1;
        for (int i=1; i<n; i++) {
            Country prev = rank[i-1];
            Country cur = rank[i];
            if (prev.gold == cur.gold && prev.silver == cur.silver && prev.dong == cur.dong) finalRank[i] = finalRank[i-1];
            else finalRank[i] = i+1;
        }
    }
}
