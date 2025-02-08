import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static class Teams {
        List<Team> teams;

        public Teams(List<Team> teams) {
            this.teams = teams;
        }
    }

    static class Team implements Comparable<Team> {

        private int id;
        private int totalScore;
        private List<Problem> problems;
        private int lastTime;
        private int submitCount;


        public Team(int id, int totalScore, List<Problem> problems, int lastTime, int submitCount) {
            this.id = id;
            this.totalScore = totalScore;
            this.problems = problems;
            this.lastTime = lastTime;
            this.submitCount = submitCount;
        }

        public void calculateTotalScore() {
            for (int i = 0; i < problems.size(); i++) {
                this.totalScore += problems.get(i).score;
            }

        }

        public void lastTimeChange(int lastTime) {
            this.lastTime = lastTime;
        }

        public void addSubmitCount() {
            this.submitCount++;
        }

        @Override
        public int compareTo(Team team) {
            if (this.totalScore == team.totalScore) {
                if (this.submitCount == team.submitCount) {
                    return Integer.compare(this.lastTime, team.lastTime);
                }

                return Integer.compare(this.submitCount, team.submitCount);
            }


            return Integer.compare(team.totalScore, this.totalScore);
        }
    }


    static class Problem {
        private int number;
        private int score;

        public Problem(int number, int score) {
            this.number = number;
            this.score = score;
        }

        // 점수를 최댓값으로 변경할 메서드
        public void scoreChange(int score) {
            this.score = Math.max(this.score, score);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int testCount = Integer.parseInt(br.readLine());

        for (int i = 0; i< testCount; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            // 팀 리스트 생성
            List<Team> createTeams = new ArrayList<>();

            // 팀의 갯수
            int teamCount = Integer.parseInt(info.nextToken());

            // 문제의 갯수
            int problemCount = Integer.parseInt(info.nextToken());

            // 팀의 ID
            int teamId = Integer.parseInt(info.nextToken());

            // 로그 엔트리의 갯수
            int logEntryCount = Integer.parseInt(info.nextToken());

            // 팀 생성 및 문제 생성
            for (int j = 1; j <= teamCount; j++) {
                List<Problem> problems = new ArrayList<>();

                // 문제부터 생성
                for (int e = 1; e <= problemCount; e++) {
                    Problem problem = new Problem(e, 0);
                    problems.add(problem);
                }

                // 팀 생성
                Team team = new Team(j, 0, problems, 0, 0);

                // 팀 리스트에 넣기
                createTeams.add(team);
            }

            Teams teamList = new Teams(createTeams);

            // 로그
            for (int j = 0; j < logEntryCount; j++) {
                StringTokenizer log = new StringTokenizer(br.readLine());

                // 팀 ID
                int id = Integer.parseInt(log.nextToken());

                // 문제 번호
                int problemNumber = Integer.parseInt(log.nextToken());

                // 점수
                int score = Integer.parseInt(log.nextToken());

                // 팀 ID에 맞는 팀을 찾아서 문제 번호에 점수 갱신
                teamList.teams.get(id - 1).problems.get(problemNumber - 1).scoreChange(score);

                // 제출 횟수 증가
                teamList.teams.get(id - 1).addSubmitCount();

                // 마지막 제출 시간 갱신
                teamList.teams.get(id - 1).lastTimeChange(j);

            }

            // 팀의 총 점수 구하기
            for (int j = 0; j < teamList.teams.size(); j++) {
                teamList.teams.get(j).calculateTotalScore();
            }

            // 정렬하기
            Collections.sort(teamList.teams);

            // 순위 출력
            for (int j = 0; j < teamCount; j++) {
                if (teamList.teams.get(j).id == teamId) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}