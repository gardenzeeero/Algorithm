import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> stringSet = new HashSet<String>();
        
        for(String temp : phone_book){stringSet.add(temp);}
        
        for(String temp : phone_book){
            for(int i=1; i<temp.length(); i++){
                if(stringSet.contains(temp.substring(0,i))) return false;
            }
        }
       
        return true;
    }
}