class Solution {
    static int total=0;
    static int[] answer;
    static int[] apeach=new int[11];
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        for(int i=0;i<11;i++){
            apeach[i]=info[i];
        }
        
        int[] score=new int[11];
        
        DFS(0,n,score);
        if(total==0){
            return new int[]{-1};
        }
        return answer;
    }
    public void DFS(int idx,int count,int[] score){
        if(count==0){
            calcScore(score);
            return;
        }
        for(int i=idx;i<=10;i++){
            int cnt=Math.min(count,apeach[i]+1);
            score[i]=cnt;
            DFS(idx+1,count-cnt,score);
            score[i]=0;
        }
    }
    public void calcScore(int[] ryan){
        int a=0,b=0;
        for(int i=0;i<11;i++){
            if(apeach[i]+ryan[i]>0){
                if(apeach[i]<ryan[i]){
                    b+=(10-i);
                }else{
                    a+=(10-i);
                }
            }
        }
        if((b-a)>total){
            total=(b-a);

            answer=ryan.clone();

        }else if(total>0&&(b-a)==total){
            for(int i=10;i>=0;i--){
                if(answer[i]!=ryan[i]){
                    if(ryan[i]>answer[i]){
                        answer=ryan.clone();
                    }
                    break;
                }
            }
        }
        
    }
}