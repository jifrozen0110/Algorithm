import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int total=nums.length/2;
        HashSet<Integer> set=Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        
        int setSize=set.size();
        
        return Math.min(total,setSize);
    }
}