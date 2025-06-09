import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int todayDay = nalzza(today);
        Map<String,Integer> termsMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(String term: terms) {
            String[] split = term.split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int data = nalzza(split[0]);
            data += termsMap.get(split[1]) * 28;
            if(todayDay >= data) {
                result.add(i+1);
            }
        }
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public int nalzza(String day) {
        String[] naday = day.split("\\.");
        int year = Integer.parseInt(naday[0]);
        int mon = Integer.parseInt(naday[1]);
        int il = Integer.parseInt(naday[2]);
        int total = (year*12*28) + ((mon-1) * 28) + il;
        return total;
    }
}