import java.util.*;
class Solution {
    int[] one={1,2,3,4,5};
    int[] two={2,1,2,3,2,4,2,5};
    int[] three={3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        int one_collect=0,two_collect=0,three_collect=0;
        for (int i=0;i<answers.length;i++){
            if (one[i%one.length]==answers[i]){
                one_collect++;
            }
            if (two[i%two.length]==answers[i]){
                two_collect++;
            }
            if (three[i%three.length]==answers[i]){
                three_collect++;
            }
        }
        
        ArrayList<Integer> temp=new ArrayList<>();
        
        int max_value=Math.max(one_collect,Math.max(two_collect,three_collect));
        
        if (max_value==one_collect){
            temp.add(1);
        }
        if (max_value==two_collect){
            temp.add(2);
        }
        if (max_value==three_collect){
            temp.add(3);
        }
        
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}