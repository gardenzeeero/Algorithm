//22012163 정원영
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        
        int maxIdx = -1;
        while(k != 0 && answer.length() != number.length() - k){
            int boundary = maxIdx + k + 1;
            char maxChar = '0';
            int index = maxIdx+1;
            
            for(int i=maxIdx+1; i<=boundary; i++){
                if(number.charAt(i) > maxChar){
                    maxChar = number.charAt(i);   
                    maxIdx = i;
                }
                
            }
            k -= maxIdx - index;
            answer.append(maxChar);
        }
        
        if(k == 0){
            for(int i=maxIdx+1; i<number.length(); i++){
            answer.append(number.charAt(i));
        }
        }
        
        
        
        return answer.toString();
    }
}