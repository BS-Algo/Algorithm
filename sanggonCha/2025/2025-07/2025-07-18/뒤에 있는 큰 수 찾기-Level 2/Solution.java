import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        int len = numbers.length;

        // 0. 정답 배열 생성 및 초기화
        int[] answer = new int[numbers.length];
        answer[numbers.length - 1] = -1;

        // 0. 스택 생성 및 초기화
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[numbers.length - 1]);

        // 1. 뒤에서 부터 살펴보기
        for (int i = 1; i < numbers.length; i++) {

            int num = numbers[len - i - 1]; // 이번에 살펴볼 수

            if (num < stack.peek()) { // 1. peek 값보다 작다면

                answer[len - i - 1] = stack.peek(); // peek 값을 기록
                stack.push(num); // 현재수 push

            } else if (num > stack.peek()) { // 2. peek 값보다 크다면

                // num보다 작은 peek값 모두 제거
                while (!stack.isEmpty() && num > stack.peek()) {
                    stack.pop();
                }

                if (!stack.isEmpty()) { // 스택이 비어있지 않은데
                    if (stack.peek() == num) { // 같은 값을 만난 거라면
                        stack.pop(); // 일단 제거 후
                        if (!stack.isEmpty()) { // 스택이 비어있지 않다면
                            answer[len - i - 1] = stack.peek(); // peek 값을 기록하고
                        } else { // 스택이 비어있다면
                            answer[len - i - 1] = -1; // -1을 기록
                        }
                    } else { // num보다 큰 peek 값을 만난 거라면
                        answer[len - i - 1] = stack.peek(); // 기록
                    }
                    stack.push(num); // 다시 num을 push
                } else { // 스택이 비었다면, -1을 기록
                    answer[len - i - 1] = -1;
                    stack.push(num);
                }

            } else { // 3. peek 값과 일치하는 경우

                stack.pop(); // peek 값을 알아야 하므로, 일단 제거

                if (!stack.isEmpty()) { // 스택이 비어있지 않다면
                    answer[len - i - 1] = stack.peek(); // peek 값을 기록
                } else { // 스택이 비어있다면
                    answer[len - i - 1] = -1; // -1을 기록
                }
                stack.push(num); // 다시 push(어차피 기존 peek와 num은 같은 수 이므로)

            }
        }

        return answer;
    }
}