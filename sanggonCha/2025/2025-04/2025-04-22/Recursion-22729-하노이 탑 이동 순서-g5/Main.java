import java.io.*;

class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int N, int from, int to, int sub) {
        if (N == 0) return; // 더 이상 옮길 원판이 없으면 종료

        hanoi(N - 1, from, sub, to); // N-1개를 from에서 sub로 올기기
        sb.append(from).append(' ').append(to).append('\n'); // N번째 원판 이동 기록
        count++;
        hanoi(N - 1, sub, to, from); // N-1개를 sub에서 to로 옮기기
    }
}