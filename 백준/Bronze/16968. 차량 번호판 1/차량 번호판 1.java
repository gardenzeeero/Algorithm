import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static String[] input;
    static int count = 10;

    public static void main(String[] args) throws IOException {
        init();
        if (input[0].equals("c")) count = 26;

        for (int i=1; i<input.length; i++) {
            int temp;
            if (input[i].equals("c")) temp = 26;
            else temp = 10;

            if (input[i].equals(input[i-1])) temp--;
            count *= temp;
        }

        System.out.print(count);
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split("") ;
    }
}
