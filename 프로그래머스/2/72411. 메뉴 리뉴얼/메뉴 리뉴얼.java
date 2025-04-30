import java.util.*;

class Solution {
    ArrayList<HashMap<String, Integer>> strings = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();
    int[] maxCount = new int[11];
    
    public String[] solution(String[] orders, int[] course) {
        String[] tempOrder = new String[orders.length];
        for(int i=0; i<orders.length; i++) {
            char[] tempChars = orders[i].toCharArray();
            Arrays.sort(tempChars);
            tempOrder[i] = new String(tempChars);
        }
    
        orders = tempOrder;
        for (int i=0; i<=10; i++) strings.add(new HashMap<>());
        for (int len : course) makeMap(orders, len);
        
        for (int i=2; i<=10; i++) {
            if(maxCount[i] == 0 || maxCount[i] == 1) continue;
            addAnswer(i);
        }
        
        Collections.sort(answer);
        String[] finalAnswer = new String[answer.size()];
        for (int i=0; i<answer.size(); i++) {
            finalAnswer[i] = answer.get(i);
        }
        
        return finalAnswer;
    }
    
    void addAnswer(int len) {
        HashMap<String, Integer> tempMap = strings.get(len);
        for(String key : tempMap.keySet()) {
            if (tempMap.get(key) == maxCount[len]) answer.add(key);
        }
        
    }
    
    void makeMap(String[] orders, int len) {
        for(String order : orders) {
            recursive(order, "", 0, len);
        }
    }
    
    void recursive(String order, String temp, int now, int len) {
        if (temp.length() == len) {
            HashMap<String, Integer> map = strings.get(len);
            int count = 1;
            if (map.containsKey(temp)) {
                count += map.get(temp);
            }
            map.put(temp, count);
            if (maxCount[len] < count) maxCount[len] = count;
        }
        
        
        for (int i=now; i<order.length(); i++) {
            recursive(order, temp + order.charAt(i), i+1, len);
        }
    }
}