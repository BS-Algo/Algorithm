import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // Pi 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] Pi = new int[N][2];
        for (int i = 0; i < N; i++) {
            Pi[i][0] = i; // 수
            Pi[i][1] = Integer.parseInt(st.nextToken()); // 비용
        }

        // M 입력
        int M = Integer.parseInt(br.readLine());

        // 예외처리
        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 정렬: 비용이 적으면서, 숫자가 높은 순
        // 최대 자릿수를 유지하면서 큰 숫자를 앞에 사용해야함
        // 숫자는 하나씩 존재하지만, 비용은 같을 수 있으므로 둘다 정렬해야함
        Arrays.sort(Pi, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0]; // 내림차순(숫자가 높은 순)
            }
            return a[1] - b[1]; // 오름차순(비용이 적은 순)
        });

        // greedy
        // 1-1. 최소 비용으로 최대 자릿수와 함께 임시 수 구하기
        // 숫자가 아무리 크더라도 자릿수가 하나 증가하는 것이 더 큼
        int index = 0;
        int maxLen = 0;

        // 순서를 유지하면서, 가변 크기인 ArrayList 사용
        // 수와 비용을 함께 저장(비용은 후에 교체를 위해)
        List<int[]> number = new ArrayList<>();

        if (Pi[index][0] == 0) { // 최소 비용의 수가 0이라면
            if (index + 1 < N && M >= Pi[index + 1][1]) { // 다음 자리 숫자의 비용이 충분하다면
                M -= Pi[index + 1][1]; // 그 다음 숫자를 첫 자리에 사용하고, 그 비용을 사용
                number.add(new int[]{Pi[index + 1][0], Pi[index + 1][1]}); // 숫자와 비용 추가
                maxLen++; // 길이 증가
            }
        }

        while (index < N) {
            if (M >= Pi[index][1]) { // 비용이 충분하다면
                M -= Pi[index][1]; // 현재 숫자의 비용을 사용
                number.add(new int[]{Pi[index][0], Pi[index][1]}); // 숫자를 추가
                maxLen++;
            } else {
                index++;
            }
        }

        // 1-2. 1차 결과 디버깅
//        System.out.println(maxLen); // 최대 길이
//        System.out.println(M); // 남은 비용

        // 2. 앞자리부터 남은 비용으로 대체

        // 2-1. Pi 재정렬: 수 내림차순, 비용 오름차순
        Arrays.sort(Pi, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 2. 비용 오름차순
            }
            return b[0] - a[0]; // 1. 수 내림차순
        });

        index = 0; // 젤 앞자리부터 교체 고려
        while (M > 0 && index < maxLen) { // 비용이 남아있지 않으면 교체할 수 없음

            int cost = number.get(index)[1]; // 비용

            for (int i = 0; i < N; i++) {
                int addCost = Pi[i][1] - cost; // 추가 비용

                if (addCost <= M) { // 교체 가능한 비용이라면
                    number.set(index, new int[]{Pi[i][0], Pi[i][1]});
                    M -= addCost; // 추가 비용 사용
                    index++;
                    break; // 제일 큰 수이고, 최소 비용으로 교체했으므로 바로 종료하고 다음 자릿수 계산
                }
            }
        }

        // 출력
        // 예외처리
        if(number.get(0)[0] == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] cur : number) {
            sb.append(cur[0]); // 숫자만 추가
        }
        System.out.println(sb.toString());
    }
}