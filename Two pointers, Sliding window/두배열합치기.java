import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 두배열합치기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[m];
        for (int j = 0; j < m; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }
        int p1 = 0, p2 = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (p1 < n && p2 < m) {
            if (A[p1] < B[p2])
                answer.add(A[p1++]);
            else
                answer.add(B[p2++]);
        }
        while (p1 < n)
            answer.add(A[p1++]);
        while (p2 < m)
            answer.add(B[p2++]);

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i + " ");
        }
        System.out.print(sb);

    }

}
