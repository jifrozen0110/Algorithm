package 정렬;

import java.util.Arrays;

public class 버블정렬 {
	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

		Arrays.sort(arr);

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.print("D");
				return;
			}
		}

		System.out.print("U");
	}

}
