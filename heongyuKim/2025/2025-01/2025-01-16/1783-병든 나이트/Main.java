import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로
        int N = Integer.parseInt(st.nextToken());
        // 가로
        int M = Integer.parseInt(st.nextToken());

        // 조건에 따라 분기 처리
        if (N == 1) {
            System.out.println(1);
            return;
        } else if (N == 2) {
            // N이 2일 때는 1번과 4번 방법으로 이동이 불가하므로 방문할 수 있는 칸이 최대 4칸까지 이동까지 가능
            // 하지만 가로의 길이가 7이하인 경우 4번보다 더 적기 때문에 이를 처리해줘야함.
            System.out.println(Math.min(4, ((M + 1) / 2)));
            return;
        } else if (M < 7) {
            // 세로의 길이가 2보다 크면 1번과 4번 방법으로도 이동이 가능하므로 이를 고려하여 처리하기
            System.out.println(Math.min(4, M));
            return;
        } else {
            // 세로의 길이가 2보다 크고 가로의 길이가 7이상이면 그때부터는 모든 방법으로 한번씩 이동을 해야하기 때문에
            // 최소 5칸부터 이동이고 길이가 8부터는 1번과 4번 이동 방식으로 1칸씩 늘어나기 때문에 이를 처리해줘야함.
            System.out.println(M - 2);
            return;
        }
    }
}
