import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;
import static java.util.Arrays.stream;


/**
 * dp인데 이전 값이 필요 X -> 한사이클 돌때마다 연료 -1
 * 있어야하는 정보 = 현재위치 -> 어차피 한사이클이니까 필요 X
 * 연료 + 교환횟수 -> 교환횟수가 같으면 연료만 있으면 되는거 아닌가? -> dp니까 굳이 같은 연료에 교환횟수가 있을 이유가
 * 현재위치에서 -> 최대연료 + 최소 환승 -> 최소 환승이지만 연료가 부족하면? -> dp로 해결안되는것 같긴한데
 * 주유소가 10000개면 배열에 총 넣냐 안넣냐 -> 2의 10000승개가 들어가나?
 * 위치 + 연료 -> 최소 환승 이렇게 해야하는데 위치가 100만 * 100 * 10000 아무튼 존나 많아
 * equals를 선언하면 되긴한데 arrayList 에다가 hashmap으로 하면 될듯
 */
public class Main {

    //key가 교환횟수, value가 연
    static int[] oil;
    static TreeMap<Integer, Integer> stations = new TreeMap<>();
    static int n, l, p;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        oil = new int[n + 1];

        for (int i = 0; i < n; i++) {
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stations.put(input[0], input[1]);
        }

        input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        l = input[0];
        p = input[1];

        for (int i = 0; i <= n; i++) {
            oil[i] = -1;
        }

        oil[0] = p;
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : stations.entrySet()) {
            Integer stationPos = entry.getKey();
            for (int i = 0; i <= n; i++) {
                if (oil[i] < stationPos - cur) oil[i] = -1;
                else oil[i] -= stationPos - cur;
            }

            for (int i = n; i >= 0; i--) {
                if (oil[i] == -1) continue;
                if (oil[i + 1] == 0) oil[i + 1] = oil[i] + entry.getValue();
                else oil[i + 1] = Math.max(oil[i] + entry.getValue(), oil[i + 1]);
            }

            cur = stationPos;
        }

        for (int i = 0; i <= n; i++) {
            if (oil[i] < l - cur || oil[i] == -1) continue;
            else {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }
}
