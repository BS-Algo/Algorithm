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

    // N = 3 이라고 생각
    private static void hanoi(int N, int from, int to, int sub) { // hanoi(3, 1, 3, 2)
        if (N == 0) return; // 더 이상 옮길 원판이 없으면 종료 - N = 0일 때 종료

        // 1. N-1개를 from에서 sub로 올기기
        hanoi(N - 1, from, sub, to); 
        // hanoi(2, 1, 2, 3)
        // hanoi(1, 1, 3, 2)

        // 2. N번째 원판 이동 기록
        sb.append(from).append(' ').append(to).append('\n');
        // 1 3 기록: 크기 1의 원판이 1에서 3으로 이동
        
        // 이동횟수 추가
        count++; 

        // 3. N-1개를 sub에서 to로 옮기기
        hanoi(N - 1, sub, to, from); 
        // hanoi(2, 2, 3, 1) - 2

    }
}