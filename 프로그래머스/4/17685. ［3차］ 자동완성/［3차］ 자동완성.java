import java.util.*;

class Solution {
    
    class Node {
        char c; 
        int count = 1;
        ArrayList<Node> next = new ArrayList<>();
        
        public Node (char c) {
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            return ((Node)o).c == this.c;
        }
    }
    
    public int solution(String[] words) {
        
        Node root = new Node('a');
    
        for (int i=0; i<words.length; i++) {
            String now = words[i];
            Node nowNode = root;
            
            for (int j=0; j<now.length(); j++) {
                char nowChar = now.charAt(j);
                boolean exist = false;
                for (Node n : nowNode.next) {
                    if (n.c == nowChar) {
                        exist = true;
                        n.count++;
                        nowNode = n;
                        break;
                    }
                }
                
                if (!exist) {
                    Node newNode = new Node(nowChar);
                    nowNode.next.add(newNode);
                    nowNode = newNode;
                }
            }
        }
        
        int round = 0;
        for (int i=0; i<words.length; i++) {
            String now = words[i];
            Node nowNode = root;
            
            for (int j=0; j<now.length(); j++) {
                char nowChar = now.charAt(j);
                boolean isLast = false;
                
                for (Node n : nowNode.next) {
                    if (n.c == nowChar) {
                        if (n.count == 1) isLast = true;
                        nowNode = n;
                        break;
                    }
                }
                round++;
                if (isLast) break;
            }
        }
        

        return round;
    }
}