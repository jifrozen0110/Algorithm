import java.util.*;
class Solution {
    static HashMap<String,Integer> courses;
    class Course implements Comparable<Course>{
        String name;
        int count;
        
        Course(String name,int count){
            this.name=name;
            this.count=count;
        }
        
        @Override
        public int compareTo(Course o){
            if(this.count==o.count){
                return this.name.compareTo(o.name);
            }
            return o.count-this.count;
        }
    }
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer=new ArrayList<>();
        
        for(int c:course){
            ArrayList<Course> result=new ArrayList<>();
            courses=new HashMap<>();
            for(String order:orders){
                char[] ordera=order.toCharArray();
                Arrays.sort(ordera);
                DFS(c,0,ordera,"");
            }
            int max=0;
            for(String m:courses.keySet()){
                if(courses.get(m)>=2){
                    result.add(new Course(m,courses.get(m)));
                    max=Math.max(max,courses.get(m));
                }
            }
            
            if(result.size()==0){
                continue;
            }
            
            Collections.sort(result);
            
            for(int i=0;i<result.size();i++){
                if(max==result.get(i).count){
                    answer.add(result.get(i).name);
                }else{
                    break;
                }
            }
            
          
        }
        
        Collections.sort(answer);
        
        
        return answer.toArray(new String[0]);
    }
    public void DFS(int count,int index,char[] arr,String result){
        if(count==result.length()){
            courses.put(result,courses.getOrDefault(result,0)+1);
            return;
        }
        for(int i=index;i<arr.length;i++){
            DFS(count,i+1,arr,result+arr[i]);
        }
    }
}