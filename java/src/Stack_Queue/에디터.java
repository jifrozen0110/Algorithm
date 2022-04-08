package Stack_Queue;

import java.io.*;
import java.util.Stack;

public class 에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();

		String[] arr = str.split("");
		for(String s : arr) { //Enhanced For Loop 사용
			leftSt.push(s);
		}

		for(int i = 0; i < M; i++) {
			String command = br.readLine();
			char c = command.charAt(0);

			switch(c) {
				case 'L':
					if(!leftSt.isEmpty())
						rightSt.push(leftSt.pop());

					break;
				case 'D':
					if(!rightSt.isEmpty())
						leftSt.push(rightSt.pop());

					break;
				case 'B':
					if(!leftSt.isEmpty()) {
						leftSt.pop();
					}
					break;
				case 'P':
					char t = command.charAt(2);
					leftSt.push(String.valueOf(t));
					break;
			}
		}

		//Stack은 LIFO 구조
		while(!leftSt.isEmpty())
			rightSt.push(leftSt.pop());

		while(!rightSt.isEmpty())
			bw.write(rightSt.pop());

		bw.flush();
		bw.close();
	}
}
