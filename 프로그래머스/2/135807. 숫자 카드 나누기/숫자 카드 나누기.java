import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA=arrayA[0];
        int gcdB=arrayB[0];
        
        for(int i=0;i<arrayA.length;i++){
            gcdA=gcd(gcdA,arrayA[i]);
            gcdB=gcd(gcdB,arrayB[i]);
        }
        
        if(notDivisible(arrayA,gcdB)){
            if(answer<gcdB){
                answer=gcdB;
            }
        }
        
        if(notDivisible(arrayB,gcdA)){
            if(answer<gcdA){
                answer=gcdA;
            }
        }
        return answer;
    }
    public int gcd(int a,int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
    public boolean notDivisible(int[] targets, int num){
        for(int target:targets){
            if(target%num==0){
                return false;
            }
        }
        return true;
    }
}