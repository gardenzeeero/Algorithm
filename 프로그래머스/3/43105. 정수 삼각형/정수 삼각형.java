class Solution {
    public int solution(int[][] triangle) {
        int answer = 0, left, right;
        
        int lastLine = triangle.length - 1;
        
        if(lastLine == 0) return triangle[0][0];
        
        for(int i=1; i<=lastLine; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        for(int i=0; i<triangle[lastLine].length; i++){
            answer = Math.max(triangle[lastLine][i], answer);
        }
        
        return answer;
    }
}