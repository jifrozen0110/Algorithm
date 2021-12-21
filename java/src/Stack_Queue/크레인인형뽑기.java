package Stack_Queue;
import java.util.*;
import java.io.*;

public class 크레인인형뽑기 {
	class Solution {
		public int solution(int[][] board, int[] moves) {
			int answer = 0;

			Stack<Integer> stack = new Stack<>();
			stack.push(0);

			for (int move : moves) {
				for (int j = 0; j < board.length; j++) {
					if (board[j][move - 1] != 0) {
						if (stack.peek() == board[j][move - 1]) {
							stack.pop();
							answer += 2;
						} else {
							stack.push(board[j][move - 1]);
						}
						board[j][move - 1] = 0;
						break;
					}
				}
			}
			return answer;
		}
	}
}
