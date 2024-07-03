import java.util.*;
import java.time.*;
import java.time.format.*;
class Solution {
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime=0;
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm");
        
        m=convertMusic(m);
        for(String musicinfo:musicinfos){
            String[] info=musicinfo.split(",");
            LocalTime start=LocalTime.parse(info[0],formatter);
            LocalTime end=LocalTime.parse(info[1],formatter);
            
            int playTime=(int)Duration.between(start,end).toMinutes();
            
            String music=convertMusic(info[3]);
            StringBuilder musicBuilder=new StringBuilder();
            if(music.length()>=playTime){
                musicBuilder.append(music.substring(0,playTime));
            }else{
                for(int i=0;i<playTime;i++){
                    musicBuilder.append(music.charAt(i%music.length()));
                }
            }
            
            music=musicBuilder.toString();
            
            if(music.contains(m)&&maxPlayTime<playTime){
                answer=info[2];
                maxPlayTime=playTime;
            }
        }
        
        if(maxPlayTime==0){
            return "(None)";
        }
        
        
        return answer;
    }
    public String convertMusic(String m){
        return m.replaceAll("C#","c")
                .replaceAll("D#","d")
                .replaceAll("F#","f")
                .replaceAll("G#","g")
                .replaceAll("A#","a")
                .replaceAll("B#","b");
    }
}