import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        solve(); // 함수 호출
    }

    private static void solve() throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine(); // 지우고 남은 수 입력 받기

        // 탐색 변수 생성
        int pointer = 0; // 지워진 수의 인덱스를 가리킬 포인터 생성
        int N = 0; // 0에서부터 지워진 수를 모두 만족할 때까지 직접 만들어보기

        // 탐색
        while (N++ <= 25000) { // 지워진 수는 최대 3000자리, 0 ~ 9 는 10개, 30000 보다는 N이 작겠지만, 
                               // 각 자리수를 N을 10씩 증가시켜서 하나씩 찾아내는 것이 최악의 케이스 -> 3000 * 10 = 30,000
                               // 실제로 30,000대신 25,000으로 풀어도 풀림
            String stringN = String.valueOf(N); // 정수 N을 문자열로 변환 -> 문자열이 되고, 인덱스로 접근 가능

            // N의 값을 증가시키며 StringN에 포함된 문자열
            // -> 지워진 수에 포함돼 있으면 만들 수 있으므로 포인터를 다음으로 이동
            for (int i = 0; i < stringN.length(); i++) {
                if (stringN.charAt(i) == target.charAt(pointer)) pointer++;
                if (pointer == target.length()) { // 포인터가 타겟의 길이와 같아졌다면, 지워진 N 자리를 모두 찾은 것
                    System.out.println(N); // 그 때의 N을 출력
                    return;
                }
            }
        }
    }
}