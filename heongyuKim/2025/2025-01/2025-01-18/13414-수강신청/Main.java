import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    // 수강 가능 인원
    static int K;

    // 대기 목록의 길이
    static int L;

    // 학번
    static String studentNum;
    
    // 수강 가능 인원까지 출력을 위한 변수
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 대기 배열 만들기
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 학번 입력 받기
        for (int i = 0; i < L; i++) {
            studentNum = br.readLine();

            if (set.contains(studentNum)) {
                set.remove(studentNum);
            }
            set.add(studentNum);
        }

        // 출력
        for (String s : set) {
            count++;
            System.out.println(s);
            if (count == K) {
             break;
            }
        }

    }
}