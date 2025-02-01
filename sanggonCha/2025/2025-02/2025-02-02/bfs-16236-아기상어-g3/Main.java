// 0. 아기 상어가 입력되면 좌표를 아기 상어 객체에 저장한다
// 1. 모든 물고기를 찾는다. (while)
// True  2-1. 제일 가깝고, 제일 위에 있고, 제일 왼쪽에 있는 물고기를 먹으러 간다.
// False 2-2. 물고기를 못 찾았다면 종료한다.

// 물고기들을 저장한 후, 정렬해서 꺼낼 것: Comparator을 사용
// **Comparator**
// 두 객체를 비교해서 순서를 결정하는 인터페이스
// 주로 정렬하거나 우선순위 큐 같은 자료구조에서 사용
// 기본 구조
// Comparator<Type> comparator = new Comparator<Type>() {
//     @Override
//     public int compare(Type o1, Type o2) {
//      // o1과 o2를 비교하는 로직 작성
//     }
// }
// 음수 반환: o1이 o2보다 앞에 온다.
// 양수 반환: o2가 o1보다 앞에 온다.
// 0   반환: 순서를 바꾸지 않는다.

// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기,
// 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다
// 아래의 Fish 객체를 거리 기준으로 정렬하고 싶다면: 람다식으로 작성
// PriorityQueue<Fish> pq = new PriorityQueue<>((f1, f2) -> {
//     // 거리 기준 오름차순 정렬: 거리가 가까운 물고기(f1.distance가 더 작은 물고기)가 우선
//     if (f1.distance != f2.distance) return f1.distance - f2.distance;
//
//     // 같은 거리의 물고기 중, i(행) 값이 작은 물고기(더 위에 있는 물고기)가 우선.
//     if (f1.i != f2.i) return f1.i - f2.i;
//
//     // 거리와 i가 같은 경우, j(열) 값이 작은 물고기(더 왼쪽에 있는 물고기)가 우선
//     return f1.j - f2.j;
// });

// 여기서 만약
// 1. 거리가 같고,
// 2. i좌표가 같고,
// 3. j좌표가 다르다면(f1.j = 0. f2.j = 1)
// (0 - 1 = -1)음수를 반환하게 되고, 그 결과 f1이 우선순위에 따라 큐에서 먼저 나온다.
// 그래서 더 왼쪽에 있는 물고기를 먼저 반환하게 된다.

import java.io.*;
import java.util.*;

class Fish {
    int i, j, distance;

    public Fish(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}

class BabyShark {
    int i, j, size = 2, count = 0;

    public BabyShark(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void eatFish() {
        count++;
        if (count == size) {
            size++;
            count = 0;
        }
    }

    public void move(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static BabyShark bs;
    static int N;
    static PriorityQueue<Fish> fishes;
    static int[] di = {1, -1, 0, 0}, dj = {0, 0, 1, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력 받기
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 공간 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 9) { // 아기 상어 위치 찾기
                    bs = new BabyShark(i, j); // 아기 상어 객체에 저장
                    map[i][j] = 0; // 아기 상어 위치 지우기
                }
            }
        }

        // 먹을 수 있는 물고기를 못 찾을 때 까지 계속 실행
        int time = 0;
        while (true) {
            Fish fish = findFish();
            if (fish == null) {
                break;
            }

            time += fish.distance;
            bs.move(fish.i, fish.j); // 물고기 위치로 이동
            map[fish.i][fish.j] = 0; // 물고기 제거

            bs.eatFish(); // 물고기 먹고 크기 증가
        }

        System.out.println(time);
    }

    private static Fish findFish() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(new int[]{bs.i, bs.j, 0}); // 출발위치의 좌표와 거리 0 저장
        visited[bs.i][bs.j] = true;

        fishes = new PriorityQueue<>((f1, f2) -> {
            if (f1.distance != f2.distance) return f1.distance - f2.distance; // 거리 오름차순 정렬
            if (f1.i != f2.i) return f1.i - f2.i; // 윗쪽의 물고기를 반환
            return f1.j - f2.j; // 왼쪽의 물고기를 반환
        }); // 찾은 물고기를 저장

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            int dist = current[2];

            // 물고기 발견
            if (map[i][j] > 0 && map[i][j] < bs.size) {
                fishes.offer(new Fish(i, j, dist));
            }

            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (indexCheck(ni, nj) && !visited[ni][nj] && map[ni][nj] <= bs.size) {
                    visited[ni][nj] = true; // 방문 처리
                    queue.offer(new int[]{ni, nj, dist + 1}); // 거리를 1 증가하여 새로운 좌표 저장
                }
            }
        }

        // 가장 가까운 물고기 찾기
        if (fishes.isEmpty()) {
            return null; // 없으면 null 반환
        }

        return fishes.poll(); // 오름차순 정렬된 가장 앞의 물고기를 반환

    }

    private static boolean indexCheck(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < N;
    }
}