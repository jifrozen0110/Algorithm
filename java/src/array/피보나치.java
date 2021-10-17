package array;
import java.util.*;

public class 피보나치 {
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr.add(1);
        arr.add(1);

        for (int i = 2; i < n; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 1));
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
        sc.close();
    }
}