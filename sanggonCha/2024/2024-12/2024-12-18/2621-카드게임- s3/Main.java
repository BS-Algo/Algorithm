import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cardColor = new String[5];
        int[] cardNumber = new int[5];
        StringBuilder sb = new StringBuilder();

        int[] scores = new int[9];
        boolean isCalculated = false;

        for (int i = 0; i < 5; i++) {
            String[] card = br.readLine().split(" ");
            cardColor[i] = card[0];
            cardNumber[i] = Integer.parseInt(card[1]);
        }

        Arrays.sort(cardNumber);

        // 1. 카드 5장이 모두 같은 색이면서 숫자가 연속적일 때, 점수는 가장 높은 숫자에 900을 더한다
        if (cardColor[0].equals(cardColor[1]) && cardColor[1].equals(cardColor[2]) && cardColor[2].equals(cardColor[3]) && cardColor[3].equals(cardColor[4])) {
            if (cardNumber[0] + 1 == cardNumber[1] && cardNumber[1] + 1 == cardNumber[2] && cardNumber[2] + 1 == cardNumber[3] && cardNumber[3] + 1 == cardNumber[4]) {
                scores[0] = cardNumber[4] + 900;
                isCalculated = true;
            } else { // 4. 5장의 카드 색깔이 모두 같을 때 점수는 가장 높은 숫자에 600을 더한다.
                scores[3] = cardNumber[4] + 600;
                isCalculated = true;
            }
        }

        // 2. 카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다.
        if ((cardNumber[0] == cardNumber[1] && cardNumber[1] == cardNumber[2] && cardNumber[2] == cardNumber[3])
                || (cardNumber[1] == cardNumber[2] && cardNumber[2] == cardNumber[3] && cardNumber[3] == cardNumber[4])) {
            scores[1] = cardNumber[1] + 800;
            isCalculated = true;
        }

        // 3. 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다.
        if ((cardNumber[0] == cardNumber[1] && cardNumber[1] == cardNumber[2] && cardNumber[3] == cardNumber[4])) {
            scores[2] = cardNumber[0] * 10 + cardNumber[3] + 700;
            isCalculated = true;
        } else if ((cardNumber[0] == cardNumber[1] && cardNumber[2] == cardNumber[3] && cardNumber[3] == cardNumber[4])) {
            scores[2] = cardNumber[0] + cardNumber[2] * 10 + 700;
            isCalculated = true;
        }

        // 5. 카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다. 예를 들어 R7, R8, G9, Y6, B5 일 때 점수는 509(=9+500)점이다.
        if (cardNumber[0] + 1 == cardNumber[1] && cardNumber[1] + 1 == cardNumber[2] && cardNumber[2] + 1 == cardNumber[3] && cardNumber[3] + 1 == cardNumber[4]) {
            scores[4] = cardNumber[4] + 500;
            isCalculated = true;
        }

        // 6. 카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다. 예를 들어 R7, Y7, R2, G7, R5 일 때 점수는 407(=7+400)점이다.
        if ((cardNumber[0] == cardNumber[1] && cardNumber[1] == cardNumber[2])
                || (cardNumber[1] == cardNumber[2] && cardNumber[2] == cardNumber[3])
                || (cardNumber[2] == cardNumber[3] && cardNumber[3] == cardNumber[4])) {
            scores[5] = cardNumber[2] + 400;
            isCalculated = true;
        }

        // 7. 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더한다. 예를 들어, R5, Y5, Y4, G9, B4 일 때 점수는 354(=5X10+4+300)점이다.
        if (((cardNumber[0] == cardNumber[1]) && ((cardNumber[2] == cardNumber[3]) || (cardNumber[3] == cardNumber[4])))
                || (cardNumber[1] == cardNumber[2] && cardNumber[3] == cardNumber[4])) {
            scores[6] = cardNumber[3] * 10 + cardNumber[1] + 300;
            isCalculated = true;
        }

        // 8. 카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다. 예를 들어, R5, Y2, B5, B3, G4 일 때 점수는 205(=5+200)점이다.
        if (cardNumber[0] == cardNumber[1] || cardNumber[1] == cardNumber[2]) {
            scores[7] = cardNumber[1] + 200;
        } else if (cardNumber[2] == cardNumber[3] || cardNumber[3] == cardNumber[4]) {
            scores[7] = cardNumber[3] + 200;
            isCalculated = true;
        }

        // 위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다. 예를 들어, R1, R2, B4, B8, Y5 일 때 점수는 108(=8+100)점이다.
        if (!isCalculated) {
            scores[8] = cardNumber[4] + 100;
        }

        // 입력으로 카드 5장이 주어질 때, 카드 게임의 점수를 구하는 프로그램을 작성하시오. 두 가지 이상의 규칙을 적용할 수 있는 경우에는 가장 높은 점수가 카드 게임의 점수이다.
        int maxScore = 0;
        for (int i = 0; i < 9; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        System.out.println(maxScore);
    }
}