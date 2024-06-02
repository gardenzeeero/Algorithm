import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int[] car1, int[] car2){
                return car1[1]-car2[1];
            }
        });
        
        int minRoute = -0x7fffffff;
        for(int[] temp : routes){
            if(minRoute < temp[0]){
                minRoute = temp[1];
                answer++;             }
        }
        
        
        return answer;
    }
}