import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    // 학기 기간
    static int semesterTime;

    // 현재 진행하고 있는 과제의 정보를 저장할 배열
    static int[] assignment = new int[3];

    // 성애의 점수
    static int score;
    
    // 스택
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        semesterTime = Integer.parseInt(br.readLine());

        for (int i = 0; i < semesterTime; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 만약 과제가 있으면
            if (st.countTokens() > 1) {
                // 만약 과제를 저장하는 배열에 과제가 들어 있다면 현재 배열에 담겨져 있는 과제는 스택에 담고 현재 받은 과제를 배열에 담기 시간은 -1하고 담아야 함.
                if (assignment[0] == 1) {
                    stack.push(new int[] {assignment[0], assignment[1], assignment[2]});
                }
                
                // 새로운 과제의 정보를 배열에 담기
                assignment[0] = Integer.parseInt(st.nextToken());
                assignment[1] = Integer.parseInt(st.nextToken());
                assignment[2] = Integer.parseInt(st.nextToken()) - 1;

                // 과제 완료 여부에 따른 점수 더하고 스택의 맨위에 과제의 정보가 있으면 가져와서 배열에 채우기
                isComplete();

            } else {
                // 과제가 들어있으면 과제시간 1분을 차감
                if (assignment[0] == 1) {
                    assignment[2] -= 1;
                }

                isComplete();
            }
        }

        System.out.println(score);
    }

    static void isComplete() {
        if (assignment[0] == 1 && assignment[2] == 0) {
            score += assignment[1];
            if (!stack.isEmpty()) {
                assignment = stack.pop();
            } else {
                assignment[0] = 0;
            }
        }
    }
}