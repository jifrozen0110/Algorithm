class Solution {
    // d l r u
    static int limit=0;
    static int row,col,startx,starty,endx,endy;
    static char[] direction={'d','l','r','u'};
    static int[] dx={1,0,0,-1};
    static int[] dy={0,-1,1,0};
    static String answer=null;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        limit=k;
        row=n; col=m; startx=x; starty=y; endx=r; endy=c;
        
        int length=distance(startx,starty,endx,endy);
        
        if((length>k)||(k-length)%2==1) return "impossible";
        char[] temp=new char[k];
        DFS(temp,0,startx,starty);
        
        return answer==null?"impossible":answer;
    }
    public static int distance(int startX,int startY,int endX,int endY){
        return Math.abs(startX-endX)+Math.abs(startY-endY);
    }
    public static void DFS(char[] result,int index,int startX,int startY){
        if(answer!=null) return;
        if(distance(startX,startY,endx,endy)+index>limit) return;
        if(index==limit){
            String resultStr=new String(result);
            answer=resultStr;
            return;
        }
        for(int i=0;i<4;i++){
            int nx=startX+dx[i];
            int ny=startY+dy[i];
            if(nx>=1&&ny>=1&&nx<=row&&ny<=col){
                result[index]=direction[i];
                DFS(result,index+1,nx,ny);
            }
        }
        
    }
}