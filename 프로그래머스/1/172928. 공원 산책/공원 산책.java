class Solution {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static char[] move={'N','S','W','E'};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int startX=0,startY=0;
        
        int row=park.length;
        int col=park[0].length();
        char[][] map=new char[park.length][park[0].length()];
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                map[i][j]=park[i].charAt(j);
                if(map[i][j]=='S'){
                    startX=i;
                    startY=j;
                }
            }
        }
        
        for(String route:routes){
            char dir=route.charAt(0);
            int speed=route.charAt(2)-'0';
            int nx=startX;
            int ny=startY;
            for(int d=0;d<4;d++){
                if(move[d]==dir){
                    for(int s=0;s<speed;s++){
                        nx=nx+dx[d];
                        ny=ny+dy[d];

                        if(nx>=row||ny>=col||nx<0||ny<0){
                            nx=startX;
                            ny=startY;
                            break;
                        }
                        if(map[nx][ny]=='X'){
                            nx=startX;
                            ny=startY;
                            break;
                        }
                    }
                }
                
            }
            startX=nx;
            startY=ny;
        
            
        }
        answer[0]=startX;
        answer[1]=startY;
        return answer;
    }
}