import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int count = 0;
        int result = 0;

        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= i; j++) {
                count++;

                if (start <= count && count <= end) {
                    result += i;
                }
            }
        }

        System.out.println(result);
    }
}
