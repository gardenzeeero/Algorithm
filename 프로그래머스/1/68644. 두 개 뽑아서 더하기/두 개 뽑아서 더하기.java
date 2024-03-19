import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> temp = new HashSet<>();

        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                temp.add(numbers[i]+numbers[j]);
            }
        }

        List<Integer> listAnswer = new ArrayList(temp);
        int[] answer = new int[listAnswer.size()];
        for(int i=0; i<listAnswer.size(); i++){
            answer[i] = listAnswer.get(i).intValue();
        }

        Arrays.sort(answer);



        return answer;
    }
}