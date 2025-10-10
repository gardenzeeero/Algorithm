//4시 20분 시작

/*
가면서 제일 끝에다 내리면 됨
돌아올때 그냥 계속 들고오면 됨 -> 근데 수거할게 더 많으면?
deliveries든 pickups 든 가면서 제일 끝집에서 부터 빼면 됨
그게 이동 횟수
*/

class Solution {
    int gcap, gn;
    int dLast, pLast;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        gcap = cap;
        gn = n;
        
        dLast = getLast(deliveries, n-1);
        pLast = getLast(pickups, n-1);
        
        long answer = 0;
        while (dLast != -1 || pLast != -1) {
            answer +=  (Math.max(dLast, pLast) + 1) * 2;
            update(deliveries, dLast);
            update(pickups, pLast);    
            
            dLast = getLast(deliveries, dLast);
            pLast = getLast(pickups, pLast);
        }
        
        return answer;
    }
    
    public int getLast(int[] arr, int last) {
        for (int i=last; i>=0; i--) {
            if (arr[i] != 0) return i;
        }
        
        return -1;
    }
    
    public void update(int[] arr, int last) {
        if (last == -1) return;
        
        int leftCount = gcap;
        for (int i=last; i>=0; i--) {
            if (arr[i] >= leftCount) {
                arr[i] -= leftCount;
                break;
            } else {
                leftCount -= arr[i];
                arr[i] = 0;
            }
        }
    }
}