import java.util.*;

class Solution {
    
    ArrayList<Integer> answer;
    int gIdx = 1;
    Node root;
    
    class Node {
        char c;
        int idx;
        Node[] next = new Node[27];
        
        public Node(char c, int idx) {
            this.c = c; this.idx = idx;
        }
    }
    
    public int[] solution(String msg) {
        init();
        
        
        for (int i=0; i<msg.length(); i++) {
            i += find(i, msg);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    int find(int stIdx, String msg) {
        Node cur = root;
        
        int height = -1;
        
        for (int i=stIdx; i < msg.length(); i++) {
            char findChar = msg.charAt(i);
            if (cur.next[findChar-'A'+1] == null) {
                cur.next[findChar-'A'+1] = new Node(findChar, gIdx++);
                break;
            }
            cur = cur.next[findChar - 'A' + 1];
            height++;
        }
        
        answer.add(cur.idx);
        return height;
    }
    
    void init() {
        root = new Node('A', 0);
        for (int i=1; i<=26; i++) {
            root.next[i] = new Node((char)('A'+i-1), gIdx++);
        }
        answer = new ArrayList<>();
    }
}