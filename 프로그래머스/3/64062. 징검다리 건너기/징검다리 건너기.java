class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200_000_000; 
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                min = mid + 1; 
            } else {
                max = mid - 1; 
            }
        }

        return answer;
    }

    // mid 명이 건널 수 있는지 확인하는 메소드
    private boolean canCross(int[] stones, int k, int mid) {
        int count = 0; 
        for (int stone : stones) {
            if (stone - mid < 0) {
                count++;
            } else {
                count = 0; 
            }
            if (count >= k) return false; 
        }
        return true;
    }
}
