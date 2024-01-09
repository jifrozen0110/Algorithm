import java.util.*;

class Solution {
    static double[] nextX={0.5,0,-0.5,0};
    static double[] nextY={0,0.5,0,-0.5};
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static char[] directions={'U','R','D','L'};
    public int solution(String dirs) {
        int answer = 0;
        
        HashMap<String,Integer> hashMap=new HashMap<>();
        
        int[][] map=new int[11][11];
        
        int startX=5,startY=5;
        
        for(char c:dirs.toCharArray()){
            for(int i=0;i<4;i++){
                if(directions[i]==c){
                    int nx=startX+dx[i];
                    int ny=startY+dy[i];
                    if(nx<0||ny<0||nx>=11||ny>=11) continue;
                    if(!hashMap.containsKey((startX+nextX[i])+","+(startY+nextY[i]))){
                        answer++;
                        hashMap.put((startX+nextX[i])+","+(startY+nextY[i]),1);
                    }
                    startX=nx;
                    startY=ny;
                }
            }
        }
        
        return answer;
    }
}