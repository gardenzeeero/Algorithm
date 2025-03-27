import java.util.*;

class Solution {
    int infoLen, sn, sm;
    int result = Integer.MAX_VALUE;
    int[][] info;
    
    class TotalSum {
        int asum=0, bsum=0;
        
        public TotalSum(int asum, int bsum) {
            this.asum = asum; this.bsum = bsum;
        }
        
        @Override
        public boolean equals(Object t) {
            TotalSum tt = (TotalSum) t;
            return this.asum == tt.asum && this.bsum == tt.bsum;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(asum, bsum);
        }
    }
    
    public int solution(int[][] info, int n, int m) {
        init(info, n, m);
        
        Set<TotalSum> ts = new HashSet<>();
        ts.add(new TotalSum(0, 0));
        
        for (int i=0; i<infoLen; i++) {
            Set<TotalSum> tempTs = new HashSet<>();
            for (TotalSum t : ts) {
                if (t.asum + info[i][0] < n) tempTs.add(new TotalSum(t.asum + info[i][0], t.bsum));
                if (t.bsum + info[i][1] < m) tempTs.add(new TotalSum(t.asum, t.bsum + info[i][1]));
            }
            ts = tempTs;
        }
        
        for (TotalSum t : ts) {
            result = Math.min(result, t.asum);
        }
    
        if (result == Integer.MAX_VALUE) result = -1;
        
        return result;
    }
    
//     void recursive(int idx, int asum, int bsum) {
//         if (idx == infoLen) {
//             result = Math.min(result, asum);
//             return;
//         }
        
//         if (info[idx][1] + bsum < sm) {
//             recursive(idx+1, asum, bsum + info[idx][1]);
//         }
        
//         if (info[idx][0] + asum < sn && info[idx][0] + asum < result) {
//             recursive(idx+1, asum + info[idx][0], bsum);
//         }
//     }
        
    void init(int[][] info, int n, int m) {
        this.info = info;
        sn = n; sm = m;
        infoLen = info.length;
    }
}