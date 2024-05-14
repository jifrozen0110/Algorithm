import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int[] up=new int[n+2];
        int[] down=new int[n+2];
        int[] delete=new int[n];

        for(int i=0;i<n+2;i++){
            up[i]=i-1;
            down[i]=i+1;
        }

        k+=1;

        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(String c:cmd){
            if(c.equals("C")){

                up[down[k]]=up[k];
                down[up[k]]=down[k];

                stack.addFirst(k);
                delete[k-1]=1;
                if(down[k]>n){
                    k=up[k];
                }
                else{k=down[k];}
            }else if(c.equals("Z")){
                int prevDelete=stack.removeFirst();

                up[down[prevDelete]]=prevDelete;
                down[up[prevDelete]]=prevDelete;


                delete[prevDelete-1]=0;
            }else{
                String[] temp=c.split(" ");
                int move=Integer.parseInt(temp[1]);
                if(temp[0].equals("U")){
                    while(move-->0){
                        k=up[k];
                    }
                }else if(temp[0].equals("D")){
                    while(move-->0){
                        k=down[k];
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            if(delete[i]==0){
                sb.append("O");
            }else{
                sb.append("X");
            }
        }
        return sb.toString();
    }
}

