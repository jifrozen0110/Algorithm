import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;
        
        for(int i=1;i<relation[0].length;i++){
            DFS(0,i,0,relation[0].length,new ArrayList<Integer>(),new StringBuilder(),relation);
        }
        
        if(list.size()==0){
            return 1;
        }
        
        return list.size();
    }
    public boolean check(ArrayList<Integer> arr,String[][] relation){
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<relation.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<relation[0].length;j++){
                if(arr.contains(j)){
                    sb.append(relation[i][j]);
                }
            }
            if(set.contains(sb.toString())){
                return false;
            }
            set.add(sb.toString());
        }
        return true;
    }
    public boolean containList(ArrayList<Integer> arr){
        for(ArrayList<Integer> temp:list){
                if(arr.containsAll(temp)){
                    return false;
                }
            }
        return true;
    }
    public void DFS(int count, int limit,int index,int total,ArrayList<Integer> arr,StringBuilder sb,String[][] relation){
        if(count==limit){
            if(containList(arr)&&check(arr,relation)){
                list.add(new ArrayList<>(arr));
            }
            return;
        }
        for(int i=index;i<total;i++){
            arr.add(i);
            sb.append(i);
            DFS(count+1,limit,i+1,total,arr,sb,relation);
            sb.delete(count,count+1);
            arr.remove(count);

            }
        }
        
    }
    
