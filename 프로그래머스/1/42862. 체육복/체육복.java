import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students=new int[n+2];
        int answer=n;
        
        Arrays.fill(students,1);
        students[0]=0;
        students[n+1]=0;
        
        for (int l:lost){
            students[l]-=1;
        }
        
        for (int r:reserve){
            students[r]+=1;
        }
        
        for (int i=1;i<=n;i++){
            if (students[i]==0){
                if (students[i-1]==2){
                    students[i-1]-=1;
                    students[i]=1;
                }else if(students[i+1]==2){
                    students[i+1]-=1;
                    students[i]=1;
                }
            }
            if (students[i]==0){
                answer-=1;
            }
        }
        
        
        return answer;
    }
}