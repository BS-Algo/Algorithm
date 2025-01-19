import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String word = br.readLine();
            findNextWordOrder(word);
        }
    }

    // 전체적인 순서를 고려했을 때
    // 제일 앞에 오는 수는 오름차순으로만 돼 있는 수이고,
    // 제일 뒤에 오는 수는 내림차순으로만 돼 있는 수이다.
    // 바로 위의 문장에 다시 집중을 해보자면, 어떤 숫자가 내림차순으로 돼 있다면
    // 해당 숫자는 더 이상 내림차순으로 만들 수 있는 수가 없다는 것과 마찬가지다.

    // 그렇다면 우리가 직접 오름차순 -> 내림차순 으로 단어를 하나씩 만들어간다고 생각할 때 어디부터 고려를 하면 될까?
    // 구성된 숫자의 뒤에서부터 고려를 한다
    // 뒤에서부터 하나씩 숫자를 살펴보고, 오름차순으로 돼 있는 숫자들이 있으면 하나씩 내림차순으로 바꿔가는 것이다.

    // 단어를 파악하기 쉽게 순서만을 고려해서 숫자로 생각해보자
    // 1234567 라는 단어를 만들 수 있는 순서 중에서 5674321 생각을 해보자
    // 5674321 의 바로 다음 단어는 무엇일까?
    // 5712346 이다
    // 이렇게 생각할 수 있는 근거는 무엇일까?
    // 뒤에서부터 수를 하나씩 생각해보면,
    // 56"74321"에서 "74321"부분은 이미 내림차순으로만 돼 있다.
    // 그 말은 해당 다섯 자리에서는 더 이상 뒤에 올 수 있는 순서가 없는 것이다.
    // 그렇다면 바로 앞에 있는 숫자를 건드려야할 차례인 것이다.
    // (물론 앞에 숫자를 포함해서도 내림차순이라면 당연히 더 앞의 숫자까지 고려해야한다.)
    // 5"674321"에서 6 보다 큰 숫자중 가장 작은 것은 바로 7이다.
    // 그렇다면 "57" 까지는 완성이 되었고, 그 중에서 가장 앞에 있는 순서가 해당 숫자의 바로 다음 순서가 된다.
    // 가장 앞에 있는 순서는 처음에 말했듯이 오름차순으로만 구성된 숫자이다.
    // 그렇기에 "57" 과 남은 숫자들 "64321"을 오름차순으로 구성하면 된다.
    // 그렇기에 5712346이 5674321의 바로 다음 순서의 숫자가 되는 것이다.

    private static int findSwapIndex(char[] wordArray, int startOfAscend) {
        int swapIndex = startOfAscend + 1;
        int startOrder = wordArray[startOfAscend] - 'A';
        int minOrder = wordArray[startOfAscend + 1] - 'A';

        for (int i = startOfAscend + 1; i < wordArray.length; i++) {
            int targetOrder = wordArray[i] - 'A';
            // 해당 알파벳의 순서가 더 늦으면서, 그 중에서 제일 빠른 순서라면
            if (startOrder < targetOrder && targetOrder < minOrder) {
                swapIndex = i;
            }
        }

        return swapIndex;
    }

    private static int findAscend(char[] wordArray) {
        for (int i = wordArray.length - 1; i > 0; i--) {
            int beforeOrder = wordArray[i - 1] - 'A';
            int nowOrder = wordArray[i] - 'A';

            // 이전 단어의 순서 < 현재 단어의 순서 = 오름차순
            if (beforeOrder < nowOrder) {
                return i - 1;
            }
        }

        return -1;
    }

    private static void findNextWordOrder(String word) {
        char[] wordArray = word.toCharArray();

        // 1. 뒤에서부터 오름차순 찾기
        int startOfAscend = findAscend(wordArray); // 찾으면 index, 못 찾으면 -1 반환

        if (startOfAscend != -1) {
            // 2. 해당 알파벳보다 뒤에 있으면서 제일 빠른 단어를 찾는다.
            int swapIndex = findSwapIndex(wordArray, startOfAscend);

            // 3. swap
            char temp = wordArray[startOfAscend];
            wordArray[startOfAscend] = wordArray[swapIndex];
            wordArray[swapIndex] = temp;

            // 4. 뒤의 알파벳들을 오름차순 정렬
            Arrays.sort(wordArray, startOfAscend + 1, wordArray.length);
        }

        // 출력
        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(wordArray[i]);
        }
        System.out.println();
    }
}