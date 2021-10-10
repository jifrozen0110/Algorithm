import java.util.*;

class node {
    private int x;
    private int y;
    private int a;

    public node(int x, int y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getA() {
        return this.a;
    }

    public String toString() {
        return "[" + this.x + " " + this.y + " " + this.a + "] ";
    }
}

class 기둥 {
    public static int[][] arr = new int[101][101];

    public static boolean possible(ArrayList<node> answer) {
        for (int j = 0; j < answer.size(); j++) {
            int x = answer.get(j).getX();
            int y = answer.get(j).getY();
            int a = answer.get(j).getA();
            if (x - 1 < 0 || y - 1 < 0 || y + 1 >= 6) {
                return false;
            }
            if (a == 0) {
                if (y == 0 || arr[x - 1][y] == 2 || arr[x][y - 1] == 1 || arr[x][y] == 2)
                    continue;
                else
                    return false;
            } else {
                if (arr[x][y - 1] == 1 || arr[x + 1][y - 1] == 1 || (arr[x - 1][y] == 2 && arr[x + 1][y] == 2))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<node> answer = new ArrayList<node>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (b == 0) {
                int index = 0;
                for (int in = 0; in < answer.size(); in++) {
                    if (answer.get(in).getX() == x && answer.get(in).getY() == y && answer.get(in).getA() == a) {
                        index = in;
                    }
                }
                answer.remove(index);
                arr[x][y] = 0;
                if (!possible(answer)) {

                    answer.add(new node(x, y, a));
                }
            } else {
                answer.add(new node(x, y, a));
                if (a == 0)
                    arr[x][y] = 1;// 기둥
                else if (a == 1)
                    arr[x][y] = 2;// 보
                if (!possible(answer)) {
                    int index = 0;
                    for (int in = 0; in < answer.size(); in++) {
                        if (answer.get(in).getX() == x && answer.get(in).getY() == y && answer.get(in).getA() == a) {
                            index = in;
                        }
                    }
                    answer.remove(index);
                    arr[x][y] = 0;
                }
            }
        }

        int[][] result = new int[answer.size()][3];
        for (int k = 0; k < answer.size(); k++) {
            result[k][0] = answer.get(k).getX();
            result[k][1] = answer.get(k).getY();
            result[k][2] = answer.get(k).getA();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] build_fream = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
                { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
        System.out.print(solution(5, build_fream));

    }
}