import java.util.*;
import java.io.*;


public class Main {

    static int n;

    static List<String> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];


        arr = new ArrayList<>(n);
        for (int i=0; i<n; i++) {
            arr.add(br.readLine());
        }

        int maxLen = 0;
        String firstWord;
        String secondWord;
        String finalFirstWord = "";
        String finalSecondWord = "";
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                firstWord = arr.get(i);
                secondWord = arr.get(j);
                int wordLen = Math.min(firstWord.length(), secondWord.length());
                int count = 0;
                for (int k=0; k<wordLen; k++) {
                    if (firstWord.charAt(k) == secondWord.charAt(k)) count++;
                    else break;
                }

                if (count > maxLen) {
                    maxLen = count;
                    finalFirstWord = firstWord;
                    finalSecondWord = secondWord;
                }
            }
        }

        System.out.println(finalFirstWord);
        System.out.println(finalSecondWord);
    }
}
