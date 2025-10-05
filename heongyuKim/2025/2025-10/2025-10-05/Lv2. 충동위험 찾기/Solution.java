import java.util.*;


class Solution {

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        int[][] arr = new int[101][101];

        List<Robot> list = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            int index = routes[i][0] - 1;
            Pos pos = new Pos(points[index][0], points[index][1]);
            Robot robot = new Robot(pos);

            arr[pos.getR()][pos.getC()]++;

            for (int j = 1; j < routes[i].length; j++) {
                index = routes[i][j] - 1;
                pos = new Pos(points[index][0], points[index][1]);
                robot.posList.add(pos);
            }

            list.add(robot);
        }
        
        // 출발지부터 충돌할 경우
        for (int[] row : arr) {
            for (int val : row) {
                if (val > 1) {
                    answer++;
                }
            }
        }

        while (list.size() > 1) {
            List<Integer> removeList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                boolean b = list.get(i).movePos(arr);

                if (!b) {
                    removeList.add(i);
                }
            }

            for (int idx : removeList) {
                list.remove(idx);
            }

            for (int[] row : arr) {
                for (int val : row) {
                    if (val > 1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    class Robot {
        Pos pos;
        List<Pos> posList;

        public Robot(Pos pos) {
            this.pos = pos;
            posList = new ArrayList<>();
        }

        public boolean movePos(int[][] arr) {

            if (posList.size() > 0 && posList.get(0).getR() == pos.getR() && posList.get(0).getC() == pos.getC()) {
                posList.remove(0);
            }

            arr[pos.getR()][pos.getC()]--;

            if (posList.size() == 0) {
                return false;
            }

            if (posList.get(0).getR() != pos.getR()) {
                if (posList.get(0).getR() > pos.getR()) {
                    pos.setR(1);
                } else {
                    pos.setR(-1);
                }
            } else if (posList.get(0).getC() != pos.getC()) {
                if (posList.get(0).getC() > pos.getC()) {
                    pos.setC(1);
                } else {
                    pos.setC(-1);
                }
            }

            arr[pos.getR()][pos.getC()]++;

            return true;
        }
    }

    class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public void setR(int distance) {
            r += distance;
        }

        public void setC(int distance) {
            c += distance;
        }
    }
}
