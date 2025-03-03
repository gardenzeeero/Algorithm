import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int stair;
    static int[] score;
    static int[][] scoreSum;


    public static void main(String[] args) throws IOException{
        init();

        for (int i=2; i<=stair; i++) {
            scoreSum[i][0] = scoreSum[i-1][1] + score[i]; //0이 한칸 전에서 온거
            scoreSum[i][1] = Math.max(scoreSum[i-2][0], scoreSum[i-2][1]) + score[i]; //1이 두칸 전에서 온거
        }

        System.out.print(Math.max(scoreSum[stair][0], scoreSum[stair][1]));

    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stair = Integer.parseInt(br.readLine());
        score = new int[stair+1];
        scoreSum = new int[stair+1][2];


        for (int i=1; i<=stair; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        scoreSum[1][0] = score[1];
        scoreSum[1][1] = score[1];
    }
}
