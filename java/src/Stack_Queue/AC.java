package Stack_Queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class AC {
	static StringBuilder sb=new StringBuilder();

	static ArrayDeque<Integer> dq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), "[],");

			dq = new ArrayDeque<Integer>();

			for (int i = 0; i < n; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			check(command);

		}

		System.out.println(sb);
	}
	public static void check(String command){
		boolean isRverse=false;
		for(char c:command.toCharArray()){
			if(c=='R'){
				isRverse=!isRverse;
			}else {
				if (isRverse) {
					if (dq.isEmpty()) {
						sb.append("error").append("\n");
						return;
					}
					dq.pollLast();
				} else {
					if (dq.isEmpty()) {
						sb.append("error").append("\n");
						return;
					}
					dq.pollFirst();
				}
			}
		}
		Cprint(isRverse);
	}

	private static void Cprint(boolean isRverse) {
		sb.append("[");
		if(dq.size()>0) {
			if (isRverse) {
				sb.append(dq.pollLast());
				while (!dq.isEmpty()) {
					sb.append(",").append(dq.pollLast());
				}
			} else {
				sb.append(dq.pollFirst());
				while (!dq.isEmpty()) {
					sb.append(",").append(dq.pollFirst());
				}
			}
		}
		sb.append("]").append("\n");
	}

}
