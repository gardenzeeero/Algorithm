//3시 20분 시작
import java.util.*;

class Solution {
    static int dayOfMonth = 28;
    static int todayYear;
    static int todayMonth;
    static int todayDay;
    
    static Map<String, Integer> term = new HashMap<>();
    
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todays = today.split("\\.");
        todayYear = Integer.parseInt(todays[0]);
        todayMonth = Integer.parseInt(todays[1]);
        todayDay = Integer.parseInt(todays[2]);
            
        for (int i=0; i<terms.length; i++) {
            String[] termSplit = terms[i].split(" ");
            term.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }
        
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<privacies.length; i++) {
            String[] pSplit = privacies[i].split(" ");
            String day = pSplit[0];
            Integer termDay = term.get(pSplit[1]);
            
            if (needDelete(day, termDay)) {
                result.add(i+1);
            }
        }
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private boolean needDelete(String dayString, int termMonth) {
        String[] daySplit = dayString.split("\\.");
        Integer year = Integer.parseInt(daySplit[0]);
        Integer month = Integer.parseInt(daySplit[1]);
        Integer day = Integer.parseInt(daySplit[2]);
        
        day -= 1;
        if (day == 0) {
            day = 28;
            if (month != 1) month -= 1;
            else {
                month = 12;
                year -= 1;
            }
        }
        
        month += termMonth;
        if (month > 12) {
            year += month / 12;
            month %= 12;
            if (month == 0) {
                year -= 1;
                month = 12;
            }
        }
        
        // System.out.println(year + " " + month + " " + day + " " + termMonth);
        
        boolean r=  checkExpired(year, month, day);
        // System.out.println(r);
        return r;
    }
    
    private boolean checkExpired(Integer year, Integer month, Integer day) {
        if (year < todayYear) return true;
        else if (year == todayYear) {
            if (month < todayMonth) return true;
            else if (month == todayMonth) {
                if (day < todayDay) return true;
            }
        }
        
        return false;
    }
}