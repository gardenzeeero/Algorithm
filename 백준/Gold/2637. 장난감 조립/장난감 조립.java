import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;
import static java.util.Arrays.stream;


/**
 * inorder -> 0 이다? 기본 부품
 * 부품들을 기본 부품화 시킬 필요가 있음 -> 기본 부품
 * 무조건 메모이제이션 -> 아직 안구해진 건 -> 구하러 가면 됨 -> 재귀로? -> 해봤자 depth 100
 * 뭐 뭐 필요한지 기록할 필요가 있고 -> HashMap으로 뭐뭐 필요한지 적고, 해당 HashMap이 기본부품으로만 이루어져 있따?
 * 그러면 그건 한번 왔던애 -> 바로 반환 -> 이걸 리스트 돌지말고 그냥 boolean으로 체크하자.
 */
public class Main {

    static int n;
    static int m;
    static ArrayList<TreeMap<Integer, Integer>> needs = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();

        update(n);

        for (Map.Entry<Integer, Integer> entry : needs.get(n).entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public static void update(int target) {
        visited[target] = true;

        TreeMap<Integer, Integer> updated = new TreeMap<>();
        ArrayList<Integer> mustBeDeleted = new ArrayList<>();

        TreeMap<Integer, Integer> targetNeeds = needs.get(target);
        for (Map.Entry<Integer, Integer> entry : targetNeeds.entrySet()) {
            int need = entry.getKey();
            int count = entry.getValue();
            if (!visited[need]) {
                update(need);
            }

            TreeMap<Integer, Integer> needMap = needs.get(need);

            //기본이 아니면 삭제해야 함
            if (!needMap.isEmpty()) {
                mustBeDeleted.add(entry.getKey());
            }

            for (Map.Entry<Integer, Integer> needEntry : needMap.entrySet()) {
                Integer existed = updated.get(needEntry.getKey());
                if (existed == null) {
                    updated.put(needEntry.getKey(), needEntry.getValue() * count);
                } else {
                    updated.put(needEntry.getKey(), existed + needEntry.getValue() * count);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : updated.entrySet()) {
            Integer existed = targetNeeds.get(entry.getKey());
            if (existed == null) {
                targetNeeds.put(entry.getKey(), entry.getValue());
            } else {
                targetNeeds.put(entry.getKey(), existed + entry.getValue());
            }
        }

        for (Integer delete : mustBeDeleted) {
            targetNeeds.remove(delete);
        }

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];

        for (int i = 0; i <= n; i++) {
            needs.add(new TreeMap<>());
        }
        visited = new boolean[n + 1];

        input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = input[0];

        for (int i = 0; i < m; i++) {
            input = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            needs.get(input[0]).put(input[1], input[2]);
        }
    }
}
