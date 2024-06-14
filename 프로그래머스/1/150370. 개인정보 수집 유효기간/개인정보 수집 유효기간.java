import java.time.*;
import java.time.format.*;
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer=new ArrayList<>();
        
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate now=LocalDate.parse(today,formatter);
        
        HashMap<String,Integer> termMap=new HashMap<>();

        int index=1;
        for(String term:terms){
            String[] termArr=term.split(" ");
            termMap.put(termArr[0],Integer.parseInt(termArr[1]));

        }
        
        
        for(String privacy:privacies){
            String[] pArr=privacy.split(" ");

            String date=pArr[0];
            String person=pArr[1];
            
            
            LocalDate expiredPrivacyDate=LocalDate.parse(date,formatter)
                .plusMonths(termMap.get(person));

            if(now.isEqual(expiredPrivacyDate)||now.isAfter(expiredPrivacyDate)){
                answer.add(index);
            }
            index++;
            
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}