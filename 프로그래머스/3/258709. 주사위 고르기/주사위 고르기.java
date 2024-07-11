import java.util.*;
class Solution {
    
    static int[] A;
    static int max = Integer.MIN_VALUE;
    static int[] answer;
    public int[] solution(int[][] dice) {
        answer = new int[dice.length / 2];
        A = new int[dice.length / 2];

        // 주사위를 나눠가지는 DFS
        DFS(dice.length, 0, 0, new boolean[dice.length], dice);

        return answer;
    }

    public void DFS(int size, int index, int depth, boolean[] visited, int[][] dice) {
        if (index == size / 2) {
            int compareNum = fight(dice);
            if (max < compareNum) {
                max = compareNum;
                for (int i = 0; i < A.length; i++) {
                    answer[i] = A[i]+1;
                }
            }
            return;
        }

        for (int i = depth; i < size; i++) {
            if (!visited[i]) {
                A[index] = i;
                visited[i] = true;
                DFS(size, index + 1, i + 1, visited, dice);
                visited[i] = false;
            }
        }
    }

    public int fight(int[][] dice) {
        int indexA = 0;
        int indexB = 0;
        int[][] diceA = new int[dice.length / 2][6];
        int[][] diceB = new int[dice.length / 2][6];

        for (int i = 0; i < dice.length; i++) {
            if (indexA < diceA.length && A[indexA] == i) {
                diceA[indexA++] = dice[i];
            } else {
                diceB[indexB++] = dice[i];
            }
        }

        return compare(diceA, diceB);
    }

    public int compare(int[][] diceA, int[][] diceB) {
        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();

        makeArr(0, arrA, diceA, 0);
        makeArr(0, arrB, diceB, 0);

        Collections.sort(arrB);
        int count = 0;
        for (int i = 0; i < arrA.size(); i++) {
            int number = arrA.get(i);
            int left = 0;
            int right = arrB.size() - 1;
            int index = -1;

            while (left <= right) {
                int middle = (left + right) / 2;
                if (arrB.get(middle) < number) {
                    left = middle + 1;
                    index = Math.max(index, middle);
                } else {
                    right = middle - 1;
                }
            }

            if (index != -1) {
                count += index + 1;
            }
        }
        return count;
    }

    public void makeArr(int depth, ArrayList<Integer> arr, int[][] diceA, int sum) {
        if (depth == diceA.length) {
            arr.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            makeArr(depth + 1, arr, diceA, sum + diceA[depth][i]);
        }
    }
}