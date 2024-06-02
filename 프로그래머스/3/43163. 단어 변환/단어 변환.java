class Solution {
    static int answer=0;
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited=new boolean[words.length];
        DFS(begin,target,words,visited,0);
        
        if(answer==0){
            return 0;
        }
        return answer;
    }
    
    public void DFS(String begin,String target, String[] words,boolean[] visited,int count){
        if(begin.equals(target)){
            answer=count;
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if(!visited[i]&&isSameNonOne(begin,words[i])){
                visited[i]=true;
                DFS(words[i],target,words,visited,count+1);  
                visited[i]=false;
        }
    }
    }
    public boolean isSameNonOne(String begin,String target){
        int notSameCount=0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i)!=target.charAt(i)){
                notSameCount++;
            }
        }
        return notSameCount==1;
    }
}