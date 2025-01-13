import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        boolean[] checkList = new boolean[30]; // 알파벳을 체크할 수 있도록 여유롭게 설정
        for (int i = 0; i < N; i++) {
            // 입력 받아서 등록하고, 등록한 결과를 sb에 줄바꿈과 함께 하나씩 추가
            sb.append(register(br.readLine(), checkList) + '\n');
        }

        // 한 번에 출력
        System.out.println(sb);

    }

    private static String register(String newOption, boolean[] checkList) {
        // 1. 단어의 첫 글자로 등록하기
        String[] newOptionToWord = newOption.split(" ");
        for (int wordIdx = 0; wordIdx < newOptionToWord.length; wordIdx++) {
            // 단어의 첫 글자를 추출
            char firstChar = newOptionToWord[wordIdx].charAt(0);
            int index = 0;

            // 대문자로 변환 (A: 65 /a: 97)
            if (firstChar >= 'a') {
                index = firstChar - 'a';
            } else {
                index = firstChar - 'A';
            }

            // 단축키로 등록되어 있지 않다면 등록하기
            if (!checkList[index]) { // 아직 등록되지 않았다면(false)
                checkList[index] = true;
                return registerOption(newOptionToWord, wordIdx);
            }
        }

        // 2. 단어의 첫 글자를 제외한 글자로 등록하기
        for (int wordIdx = 0; wordIdx < newOptionToWord.length; wordIdx++) {
            char[] word = newOptionToWord[wordIdx].toCharArray();

            // 첫 글자는 제외 -> j = 1
            for (int charIdx = 1; charIdx < word.length; charIdx++) {
                int index = 0;

                // 대문자로 통일
                if (word[charIdx] >= 'a') {
                    index = word[charIdx] - 'a';
                } else {
                    index = word[charIdx] - 'A';
                }

                // 단축키로 등록되어 있지 않다면 등록하기
                if (!checkList[index]) {
                    checkList[index] = true;
                    return registerOption(newOptionToWord, wordIdx, charIdx);
                }
            }
        }

        // 3 그냥 등록하기
        return newOption;
    }

    // 1. 단어의 첫 글자를 단축키로 등록하기
    private static String registerOption(String[] newOption, int wordIdx) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < newOption.length; i++) {
            if (wordIdx == i) {
                sb.append("[");
                sb.append(newOption[wordIdx].charAt(0)); // 단어의 첫 글자를 추가
                sb.append("]");

                // 나머지 글자를 추가
                for (int k = 1; k < newOption[i].length(); k++) {
                    sb.append(newOption[i].charAt(k));
                }

                // 띄어쓰기 추가
                sb.append(" ");
            } else {
                sb.append(newOption[i]);
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    // 2. 단어의 첫 글자를 제외한 글자를 단축키로 등록하기
    private static String registerOption(String[] newOption, int wordIdx, int charIdx) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < newOption.length; i++) {
            if (i == wordIdx) {
                // 해당 글자를 만나기 전까지 추가
                for (int j = 0; j < charIdx; j++) {
                    sb.append(newOption[i].charAt(j));
                }

                // 단축키를 추가
                sb.append("[");
                sb.append(newOption[wordIdx].charAt(charIdx)); // 단어의 인덱스(charIdx)에 해당하는 글자를 추가
                sb.append("]");

                // 나머지 글자를 추가
                for (int j = charIdx + 1; j < newOption[i].length(); j++) {
                    sb.append(newOption[i].charAt(j));
                }

                // 띄어쓰기 추가
                sb.append(" ");
            } else {
                sb.append(newOption[i]);
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}