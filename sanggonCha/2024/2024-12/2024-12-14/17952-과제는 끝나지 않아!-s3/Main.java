import java.io.*;
import java.util.*;

// 자바에서 클래스의 이름은 대문자로 시작
class TaskInfo {
    int score;
    int time;

    public TaskInfo(int score, int time) {
        this.score = score;
        this.time = time;
    }


    // 메서드의 이름은 소문자로 시작!
    // 과제 수행 함수
    public void performTask() {
        this.time--;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalScore = 0;
        Stack<TaskInfo> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (!input.equals("0")) { // 새로운 과제가 추가된 것이라면
                String[] taskInfo = input.split(" ");
                int score = Integer.parseInt(taskInfo[1]);
                int time = Integer.parseInt(taskInfo[2]);
                TaskInfo task = new TaskInfo(score, time);
                task.performTask(); // 과제를 바로 수행하고
                if (task.time == 0) { // 수행이 완료된 과제라면(과제의 수행시간이 1인 경우)
                    totalScore += task.score; // 과제 점수 누적합 push 하지 않는다
                } else {
                    stack.push(task); // 과제를 스택에 push
                }
            } else if (!stack.isEmpty()) { // 새로운 과제가 추가된 것이 아니고, 수행할 과제가 아직 있다면
                TaskInfo nowTask = stack.pop(); // stack.peek(): 스택에서 가장 최근에 넣은 값을 확인하는 메서드
                if (nowTask.score > 0) { // 과제가 아직 수행할 것이 남아있다면
                    nowTask.performTask(); // 과제를 수행한다

                    // 과제를 수행한 결과
                    if (nowTask.time == 0) { // 과제가 모두 끝났다면
                        totalScore += nowTask.score; // 과제 점수를 누적합
                    } else { // 과제가 아직 덜 끝났다면
                        stack.push(nowTask);
                    }
                }
            }
        }
        System.out.println(totalScore);
    }
}