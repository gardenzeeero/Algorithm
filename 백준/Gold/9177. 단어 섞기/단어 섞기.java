import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static String word1, word2, word3;
    static boolean[][] tried;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            System.out.print("Data set " + i + ": ");

            String[] words = br.readLine().split(" ");
            word1 = words[0];
            word2 = words[1];
            word3 = words[2];

            tried = new boolean[word1.length() + 1][word2.length() + 1];
            boolean canMake = tryMaking(0, 0, 0);
            if (canMake) System.out.println("yes");
            else System.out.println("no");
        }
    }

    static boolean tryMaking(int idx1, int idx2, int idx3) {
        if (word3.length() == idx3) return true;

        if (tried[idx1][idx2]) return false;

        char target = word3.charAt(idx3);
        boolean result = false;

        if (word1.length() == idx1) {
            if (word2.charAt(idx2) == target) {
                result = tryMaking(idx1, idx2 + 1, idx3 + 1);
            }
        } else if (word2.length() == idx2) {
            if (word1.charAt(idx1) == target) {
                result = tryMaking(idx1 + 1, idx2, idx3 + 1);
            }
        } else if (word1.charAt(idx1) != word2.charAt(idx2)) {
            if (word1.charAt(idx1) == target) result = tryMaking(idx1 + 1, idx2, idx3 + 1);
            else if (word2.charAt(idx2) == target) result = tryMaking(idx1, idx2 + 1, idx3 + 1);
        } else {
            result = tryMaking(idx1 + 1, idx2, idx3 + 1) || tryMaking(idx1, idx2 + 1, idx3 + 1);
        }

        if (!result) {
            tried[idx1][idx2] = true;
            return false;
        }

        return true;
    }
}
