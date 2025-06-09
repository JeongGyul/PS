import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        
        for(int w: works) {
            arr.offer(w);
        }
        
        for(int i=0; i<n; i++) {
            if(arr.peek() == 0) {
                break;
            }
           int max = arr.poll();
            arr.offer(max - 1);
        }
        
        while(!arr.isEmpty()) {
            int sum = arr.poll();
            answer += (long) sum * sum;
        }
        return answer;
    }
}