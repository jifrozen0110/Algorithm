import java.time.*;
import java.util.*;


class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/176962
    // 시간에 따라 정렬
    // 잠시 멈춘 과제 -> 스택 최근 과제부터
    static class Homework implements Comparable<Homework>{
        String name;
        int time;
        int workTime;
        public Homework(String name,int time,int workTime){
            this.name=name;
            this.time=time;
            this.workTime=workTime;
        }
        
        @Override
        public int compareTo(Homework other){
            return this.time-other.time;
        }
        public void modifyWorkTime(int t){
            this.workTime=this.workTime-t;
        }
        
    }
    public ArrayList<String> solution(String[][] plans) {
        ArrayList<String> answer=new ArrayList<String>();
                PriorityQueue<Homework> pq=new PriorityQueue<>();


        List<Homework> homeworks=new ArrayList<>();
        for(int i=0;i<plans.length;i++){
            String name=plans[i][0];
            String timeS=plans[i][1];
            int workTime=Integer.parseInt(plans[i][2]);
            int hour=Integer.parseInt(timeS.split(":")[0]);
            int min=Integer.parseInt(timeS.split(":")[1]);
            Homework homework=new Homework(name,hour*60+min,workTime);
            pq.add(homework);
        }
        
        Stack<Homework> stack=new Stack<>();

        
        while(!pq.isEmpty()){
            Homework hw=pq.poll();
            int currentTime=hw.time;
            int currentWork=hw.workTime;
            if(!pq.isEmpty()){
            // 현재 과제 다 끝내는 경우
                Homework nextHw=pq.peek();
                if(currentTime+currentWork<=nextHw.time){
                    answer.add(hw.name);
                    int remainTime=nextHw.time-(currentTime+currentWork);
                    while(remainTime>0&&!stack.isEmpty()){
                        Homework remainWork=stack.pop();

                        //스택에서 꺼낸 과제를 다 못끝낸 경우
                        if(remainWork.workTime>remainTime){
                            System.out.println(1);
                            remainWork.modifyWorkTime(remainTime);
                            remainTime=0;
                            stack.push(remainWork);
                        }else{
                            System.out.println(2);
                            remainTime=remainTime-remainWork.workTime;
                            answer.add(remainWork.name);
                        }
                    }
                    //과제를 못끝내는 경우
                }else{
                    hw.modifyWorkTime(nextHw.time-currentTime);
                    stack.push(hw);
                }
            }else{
                answer.add(hw.name);
            }
        }
        
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }
        
        
        
        return answer;
    }
}