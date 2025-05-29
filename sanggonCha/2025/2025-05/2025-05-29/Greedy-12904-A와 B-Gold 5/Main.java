import java.io.*;
import java.util.*;

class Info {
    String str;
    boolean fOrB; // true는 정방향, false는 역방향

    Info(String str, boolean fOrB) {
        this.str = str;
        this.fOrB = fOrB;
    }
}

public class Main {
    private static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        S = br.readLine();
        T = br.readLine();

        // greedy: 역방향으로 접근 - T -> S로
        // A와 B를 추가하는 방법은 한 가지밖에 안 존재함
        // 그렇기에 경로는 한 가지고, 정답도 한 가지만 존재함!
        // 그래서 이 방식으로 풀 수 있는 것
        while (T.length() != S.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1); // A는 바로 제거
            } else {
                T = T.substring(0, T.length() - 1); // B제거(뒤집은 상태라서 젤 뒤에 있음)
                StringBuilder sb = new StringBuilder();
                for (int i = T.length() - 1; i >= 0; i--) {
                    sb.append(T.charAt(i));
                }
                T = sb.toString();
            }
        }

        // 출력
        if(S.equals(T)) System.out.println(1);
        else System.out.println(0);

    }


}