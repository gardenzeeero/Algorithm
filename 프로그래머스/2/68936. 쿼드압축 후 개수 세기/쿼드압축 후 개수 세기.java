//22012163 정원영

class Solution {
    int[][] gArr;
    int[] answer = {0, 0};
    
    public void recursive(int sx, int sy, int len){
        if(check(sx, sy, len)){
            answer[gArr[sx][sy]]++;
        }else{
            recursive(sx, sy, len/2);
            recursive(sx, sy+len/2, len/2);
            recursive(sx+len/2, sy, len/2);
            recursive(sx+len/2, sy+len/2, len/2);
        }
    }
    
    public boolean check(int sx, int sy, int len){
        int temp = gArr[sx][sy];
        for(int i=sx; i<sx + len; i++){
            for(int j=sy; j< sy + len; j++){
                if(temp != gArr[i][j]) return false;
            }
        }
        return true;
    }
    
    public int[] solution(int[][] arr) {
        gArr = arr;
        
        recursive(0, 0, gArr[0].length);
        return answer;
    }
}