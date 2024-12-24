import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 출력을 위한 객체
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int bitset = 0;

        while (num-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int n;

            switch (cmd) {
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (n-1));
                    break;

                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~(1 << (n - 1));
                    break;

                case "check":
                    n = Integer.parseInt(st.nextToken());
                    sb.append((bitset & (1 << (n - 1))) != 0 ? "1\n" : "0\n");
                    break;

                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << (n - 1));
                    break;

                case "all":
                    bitset |= (~0);
                    break;

                case "empty":
                    bitset &= 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
