import java.util.*;
class Solution {
    static String[] dataCol={"code","date","maximum","remain"};
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        ArrayList<int[]> arr=new ArrayList<>();
        for(int[] d:data){
            for(int i=0;i<4;i++){
                if(!dataCol[i].equals(ext)){
                    continue;
                }
                if(d[i]>=val_ext){
                    break;
                }
                arr.add(d);
                break;
            }
        }
        
        for(int i=0;i<4;i++){
            if(dataCol[i].equals(sort_by)){
                int index=i;
                Collections.sort(arr, (a, b) -> a[index] - b[index]);
                break;
            }
        }
        int[][] answer = new int[arr.size()][4];
        for(int i=0;i<arr.size();i++){
            answer[i]=arr.get(i);
        }
        return answer;
    }
}