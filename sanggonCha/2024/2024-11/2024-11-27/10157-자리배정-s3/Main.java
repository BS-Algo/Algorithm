import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int c = Integer.parseInt(rc[0]);
        int r = Integer.parseInt(rc[1]);
        int k = Integer.parseInt(br.readLine());
        int i = 1;
        int j = 1;

        if (r * c < k) {
            System.out.println(0);
        } else {

            while (k > 2 * r + 2 * c - 4) {
                k = k - (2 * r + 2 * c - 4);
                r -= 2;
                c -= 2;
                i += 1;
                j += 1;
            }

//            System.out.printf("%d %d %d %d %d\n", r,c,i,j,k);
            ans(r, c, i, j, k - 1);
        }
    }

    public static void ans(int r, int c, int i, int j, int k) {
        int rCopy = r;
        int cCopy = c;

//        System.out.printf("시작 위치: %d %d\n", i, j);

        while (k > 0 && r - 1 > 0) { // 위로 이동
            k -= 1;
            r -= 1;
            j += 1;
//            System.out.printf("위로 이동: %d %d %d\n", i,j, r);
        }

        while (k > 0 && c - 1 > 0) { // 오른쪽으로 이동
            k -= 1;
            c -= 1;
            i += 1;
//            System.out.printf("오른쪽으로 이동: %d %d %d\n", i,j, c);
        }

        while (k > 0 && rCopy - 1 > 0) { // 아래로 이동
            k -= 1;
            rCopy -= 1;
            j -= 1;
//            System.out.printf("아래로 이동: %d %d %d\n", i,j, r);
        }

        while (k > 0 && cCopy - 1 > 0) { // 왼쪽으로 이동
            k -= 1;
            cCopy -= 1;
            i -= 1;
//            System.out.printf("왼쪽으로 이동: %d %d %d\n", i,j, r);
        }

        System.out.printf("%d %d", i, j);
    }
}