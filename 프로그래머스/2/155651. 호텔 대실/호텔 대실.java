import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

class Solution {
    class Time implements Comparable<Time> {
        LocalTime startTime;
        LocalTime endTime;

        public Time(String startTime, String endTime) {
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm");
            this.startTime=LocalTime.parse(startTime,formatter);
            this.endTime=LocalTime.parse(endTime,formatter);
        }

        @Override
        public int compareTo(Time o) {
            return this.startTime.compareTo(o.startTime);

        }
    }

    public int solution(String[][] book_time) {
        PriorityQueue<Time> pq = new PriorityQueue<>();

        for (String[] t : book_time) {
            pq.add(new Time(t[0], t[1]));
        }

        PriorityQueue<LocalTime> room = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Time time = pq.poll();
            if (!room.isEmpty() && room.peek().plusMinutes(10).compareTo(time.startTime) <= 0) {
                room.poll();
            }
            room.add(time.endTime);
        }

        return room.size();
    }


}
