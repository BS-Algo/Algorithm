import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] standard = new int[4];
    static int[][] ingredients;
    static int minPrice = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer info = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            standard[i] = Integer.parseInt(info.nextToken());
        }

        ingredients = new int[N + 1][5];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer info2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ingredients[i][j] = Integer.parseInt(info2.nextToken());
            }
        }

        // dfs로 조합
        dfs(1, 0, 0, 0, 0, 0, new ArrayList<>());


        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(minPrice);

        for (int i = 0; i < result.get(0).size(); i++) {
            sb.append(result.get(0).get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }


    private static void dfs(int index, int p, int f, int s, int u, int price, ArrayList<Integer> list) {
        
        // 가지치기 조건 - 비용이 현재 최소비용보다 크면 return
        if (price > minPrice) {
            return;
        }

        // 종료조건
        if (check(p, f, s, u)) {
            // 비용이 더 작으면
            if (price < minPrice) {
                minPrice = price;
                result.clear(); // 기존 결과 지우고
                result.add(new ArrayList<>(list)); // 반드시 깊은 복사를 해서 추가해야함.
            }
            return;
        }

        for (int i = index; i < N + 1; i++) {
            int[] ingredient = ingredients[i];
            list.add(i);
            dfs(i + 1, p + ingredient[0], f + ingredient[1], s + ingredient[2], u + ingredient[3], price + ingredient[4], list);
            list.remove(list.size() - 1);
        }
    }
    
    // 영양소 기준을 만족하는지 체크
    private static boolean check(int p, int f, int s, int u) {
        if (p >= standard[0] && f >= standard[1] && s >= standard[2] && u >= standard[3]) {
            return true;
        }

        return false;
    }
}