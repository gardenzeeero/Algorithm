import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    
    boolean[][] isUsed;
    int row, col;
    int[][] pictureColor;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    //Math.max아닌가
    public int[] solution(int m, int n, int[][] picture) {
        init(m, n, picture);
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        while(true){
            Point findPoint = findNotUsed();
            if (findPoint.x == -1 || findPoint.y == -1) break;
            int sizeOfArea = BFS(findPoint);
            if (sizeOfArea > maxSizeOfOneArea) maxSizeOfOneArea = sizeOfArea;
            numberOfArea++;
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int BFS(Point startPoint) {
        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);
        isUsed[startPoint.x][startPoint.y] = true;
        
        int sizeOfArea = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i]; int ny = cur.y + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (isUsed[nx][ny]) continue;
                if (pictureColor[cur.x][cur.y] != pictureColor[nx][ny]) continue;
                sizeOfArea++;
                isUsed[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
        
        return sizeOfArea;
    }
    
    Point findNotUsed() {
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (!isUsed[i][j]) return new Point(i, j);
            }
        }
        
        return new Point(-1, -1);
    }
    
    void init(int m, int n, int[][] picture) {
        isUsed = new boolean[m][n];
        pictureColor = new int[m][n];
        row = m; col = n;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                pictureColor[i][j] = picture[i][j];
                if (pictureColor[i][j] == 0) isUsed[i][j] = true;
            }
        }
    }
}