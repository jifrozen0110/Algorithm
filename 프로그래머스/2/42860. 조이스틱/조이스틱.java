public class Solution {
    public int solution(String name) {
        int length = name.length();
        int answer = 0;
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            int diffA = c - 'A';
            int diffZ = 'Z' - c + 1;
            answer += Math.min(diffA, diffZ);

            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next));
        }

        answer += minMove;
        return answer;
    }

}
