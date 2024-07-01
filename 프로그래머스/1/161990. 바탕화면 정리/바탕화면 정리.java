import java.util.*;
class Solution {
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    public int[] solution(String[] wallpaper) {

        int minx=min,miny=min,maxx=max,maxy=max;
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minx=Math.min(minx,i);
                    miny=Math.min(miny,j);
                    maxx=Math.max(maxx,i);
                    maxy=Math.max(maxy,j);
                }
            }
        }
        int[] answer=new int[] {minx,miny,maxx+1,maxy+1};
        return answer;
    }
}