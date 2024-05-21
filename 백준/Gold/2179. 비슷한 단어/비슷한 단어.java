
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int S=Integer.parseInt(br.readLine());

    ArrayList<String> arr=new ArrayList<>();
    while(S-->0){
      String s=br.readLine();
      if(!arr.contains(s)){
        arr.add(s);
      }
    }
    
    int max=0;
    int answer1=0,answer2=0;
    for(int i=0;i<arr.size()-1;i++) {
      String a=arr.get(i);
      for (int c = i + 1; c < arr.size(); c++) {
        String b=arr.get(c);
        int temp = 0;
        int index = Math.min(a.length(), b.length());

        for (int j = 0; j < index; j++) {
          if (a.charAt(j) == b.charAt(j)) {
            temp++;
          } else {
            break;
          }
        }

        if (temp > max) {
          answer1=i;
          answer2=c;
          max = temp;
        }
      }
    }

    System.out.println(arr.get(answer1));
    System.out.println(arr.get(answer2));



  }

}
