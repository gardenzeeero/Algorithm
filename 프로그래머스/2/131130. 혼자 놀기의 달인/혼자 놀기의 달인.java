import java.util.*;

class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    int[] gcards;
    boolean[] visited = new boolean[100];
    
    public int solution(int[] cards) {
        gcards = Arrays.copyOf(cards, cards.length);
        
        for(int i=0; i<cards.length; i++){
            find(i, 0);
        }
        
        Collections.sort(result, Collections.reverseOrder());
        
    
        if(result.size() >= 2) {
            return result.get(0) * result.get(1);
        }
        return 0;
    }
    
    public void find(int idx, int count) {
        if(visited[idx]) {
            if(count != 0) result.add(count);
            return;
        }
        visited[idx] = true;
        find(gcards[idx]-1, count+1);
    }
}