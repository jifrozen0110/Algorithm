package 다이나믹프로그래밍;

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], 151);
        }
        if(alp>maxAlp){
            alp=maxAlp;
        }
        if(cop>maxCop){
            cop=maxCop;
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                for (int[] problem : problems) {
                    //문제 풀기 가능
                    if(i >= problem[0] && j >= problem[1]){
                        if(i+problem[2]>=maxAlp&&j+problem[3]>=maxCop){
                            dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + problem[4]);
                        }
                        else if(i+problem[2]>=maxAlp){
                            dp[maxAlp][j + problem[3]]=Math.min(dp[maxAlp][j + problem[3]],dp[i][j]+problem[4]);
                        }else if(j+problem[3]>=maxCop){
                            dp[i+problem[2]][maxCop]=Math.min(dp[i+problem[2]][maxCop],dp[i][j]+problem[4]);
                        }
                        else {
                            dp[i+problem[2]][j + problem[3]] = Math.min(dp[i+problem[2]][j + problem[3]], dp[i][j] + problem[4]);
                        }
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}

