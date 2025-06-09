import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> fMap = new HashMap<>();
        for(int i=0; i<friends.length; i++) {
            fMap.put(friends[i],i);
        }
        
        int len = friends.length;
        int[][] gift = new int[len][len];
        for(String gi:gifts) {
            String[] who = gi.split(" ");
            int a = fMap.get(who[0]);
            int b = fMap.get(who[1]);
            gift[a][b] += 1;
        }
        
        int[] score = new int[len];
        for(int i=0; i<len; i++) {
            int give = 0;
            int take = 0;
            for(int j=0; j<len; j++) {
                give += gift[i][j];
                take += gift[j][i];
            }
            score[i] = give - take;
        }
        
        int[] nextM = new int[len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i==j) continue;
                if(gift[i][j]>gift[j][i]) {
                    nextM[i] += 1;
                }
                else if(gift[i][j] == gift[j][i]) {
                    if(score[i] > score[j])
                        nextM[i] += 1;
                }
            }
        }
        for(int num: nextM) {
            if(num>answer)
                answer=num;
        }
        
        return answer;
    }
}