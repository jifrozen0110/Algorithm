class Solution {
    static int[] dx={-1,0,1,0,-1,-1,1,1,-2,0,2,0};
    static int[] dy={0,1,0,-1,-1,1,1,-1,0,2,0,-2};
    
    static int[] nx={1,0,-1,0};
    static int[] ny={0,-1,0,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++){
            String[] place=places[i];
            boolean isDistance=true;
            for(int a=0;a<5;a++){
                String line=place[a];
                for(int b=0;b<5;b++){
                    if(line.charAt(b)=='P'){
                        if(!isSafe(a,b,place)){
                            isDistance=false;
                            break;
                        }
                    }
                }
                if(!isDistance){
                   break; 
                }
            }
            if(isDistance){
                answer[i]=1;
            }
            
        }
        return answer;
    }
    public boolean isSafe(int a,int b,String[] place){
        boolean isBarrier=true;
        for(int i=0;i<10;i++){
            int nextX=a+dx[i];
            int nextY=b+dy[i];
            if(nextX<0||nextY<0||nextX>=5||nextY>=5){
                continue;
            }
            if(place[nextX].charAt(nextY)=='P'){
                if(i<6){
                    if(dx[i]==0||dy[i]==0){
                    return false;
                    }
                    if(place[nextX].charAt(b)=='X'&&place[a].charAt(nextY)=='X'){
                        continue;
                    }else{
                        return false;
                    }
                }else{
                    int tempA=a+nx[i-6];
                    int tempB=b+ny[i-6];
                    if(tempA<0||tempB<0||tempA>=5||tempB>=5){
                    continue;
                    }
                    if(place[tempA].charAt(tempB)!='X'){
                        return false;
                    }
                }
                
            }
            if(place[nextX].charAt(nextY)=='X'){
                continue;
            }
        }
        return true;
    }
}