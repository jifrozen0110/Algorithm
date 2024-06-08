import java.util.*;


class Solution {
    class Time implements Comparable<Time>{
        int startTime;
        int endTime;
        
        public Time(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        @Override
        public int compareTo(Time o){
            return this.startTime - o.startTime;
        }
    }
    
    public int solution(String[][] book_time) {
        PriorityQueue<Time> pq = new PriorityQueue<>();
        
        for(String[] t : book_time){
            String[] start = t[0].split(":");
            String[] end = t[1].split(":");
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            pq.add(new Time(startTime, endTime));
        }
        
        PriorityQueue<Integer> room = new PriorityQueue<>();
        
        while(!pq.isEmpty()){
            Time time = pq.poll();
            if(!room.isEmpty() && room.peek() <= time.startTime){
                room.poll();
            }
            
            room.add(time.endTime + 10);
        }
        
        return room.size();
    }
}
    