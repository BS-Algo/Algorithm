import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    // 알파벳 - 빨강, 파랑, 노랑, 초록
    static int[] colorArr = new int[4];

    // 숫자 배열 - 인덱스를 맞추기 위해 10으로 설정
    static int[] numArr = new int[10];
    
    // 같은 색깔의 카드가 최대 몇 개인지
    static int maxColorCount;

    // 같은 숫자의 카드가 최대 몇 개인지
    static int maxNumCount;

    // 같은 숫자가 최대로 있는 숫자
    static int maxCountNum;

    // 가장 높은 숫자
    static int maxNum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 해쉬맵에 값 넣기
        for (int i = 0; i < 5;  i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            switch (color) {
                case "R":
                    colorArr[0]++;
                    break;

                case "B":
                    colorArr[1]++;
                    break;

                case "Y":
                    colorArr[2]++;
                    break;

                case "G":
                    colorArr[3]++;
                    break;
            }

            numArr[num]++;
        }

        maxColorCount = IntStream.of(colorArr).max().orElse(maxColorCount);
        findMaxNum();

        // 조건에 맞는 것을 찾기
        // 카드 5장이 모두 같을 때
        if (maxColorCount == 5 || checkIncrement()) {
            // 연속적이라면
            if (checkIncrement() && maxColorCount != 5) {
                System.out.println(maxNum + 500);
                return;
            } else if (!checkIncrement() && maxColorCount == 5) {
                System.out.println(maxNum + 600);
                return;
            } else {
                System.out.println(maxNum + 900);
                return;
            }

        } else {
            if (maxNumCount == 4) {
                System.out.println(maxCountNum + 800);
                return;
            } else if (maxNumCount == 3) {
                int twoSome = checkThreeToTwo();
                if (twoSome != 0) {
                    System.out.println((maxCountNum * 10) + twoSome + 700);
                    return;
                } else {
                    System.out.println(maxCountNum + 400);
                    return;
                }

            } else if (maxNumCount == 2) {
                int twoSome = checkTwoToTwo();
                if (twoSome != 0) {
                    System.out.println((maxCountNum * 10) + twoSome + 300);
                    return;
                } else {
                    System.out.println(maxCountNum + 200);
                    return;
                }
            } else {
                System.out.println(maxNum + 100);
                return;
            }
        }
    }

    static void findMaxNum() {
        for (int i = 1; i < 10; i++) {
            if (numArr[i] >= maxNumCount) {
                maxNumCount = numArr[i];
                maxCountNum = i;
            }

            if (numArr[i] > 0) {
                maxNum = i;
            }

        }
    }
    
    // 연속적이라는 것을 체크하기
    static boolean checkIncrement() {
        String check = Arrays.toString(numArr).replaceAll("[^0-9]", "");
        String subString = "11111";

        if (check.contains(subString)) {
            return true;
        } else {
            return false;
        }
    }
    
    // 3장이 같을 때 2장도 같은지
    static int checkThreeToTwo() {
        for (int i = 1; i < 10; i++) {
            if (numArr[i] == 2) {
                return i;
            }
        }
        return 0;
    }


    // 2장이 같을 때 2장도 같은지
    static int checkTwoToTwo() {
        for (int i = 1; i < 10; i++) {
            if (numArr[i] == 2 && i != maxCountNum) {
                return i;
            }
        }
        return 0;
    }

}