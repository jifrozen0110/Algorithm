import java.util.*;

class Permutation {
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            now[depth] = arr[depth];
            permutation(arr, depth + 1);
            swap(arr, i, depth);
        }
    }
}

class 외벽점검 {
    public int solution(int n, int[] weak, int[] dist) {
        // 원형은 보통 일자 형태로 변경
        ArrayList<Integer> weakList = new ArrayList<Integer>();
        // 1 5 6 10
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i]);
        }
        // 13 17 18 22
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i] + n);
        }
        // 친구의 최소값 찾기 위해
        int answer = dist.length + 1;
        // 순열
        Permutation perm = new Permutation(dist.length, dist.length);
        perm.permutation(dist, 0);
        ArrayList<ArrayList<Integer>> distList = perm.getResult();
        // 시작 지점
        for (int start = 0; start < weak.length; start++) {
            // distList -> 순열 list 완전 탐색
            for (int i = 0; i < distList.size(); i++) {
                int cnt = 1;// 친구 한명
                int position = weakList.get(start) + distList.get(i).get(cnt - 1);// 취약점 시작 위치 + 순열 한 명이 이동할 수 있는 위치 =
                                                                                  // 현재 위치
                for (int index = start; index < start + weak.length; index++) {// 시작 위치 부터 취약점 전부 돌면
                    if (position < weakList.get(index)) {// 갈 수 잇는 거리가 다음 취약점 거리보다 짧으면
                        cnt += 1;// 한명 더 데리고옴
                        if (cnt > dist.length) {// 다 데리고 오면
                            break;
                        }
                        position = weakList.get(index) + distList.get(i).get(cnt - 1);// 다음 위치
                    }
                }
                answer = Math.min(answer, cnt); // 최소 친구 수 구하기
            }
        }
        if (answer > dist.length) {// 사람 수 보다 많다면
            return -1;
        }
        return answer;
    }
}