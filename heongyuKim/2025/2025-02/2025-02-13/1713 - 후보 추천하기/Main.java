import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


class Main {
    // 결과
    static StringBuilder result = new StringBuilder();

    // 추천받은 학생 클래스
    static class RecommendStu implements Comparable<RecommendStu> {

        private int studentNumber;
        private int recommendCount;
        private int postTime;

        public RecommendStu(int studentNumber, int recommendCount, int postTime) {
            this.studentNumber = studentNumber;
            this.recommendCount = recommendCount;
            this.postTime = postTime;
        }

        public void recommendAdd() {
            this.recommendCount++;
        }

        @Override
        public int compareTo(RecommendStu recommendStu) {
            if (this.recommendCount == recommendStu.recommendCount) {
                return Integer.compare(recommendStu.postTime, this.postTime);
            }

            return Integer.compare(recommendStu.recommendCount, this.recommendCount);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사진틀 생성
        List<RecommendStu> photoFrame = new ArrayList<>();
        
        // 사진틀 갯수
        int photoFrameLength = Integer.parseInt(br.readLine());

        // 전체 학생의 총 추천횟수
        int totalRecommendCount = Integer.parseInt(br.readLine());

        // 각 학생의 추천
        StringTokenizer recommendInfo = new StringTokenizer(br.readLine());

        for (int i = 0; i < totalRecommendCount; i++) {

            // 추천 후보 번호
            int studentNumber = Integer.parseInt(recommendInfo.nextToken());
            
            // 만약 사진틀에 빈 공간이 없으면
            if (photoFrame.size() == photoFrameLength) {

                findRegisteredStudent(photoFrame, studentNumber, i, true);

            } else {
                if (photoFrame.isEmpty()) {

                    RecommendStu newRecommendStudent = new RecommendStu(studentNumber, 1, i);
                    photoFrame.add(newRecommendStudent);

                } else {
                    findRegisteredStudent(photoFrame, studentNumber, i, false);

                }

            }
        }

        int[] studentNumberList = new int[photoFrame.size()];

        for (int i = 0; i < photoFrame.size(); i++) {
            studentNumberList[i] = photoFrame.get(i).studentNumber;
        }

        Arrays.sort(studentNumberList);

        for (int i = 0; i < photoFrame.size(); i++) {
            result.append(studentNumberList[i]).append(" ");
        }

        System.out.println(result.toString());

    }

    // 이미 후보로 올라가 있는 학생을 찾는 메소드
    static void findRegisteredStudent(List<RecommendStu> photoFrame, int studentNumber, int time, boolean isFull) {

        RecommendStu existStudent = null;

        for (int j = 0; j < photoFrame.size(); j++) {
            RecommendStu student = photoFrame.get(j);
            if (student.studentNumber == studentNumber) {
                existStudent = student;
            }
        }

        if (existStudent == null) {

            if (isFull) {
                // 정렬 후
                Collections.sort(photoFrame);

                // 추천받은 수가 제일 적은 학생을 제거하거나 추천받은 수가 같으면 가장 오래된 학생을 제거
                photoFrame.remove(photoFrame.size() - 1);
            }

            RecommendStu newRecommendStudent = new RecommendStu(studentNumber, 1, time);
            photoFrame.add(newRecommendStudent);

        } else {
            existStudent.recommendAdd();
        }

    }
}