import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        // 전화벨이 울리는 시간 확인
        for (int t = 0; ; t += D) {
            // 전화벨이 울릴 때 노래가 재생 중인지 확인
            boolean isSongPlaying = false;
            for (int i = 0; i < N; i++) {
                int start = i * (L + 5); // 각 노래의 시작 시간
                if (t >= start && t < start + L) {
                    isSongPlaying = true;
                    break;
                }
            }

            if (!isSongPlaying) {
                System.out.println(t);
                return;
            }
        }

    }
}
