import java.io.*;
import java.util.*;

public class Main {
    static int[][][] count;
    static int t, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = input[0]; w = input[1];
        count = new int[3][w+1][t+1];

        for (int i=1; i<=2; i++) {
            for (int j=0; j<w+1; j++) {
                for (int k=0; k<t+1; k++) {
                    count[i][j][k] = -1;
                }
            }
        }

        count[1][w][0] = 0;

        for (int time=0; time<t; time++) {
            int pos = Integer.parseInt(br.readLine());
            int nextTime = time+1;

            for (int curPos=1; curPos<=2; curPos++) {
                for (int leftCount=0; leftCount<w+1; leftCount++) {
                    int curCount = count[curPos][leftCount][time];

                    if (curCount == -1) continue;
                    if (curPos == pos) {
                        count[curPos][leftCount][nextTime] = Math.max(count[curPos][leftCount][nextTime], curCount+1);
                    } else {
                        if (leftCount > 0) {
                            int nextPos = pos == 1 ? 1 : 2;
                            count[nextPos][leftCount-1][nextTime] = Math.max(count[nextPos][leftCount-1][nextTime], curCount+1);
                        }
                        count[curPos][leftCount][nextTime] = Math.max(count[curPos][leftCount][nextTime], curCount);
                    }
                }
            }
        }

        int answer = 0;
        for (int i=1; i<=2; i++) {
            for (int j=0; j<=w; j++) {
                answer = Math.max(answer, count[i][j][t]);
            }
        }

        System.out.print(answer);
    }
}
