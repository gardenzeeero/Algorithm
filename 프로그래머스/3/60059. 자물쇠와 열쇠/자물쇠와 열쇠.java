class Solution {
    int keySize, lockSize;
    public boolean solution(int[][] key, int[][] lock) {
        keySize = key.length;
        lockSize = lock.length;
        
        for (int i=0; i<4; i++) {
            key = turnKey(key);
            for (int j=-lockSize; j<=lockSize; j++) {
                for (int k=-lockSize; k<=lockSize; k++) {
                    if (compare(key, lock, j, k)) return true;
                }
            }
        }
        
        return false;
    }
    
    int[][] turnKey(int[][] key) {
        int[][] newKey = new int[keySize][keySize];
        
        for (int i=0; i<keySize; i++) {
            for (int j=0; j<keySize; j++) {
                newKey[j][keySize-i-1] = key[i][j];
            }
        }
        
        return newKey;
    }
    
    boolean compare(int[][] key, int[][] lock, int toBottom, int toRight) {
        for (int i=0; i<lockSize; i++) {
            for (int j=0; j<lockSize; j++) {
                int keyX = i + toBottom;
                int keyY = j + toRight;
                if (keyX < 0 || keyX >= keySize || keyY < 0 || keyY >= keySize) {
                    if (lock[i][j] == 0) return false;
                    else continue;
                }
                if (lock[i][j] == key[keyX][keyY]) return false;
            }
        }
        return true;
    }
    
    
}