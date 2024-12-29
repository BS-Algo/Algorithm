import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());

        // 빈 숫자 배열을 만들고 배열에 숫자 넣기
        int[] arr = new int[switchCount + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수에 따른 스위치 구현
        int studentCount = Integer.parseInt(br.readLine());

        for (int j = 0; j < studentCount; j++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            // 성별
            int gender = Integer.parseInt(st1.nextToken());
            // 받은 스위치 수
            int switchNum = Integer.parseInt(st1.nextToken());

            // 성별에 따른 연산
            if (gender == 1) {
                // 받은 스위치 수의 배수만큼 스위치 상태 바꾸기
                for (int q = switchNum; q <= switchCount; q += switchNum) {
                    changeSwitch(arr, q);
                }
            } else {
                // 시작점
                int start = switchNum;
                // 끝점
                int end = switchNum;

                for (int w = 1; w <= switchCount; w++) {
                    int checkStart = switchNum - w;
                    int checkEnd = switchNum + w;

                    if (checkStart < 1 || checkEnd > switchCount) {
                        break;
                    }

                    if (arr[checkStart] == arr[checkEnd]) {
                        start = checkStart;
                        end = checkEnd;
                    } else {
                        break;
                    }
                }

                for (int s = start; s <= end; s++) {
                    changeSwitch(arr, s);
                }
            }
        }

        int[] resultArr = Arrays.copyOfRange(arr, 1, arr.length);
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < resultArr.length; a++) {
            sb.append(resultArr[a]);
            if ((a + 1) % 20 == 0 || a == resultArr.length - 1) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    // 스위치 상태 바꾸는 메서드
    public static void changeSwitch(int[] arr, int index) {
        arr[index] = arr[index] == 0 ? 1 : 0;
    }
}
