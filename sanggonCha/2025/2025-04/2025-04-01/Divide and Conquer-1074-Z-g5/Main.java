import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0, n, r, c;
    static int[] di = {0, 0, 1, 1}, dj = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        recursion(size, 0, 0);
    }

    private static void recursion(int size, int i, int j) {
        if (size == 2) {
            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (ni == r && nj == c) {
                    System.out.println(cnt);
                    return;
                } else {
                    cnt++;
                }
            }
            return;
        }

        int half = size / 2;
        int area = half * half;

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k] * half;
            int nj = j + dj[k] * half;

            if (r >= ni && r < ni + half && c >= nj && c < nj + half) {
                // r, c가 이 사분면에 있으면 → 해당 사분면 재귀
                recursion(half, ni, nj);
                return;
            } else {
                // 아니라면 cnt 건너뜀
                cnt += area;
            }
        }
    }
}
