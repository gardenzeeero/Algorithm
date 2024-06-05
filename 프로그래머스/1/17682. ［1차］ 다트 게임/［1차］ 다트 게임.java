import java.util.regex.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String dartResult) {
        String check = "([0-9]+)([S|D|T])([*|#]*)";

        Pattern pat = Pattern.compile(check);
        Matcher match = pat.matcher(dartResult);
        
        int answer = 0;

        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<3; i++){
            match.find();
            
            int score = Integer.parseInt(match.group(1));
            
            String bonus = match.group(2);
            if(bonus.equals("D")) score *= score;
            else if(bonus.equals("T")) score *= (score * score);
            
            String prize = match.group(3);
            if(prize.equals("*")){
                if(!st.isEmpty()){
                    st.push(st.pop() * 2);
                }
                st.push(2 * score);
            }else if(prize.equals("#")){
                st.push(score * (-1));
            }else{
                st.push(score);
            }
        }
        
        while(!st.isEmpty()){
            answer += st.pop();
        }
        

        return answer;
       
    }
}
