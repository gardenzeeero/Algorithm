import java.util.*;

class Solution {
    int gm, gn, sx, sy;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        gm = m; gn = n; sx = startX; sy = startY;
        
        int[] answer = new int[balls.length];
        
        for (int i=0; i<balls.length; i++) {
            answer[i] = calMinDist(sx, sy, balls[i][0], balls[i][1]);
        }
        
        return answer;
    }
    
    int calMinDist(int sx, int sy, int bx, int by) {
        int minDist = Integer.MAX_VALUE;
        if (!(sy == by && sx > bx)) minDist = Math.min(minDist, calDist(-sx, sy, bx, by));
        if (!(sx == bx && sy > by)) minDist = Math.min(minDist, calDist(sx, -sy, bx, by));
        if (!(sy == by && sx < bx)) minDist = Math.min(minDist, calDist(sx + 2 * (gm - sx), sy, bx, by));
        if (!(sx == bx && sy < by)) minDist = Math.min(minDist, calDist(sx, sy + 2 * (gn - sy), bx, by));
        
        return minDist;
    }
    
    int calDist(int sx, int sy, int bx, int by) {
        int dx = sx - bx;
        int dy = sy - by;
        return dx * dx + dy * dy;
    }
}