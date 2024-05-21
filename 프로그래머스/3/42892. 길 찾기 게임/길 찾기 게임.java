import java.util.*;
class Solution {
    static class Node{
        int x,y,num;
        Node left,right;
        
        public Node(int x, int y,int num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
        
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        
        Node[] nodes=new Node[nodeinfo.length];
        int index=0;
        for(int[] n:nodeinfo){
            nodes[index]=new Node(n[0],n[1],index+1);
            index++;
        }
        
        //y값 내림차순 정렬
        Arrays.sort(nodes,(o1,o2)->{
            if(o1.y==o2.y) return Integer.compare(o1.x,o2.x);
            return Integer.compare(o2.y,o1.y);
        });
        
        Node root=nodes[0];
        for(int i=1;i<nodes.length;i++){
            Node parent=root;
            while(true){
                if(nodes[i].x<parent.x){//왼쪽 트리
                    if(parent.left==null){
                        parent.left=nodes[i];
                        break;
                    }else{
                        parent=parent.left;
                    }
                }else{
                    if(parent.right==null){
                        parent.right=nodes[i];
                        break;
                    }else{
                        parent=parent.right;
                    }
                }
            }
        }
        
        ArrayList<Integer> pre=new ArrayList<>();
        preOrder(root,pre);
        ArrayList<Integer> post=new ArrayList<>();
        postOrder(root,post);
        
        
        answer[0]=pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1]=post.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
    
    public static void preOrder(Node cur,ArrayList<Integer> result){
        if(cur==null) return;
        result.add(cur.num);
        preOrder(cur.left,result);
        preOrder(cur.right,result);
        
    }
    public static void postOrder(Node cur,ArrayList<Integer> result){
        if(cur==null) return;
        postOrder(cur.left,result);
        postOrder(cur.right,result);
        result.add(cur.num);
    }
}
