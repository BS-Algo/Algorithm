import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // N 입력
        int G = Integer.parseInt(br.readLine()); // 게이트의 수
        int P = Integer.parseInt(br.readLine()); // 비행기의 수

        // parent 생성 및 초가화
        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        // 비행기 입력 및 도킹
        docking(G, P);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void docking(int G, int P) throws IOException {
        int ans = 0;

        // P개의 비행기
        while (P-- > 0) {
            // 비행기 입력
            int gate = find(Integer.parseInt(br.readLine()));

            if (gate == 0) {
                break; // 바로 종료
            }

            // 현재 게이트는 사용했으므로, 바로 전 게이트로 parent를 수정
            // 후에 find를 통해서 찾아갈 때도, 올바르게 찾아감
            parent[gate] = gate - 1;
            ans++;
        }

        // 모두 도킹 가능한 경우
        System.out.println(ans);
    }
}