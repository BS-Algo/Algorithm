import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 공통된 숫자를 모두 찾아서 사전 순으로 가장 나중인 것을 만드는 것이 아니라
// 최댓값을 기준으로 공통 부분 수열을 찾아야 함
class Main {

    // 공통된 부분을 찾아서 넣을 리스트
    static List<Integer> result = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N
        int N = Integer.parseInt(br.readLine());
        List<Integer> firstList = new ArrayList<>();

        StringTokenizer first = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            firstList.add(Integer.parseInt(first.nextToken()));
        }

        // M
        int M = Integer.parseInt(br.readLine());
        List<Integer> secondList = new ArrayList<>();

        StringTokenizer second = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            secondList.add(Integer.parseInt(second.nextToken()));
        }

        solve(firstList, secondList);

        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(result.size());
        System.out.println(sb.toString());
    }

    private static void solve(List<Integer> firstList, List<Integer> secondList) {
        if (firstList.isEmpty() || secondList.isEmpty()) return;

        int firstMax = Collections.max(firstList);
        int secondMax = Collections.max(secondList);
        int first_max_idx = firstList.indexOf(firstMax);
        int second_max_idx = secondList.indexOf(secondMax);

        if (firstMax > secondMax) {
            firstList.remove(first_max_idx);
            solve(firstList, secondList);
        } else if (firstMax < secondMax) {
            secondList.remove(second_max_idx);
            solve(firstList, secondList);
        } else {
            result.add(firstMax);
            solve(firstList.subList(first_max_idx + 1, firstList.size()), secondList.subList(second_max_idx + 1, secondList.size()));
        }
    }
}