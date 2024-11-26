import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = (int) line.charAt(j) - 48;
            }
        }

        int maxK = 0;
        int ans = 1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int k = 1;
                while (i + k < n && j + k < m) {
                    if (arr[i][j] == arr[i][j+k] && arr[i][j+k] == arr[i+k][j+k] && arr[i+k][j+k] == arr[i+k][j]) {
                        if (k > maxK) {
                            maxK = k;
                        }
                        ans = (maxK+1)*(maxK+1);
                    }
                    k += 1;
                }
            }
        }
        System.out.println(ans);
    }
}
