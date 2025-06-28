import java.util.*;

class Solution {
    List<Long> longBans = new ArrayList<>();
    
    public String solution(long n, String[] bans) {
        for (int i=0; i<bans.length; i++) {
            longBans.add(charToLong(bans[i]));
        }   
        
        Collections.sort(longBans);

        for (long ban : longBans) {
            if (ban <= n) n++;
        }
        
        String answer = longToChar(n);
        
        return answer;
    }
    
    Long charToLong(String str) {
        long sum = 0;
        int jari = 0;
        for (int i=str.length()-1; i>=0; i--) {
            char c = str.charAt(i);
            sum += Math.pow(26, jari) * (c - 'a' + 1);
            jari++;
        }
        
        return sum;
    }
    
    String longToChar(long num) {
        String answer = "";
        
        while (num > 0) {
            long remainder = num%26;
            if (remainder == 0) {
                answer = String.valueOf('z') + answer;
                num = num/26 -1 ;
            } else {
                answer = String.valueOf((char) (num%26 + 'a' - 1)) + answer;
                num = num/26;
            }
            
        }
            
        return answer;
    }
}