import java.util.*;

class Solution {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        ArrayList<Assignment> list = new ArrayList<>();
        Stack<Assignment> stack = new Stack<>();
        ArrayList<String> answerList = new ArrayList<>();

        // 객체로 만들어서 시간 변환 및 시간 순으로 정렬
        for (int i = 0; i < plans.length; i++) {
            String subject =  plans[i][0];
            String start = plans[i][1];
            int play = Integer.parseInt(plans[i][2]);

            int hour = Integer.parseInt(start.split(":")[0]);
            int minute = Integer.parseInt(start.split(":")[1]);

            int startTime = hour * 60 + minute;
            Assignment assignment = new Assignment(subject, startTime, play);

            list.add(assignment);
        }

        // 정렬 - startTime을 기준으로 오름차순
        list.sort((a, b) -> a.startTime - b.startTime);

        // 로직 수행
        for (int i = 0; i < plans.length - 1; i++) {
            Assignment cur = list.get(i);
            Assignment next = list.get(i + 1);

            int gap = next.startTime - cur.startTime;
            
            if (cur.playTime <= gap) {
                answerList.add(cur.subject);
                int remainTime = gap - cur.playTime;

                while (remainTime > 0 && !stack.isEmpty()) {
                    Assignment stackAssignment = stack.pop();

                    if (stackAssignment.playTime <= remainTime) {
                        remainTime -= stackAssignment.playTime;
                        answerList.add(stackAssignment.subject);
                    } else {
                        stackAssignment.minusPlayTime(remainTime);
                        stack.push(stackAssignment);
                        break;
                    }
                }
            } else {
                cur.minusPlayTime(gap);
                stack.push(cur);
            }
        }
        
        // 마지막 순서로 들어온 과제 해결하기
        answerList.add(list.get(plans.length - 1).subject);

        // 스택에 쌓인 과제들 모두 실행하기
        while (!stack.isEmpty()) {
            Assignment assignment = stack.pop();
            answerList.add(assignment.subject);
        }

        for (int i = 0; i < plans.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }


    public static class Assignment {

        String subject;
        int startTime;
        int playTime;

        public Assignment(String subject, int startTime, int playTime) {
            this.subject = subject;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        // 수행시간 차감
        public void minusPlayTime(int playTime) {
            this.playTime -= playTime;
        }
    }
}