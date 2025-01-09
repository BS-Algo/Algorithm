import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사진틀의 개수
        int[] recommendOrder = new int[101]; // 추천 순서를 저장
        int[] recommendResult = new int[101]; // 추천 횟수를 저장
        int M = Integer.parseInt(br.readLine());
        String[] recommendList = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int recommend = Integer.parseInt(recommendList[i]);

            // 이미 사진틀에 있는 경우, 추천 수만 증가시키고 종료
            if (recommendResult[recommend] > 0) {
                recommendResult[recommend]++;
                continue;
            }

            // 사진틀에 없는 경우
            int cnt = 0;
            for (int j = 1; j <= 100; j++) {
                if (recommendResult[j] > 0) cnt++;
            }

            // 사진틀이 가득 찬 경우, 최소 추천 횟수 및 오래된 순서 확인 후 삭제
            if (cnt == N) {
                int minRecommendCount = 1001;
                int minRecommendStudentNum = 0;
                int minRecommendStudentOrder = 1001;

                for (int j = 1; j <= 100; j++) {
                    if (recommendResult[j] > 0) {
                        // 최소 추천 횟수와 같고, 순서가 가장 오래된 경우
                        if (recommendResult[j] < minRecommendCount || (recommendResult[j] == minRecommendCount && recommendOrder[j] < minRecommendStudentOrder)) {
                            minRecommendCount = recommendResult[j]; // // 최소 추천 횟수 갱신
                            minRecommendStudentOrder = recommendOrder[j]; // 최소 추천 순서 갱신
                            minRecommendStudentNum = j; // 최소 추천 횟수학생 번호 저장
                        }
                    }
                }

                // 제거
                recommendResult[minRecommendStudentNum] = 0;
                recommendOrder[minRecommendStudentNum] = 0;
            }

            // 새 학생 추가
            recommendResult[recommend] = 1;
            recommendOrder[recommend] = i;
        }

        // 결과 출력 (오름차순)
        for (int i = 1; i <= 100; i++) {
            if (recommendResult[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
