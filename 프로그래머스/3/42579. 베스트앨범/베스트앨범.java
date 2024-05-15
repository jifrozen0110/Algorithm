import java.util.*;
class Solution {
    class Album implements Comparable<Album>{
        int number;
        int count;
        
        Album(int number,int count){
            this.number=number;
            this.count=count;
        }
        
        @Override
        public int compareTo(Album other){
            if(this.count==other.count){
                return this.number-other.number;
            }
            return other.count-this.count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer=new ArrayList<>();
        
        HashMap<String,Integer> genre=new HashMap<>();
        HashMap<String,ArrayList<Album>> albums=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            genre.put(genres[i],genre.getOrDefault(genres[i],0)+plays[i]);
            if(!albums.containsKey(genres[i])){
                albums.put(genres[i],new ArrayList<Album>());
            }
            albums.get(genres[i]).add(new Album(i,plays[i]));
        }
        
        String[] sortedGenre=genre.entrySet().stream().sorted((o1,o2)->Integer.compare(o2.getValue(),o1.getValue())).map(Map.Entry::getKey).toArray(String[]::new);
        
        for(String g:sortedGenre){
            ArrayList<Album> temp=albums.get(g);
            if(temp.size()<2){
                answer.add(temp.get(0).number);
                continue;
            }
            Collections.sort(temp);
            for(int i=0;i<2;i++){
                answer.add(temp.get(i).number);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}