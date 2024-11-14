import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String trees : skill_trees) {
            ArrayList<Integer> result = new ArrayList<>();
            
            for(int i=0; i<skill.length(); i++) {
                result.add(trees.indexOf(skill.charAt(i)));
            }
            
            if(findResult(result) && checkMinus(result)) {
                answer++;
                System.out.println(trees);
            }
        
            
            result.clear();
        }
        return answer;
    }
    
    public boolean findResult(ArrayList<Integer> result) {
        for(int i=0; i<result.size() - 1; i++) {
            if(result.get(i) > result.get(i+1)) {
                if(result.get(i+1) == -1) continue;
                return false;
            }
        }
        return true;
    }
    
    public boolean checkMinus(ArrayList<Integer> result) {
        boolean flag = false;
        for(int i=0; i<result.size(); i++) {
            if(result.get(i) == -1) flag = true;
            if(flag && result.get(i) != -1) return false;
        }
        
        return true;
    }
}