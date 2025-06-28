import java.util.*;

class Solution {
    int n;
    
    public int solution(int coin, int[] cards) {
        int answer = 1;
        n = cards.length;
        
        HashSet<Integer> mine = new HashSet<>();
        HashSet<Integer> store = new HashSet<>();
        
        
        int i=0;
        for (i=0; i<n/3; i++) {
            mine.add(cards[i]);
        }
        
        while (true) {
            boolean pass = false;
            if (i >= n) break;
            
            store.add(cards[i++]);
            store.add(cards[i++]);
            
            for(Integer card : mine) {
                if (mine.contains(n - card + 1)) {
                    mine.remove(n - card + 1);
                    mine.remove(card);
                    pass = true;
                    break;
                }
            }
            
            if (!pass && coin>0) {
                for(Integer card : mine) {
                    if (store.contains(n - card + 1)) {
                        store.remove(n - card + 1);
                        mine.remove(card);
                        pass = true;
                        coin--;
                        break;
                    }
                }
            }
            
            if (!pass && coin>1) {
                for(Integer card : store) {
                    if (store.contains(n - card + 1)) {
                        store.remove(n - card + 1);
                        store.remove(card);
                        pass = true;
                        coin -= 2;
                        break;
                    }
                }
            }
            
            
            if (!pass) break;
            
            answer++;
        }
        return answer;
    }
}