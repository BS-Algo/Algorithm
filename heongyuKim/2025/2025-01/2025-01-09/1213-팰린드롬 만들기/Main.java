import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder result = new StringBuilder();

        int[] alphabetCount = new int[26];

        // 알파벳 갯수 적기
        for (int i = 0; i < input.length(); i++) {
            char alphabet = input.charAt(i);
            alphabetCount[alphabet - 'A']++;
        }

        // 홀수인 알파벳 찾기
        int isodd = 0;
        for (int count : alphabetCount) {
            if (count % 2 != 0) {
                isodd++;
            }
        }

        // 만약 홀수갯수인 알파벳이 2개 이상이면 팰린드롬 불가능
        if (isodd > 1) {
            result.append("I'm Sorry Hansoo");
        } else {
            // 앞 부분
            StringBuilder front = new StringBuilder();

            // 중간 부분
            StringBuilder mid = new StringBuilder();


            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabetCount[i]/2; j++) {
                    front.append((char) (i+65));
                }
                
            }

            for (int r = 0; r < 26; r++) {
                if (alphabetCount[r] % 2 == 1) {
                    mid.append((char) (r + 65));
                }
            }

            result.append(front).append(mid);
            // 뒷부분은 뒤집어서 저장
            result.append(front.reverse());
        }

        System.out.println(result.toString());
    }
}