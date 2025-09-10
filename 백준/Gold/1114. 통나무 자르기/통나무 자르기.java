import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int l, k, c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        int left = 0;
        int right = l;

        int longestLen = 0;
        int firstCut = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cutsNeeded = getCutsNeeded(mid);

            if (cutsNeeded != -1) {
                // mid 길이로 자르는 것이 가능
                longestLen = mid;
                firstCut = findFirstCut(mid);
                right = mid - 1; // 더 짧은 길이도 가능한지 탐색
            } else {
                // mid 길이로 자르는 것이 불가능
                left = mid + 1; // 더 긴 길이로 시도
            }
        }

        System.out.println(longestLen + " " + firstCut);
    }

    // 주어진 최대 길이(limit)로 통나무를 자를 때 필요한 최소 톱질 횟수 계산
    static int getCutsNeeded(int limit) {
        if (limit == 0) return -1; // 길이가 0이면 불가능
        int cuts = 0;
        int prev = l; // 통나무의 끝에서 시작

        for (int i = arr.length - 1; i >= 1; i--) {
            int currentPieceLen = prev - arr[i];

            // 현재 조각 길이가 limit을 초과하는지 확인
            if (currentPieceLen > limit) {
                // 너무 길면 이전 톱질 지점에서 잘라야 함
                cuts++;
                prev = arr[i + 1];
                i++; // 자른 위치에서 다시 시작하기 위해 인덱스 조정
            } else {
                // 인접한 톱질 지점 간의 거리가 limit을 초과하는지 확인
                if (arr[i] - arr[i - 1] > limit) {
                    return -1; // 불가능
                }
            }
        }

        // 마지막 남은 조각(가장 왼쪽)의 길이 확인
        if (prev > limit) {
            cuts++;
        }

        if (cuts > c) {
            return -1; // 톱질 횟수 초과
        }
        return cuts;
    }

    // 주어진 최대 길이(limit)로 자를 때 첫 번째 톱질 위치를 계산
    static int findFirstCut(int limit) {
        int cuts = 0;
        int prev = l;
        int firstCut = l;

        for (int i = arr.length - 1; i >= 1; i--) {
            int currentPieceLen = prev - arr[i];

            if (currentPieceLen > limit) {
                cuts++;
                prev = arr[i + 1];
                firstCut = arr[i + 1];
                i++;
            }
        }
        
        // 톱질 횟수가 c보다 적으면 가장 작은 첫 톱질 위치를 선택
        if (cuts < c) {
            return arr[1];
        }
        
        return firstCut;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        l = input[0];
        k = input[1];
        c = input[2];

        // 톱질 위치 중복 제거 및 0, L 추가
        Set<Integer> set = new TreeSet<>();
        set.add(0);
        for (String s : br.readLine().split(" ")) {
            set.add(Integer.parseInt(s));
        }
        set.add(l);

        arr = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            arr[idx++] = num;
        }
    }
}