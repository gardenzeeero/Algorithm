import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 모양의 갯수가 적음 -> 순서를 다 하니씩 해보면 될 듯 -> 6가지
 * 그럼 최적으로 옮기는거 어떻게 되는거지?
 * 우선 서로 제자리에 들어가면 이득
 * 갯수를 세면 들어갈 자리가 정해짐
 * 세모 자리에 네모가 있을 때 -> 네모 범위에서 세모 찾기 -> 없으면 다른 범위에서 찾기
 * 네모 범위에서 세모 찾기 -> 최대 3만 -> 매번 찾지 말고 한번에 찾아둘까?
 * 없으면 다른 범위에서 찾기 -> 최대 3만 -> 이것도 한번에?
 * 그럼 최대 원소가 6만개? ㄱㅊ을듯 메모리 좀 애매하긴해
 * 이것말곤 떠오르지 않는다.
 * 백트래킹도 넣으면 될 듯
 */
public class Main {
    static int n;
    static int[] arr;
    static int[] count;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = Integer.MAX_VALUE;
        boolean[] visited = new boolean[4];
        count = new int[4];
        for (int i = 0; i < n; i++) count[arr[i]]++;

        permutation(visited, 0, new int[3]);

        System.out.println(result);
    }

    static void permutation(boolean[] visited, int cnt, int[] order) {
        if (cnt == 3) {
            make(order);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (visited[i]) continue;
            order[cnt] = i;
            visited[i] = true;
            permutation(visited, cnt + 1, order);
            visited[i] = false;
            order[cnt] = 0;
        }
    }

    //order 순서대로 Idx 부터 배치
    static void make(int[] order) {
        int[][] wrongCount = new int[3][3];

        int first = 0, last = count[order[0]];
        for (int i = 0; i < 3; i++) {
            for (int j = first; j < last; j++) {
                if (arr[j] == order[i]) continue;
                if (arr[j] == order[(i + 1) % 3]) wrongCount[i][(i + 1) % 3]++;
                if (arr[j] == order[(i + 2) % 3]) wrongCount[i][(i + 2) % 3]++;
            }

            if (i != 2) {
                first = last;
                last += count[order[i + 1]];
            }
        }

        int count = 0;
        count += Math.min(wrongCount[0][1], wrongCount[1][0]);
        wrongCount[0][1] -= Math.min(wrongCount[0][1], wrongCount[1][0]);

        count += Math.min(wrongCount[0][2], wrongCount[2][0]);
        wrongCount[0][2] -= Math.min(wrongCount[0][2], wrongCount[2][0]);

        count += Math.min(wrongCount[1][2], wrongCount[2][1]);
        wrongCount[1][2] -= Math.min(wrongCount[1][2], wrongCount[2][1]);

        count += (wrongCount[0][1] + wrongCount[0][2]) * 2;

        result = Math.min(result, count);
    }


}