class Solution {
    static char[] word_list={'A', 'E', 'I', 'O', 'U'};
    static int count=0,answer=0;
    public int solution(String word) {
        DFS("",word);
        return answer;
    }
    public void DFS(String word,String target){
        if (word.equals(target)){
                answer=count;
                return;
            }
        if (word.length()>=5){
            return;
        }
        for (int i=0;i<word_list.length;i++){
            count++;
            String w=word+word_list[i];
            DFS(w,target);
        }
    }
}