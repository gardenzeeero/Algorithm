import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 몇 등 짜릴 찾을 때 n으로 찾으면 안됨 -> 100만 * 10만
 * 넣을 때도 arrayList 이런거면 안됨, linked list도 위험할 듯
 * 20억 이니까 숫자를 줄세우는 건 아님
 * 맛이 100만 까지니까 이걸 이용 -> 숫자 몇의 맛이 몇개 있는지
 * -> 근데 이러면 등수를 어떻게 알지? -> 등수를 따로 관리
 * 누적합 -> 절대 아님 -> 뒤를 다 업데이트 쳐줘야해
 * 앞에서 부터 더해가면서 찾아간다 -> 회당 최대 100만 -> 100만 * 10만 무조건 시간 초과
 * 세그먼트 트리!
 */

public class Main {

    static int n;
    static int maxTaste = 1000000;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int treeSize = 1;
        while (true) {
            if (treeSize > maxTaste) break;
            treeSize *= 2;
        }

        treeSize *= 2;
        count = new int[treeSize];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (input[0] == 1) {
                //뽑기
                int found = find(input[1]);
                update(found, -1);
                System.out.println(found);
//                debug();
            } else {
                if (input[2] > 0) { //넣기
                    for (int j = 0; j < input[2]; j++) {
                        update(input[1], 1);
//                        debug();
                    }
                } else {//빼기
                    for (int j = 0; j < -input[2]; j++) {
                        update(input[1], -1);
//                        debug();
                    }
                }
            }
        }
    }

    static void debug() {
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) continue;
            System.out.print(i + " " + count[i] + " / ");
        }

        System.out.println();
    }

    static int find(int rank) {
        int leftNum = 1, rightNum = 1000000;
        int curIdx = 1;
        while (true) {
            int leftCount = count[curIdx * 2];

            if (leftCount < rank) {
                rank -= leftCount;
                curIdx = curIdx * 2 + 1;
                leftNum = (leftNum + rightNum) / 2 + 1;
            } else {
                curIdx = curIdx * 2;
                rightNum = (leftNum + rightNum) / 2;
            }

            if (leftNum == rightNum) {
                return leftNum;
            }
        }
    }

    static void update(int taste, int dir) {
        int leftNum = 1, rightNum = 1000000;
        int curIdx = 1;

        while (true) {
            int mid = (leftNum + rightNum) / 2;
            if (mid < taste) {
                leftNum = mid + 1;
                curIdx = curIdx * 2 + 1;
            } else {
                rightNum = mid;
                curIdx = curIdx * 2;
            }

            if (leftNum == rightNum) {
                count[curIdx] += dir;
                break;
            }
        }

        while (true) {
            if (curIdx == 0) break;
            int parentIdx = curIdx / 2;
            count[parentIdx] += dir;
            curIdx /= 2;
        }
    }
}
