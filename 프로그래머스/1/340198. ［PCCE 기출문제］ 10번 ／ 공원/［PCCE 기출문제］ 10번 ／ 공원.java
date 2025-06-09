import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int n = park.length;
        int m = park[0].length;
        boolean dos = true;
        
        Arrays.sort(mats);
        for(int k = mats.length-1; k>=0; k--) {
            for(int i=0; i<=n-mats[k]; i++) {
                for(int j=0; j<=m-mats[k]; j++) {
                    dos = true;
                    for(int ii=i; ii<i+mats[k]; ii++) {
                        for(int jj=j; jj<j+mats[k]; jj++) {
                            if(!park[ii][jj].equals("-1")) {
                                dos = false;
                                break;
                            }
                        }
                        if(!dos) break;
                    }
                    if(dos) {
                        return mats[k];
                    }
                }
            }
        }
        
        return -1;
    }
}