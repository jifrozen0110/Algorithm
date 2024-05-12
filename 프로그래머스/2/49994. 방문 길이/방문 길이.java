import java.util.*;
class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};
    static char[] dirArr={'U','D','R','L'};
    public int solution(String dirs) {
        int answer = 0;
        
        int startX=5;
        int startY=5;

        HashSet<String> set=new HashSet<>();
        
        for(char dir:dirs.toCharArray()){
            for(int c=0;c<4;c++){
                if(dir==dirArr[c]){
                    int nx=startX+dx[c];
                    int ny=startY+dy[c];
                    
                    if(nx<0||ny<0||nx>=11||ny>=11) continue;
                    
                    set.add(startX+" "+startY+" "+nx+" "+ny);
                    set.add(nx+" "+ny+" "+startX+" "+startY);
                    
                    startX=nx;
                    startY=ny;
                    
                }
            }
        }
        return set.size()/2;
    }
}