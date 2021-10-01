import java.util.*;

public class 뒤집은소수 {
    public static boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(new StringBuilder(sc.next()).reverse().toString());
            if (isPrime(arr[i])) {
                answer.add(arr[i]);
            }
            /*
             * arr[i]=sc.nextInt(); int tmp=arr[i]; int res=0; while(tmp>0){ int t=tmp%10;
             * res=res*10+t; tmp=tmp/10; }
             */
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
        sc.close();

    }
}