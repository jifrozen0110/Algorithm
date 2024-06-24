import java.util.*;

class Solution {
    HashSet<String> set=new HashSet<>();
    static String[] talk={"aya", "ye", "woo", "ma"};
    static String[] twoTalk={"ayaaya", "yeye", "woowoo", "mama"};
    public int solution(String[] babbling) {
        int answer = 0;
        
        
        
        for(String b:babbling){
            if(check(b)){
                answer++;
            }
            
        }
        
        return answer;
    }
    public boolean check(String b){
        for(int i=0;i<4;i++){
                if(b.contains(twoTalk[i])){
                    return false;
                }
            }                   
                                      
            for(int j=0;j<4;j++){
                b=b.replace(talk[j]," ");
            }
                                      
            if(b.trim().isEmpty()){
                return true;
            }
        return false;
    }
    
}