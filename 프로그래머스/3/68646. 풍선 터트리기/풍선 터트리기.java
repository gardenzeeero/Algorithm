import java.util.*;
class Solution {
    public int solution(int[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 1; i<a.length; i++) minHeap.add(a[i]);
        PriorityQueue<Integer> ready = new PriorityQueue<>();
        
        int s= 0, smin=a[0];
        
        int ans = 1;
        while(s < a.length-2){
            s++;
            ready.add(a[s]);
             
            while(!ready.isEmpty()){
                if(minHeap.peek().equals(ready.peek())){
                    ready.poll();
                    minHeap.poll();
                }
                else break;
            }
            
                 
            
            if(smin > a[s]){ // 왼쪽이 더 큰 경우
                smin = a[s];
                ans++;
            }
            else if(a[s] < minHeap.peek()) ans++;
                
            //minHeap은 현재 기준 오른쪽의 가장 작은 값
            //readyHeap은 현재 기준 오른쪽에서 지우못한 가장 작은 값
        }
        
        if(a.length>1) ans++;
        return ans;
    }
}

// 양옆 모두 본인보다 작은 수가 있으면 불가능