class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int prev=0;

        int maxHealth=health;
        
        for(int[] attack:attacks){
            int diff=attack[0]-prev-1;
            
            if(health<=0){
                return -1;
            }
            int heal=diff*bandage[1]+(diff/bandage[0])*bandage[2];
            health=(health+heal)>maxHealth?maxHealth:(health+heal);
            health=health-attack[1];
            prev=attack[0];
        }
        
        if(health<=0){
            return -1;
        }
        
        return health;
    }
}