import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사이클을 계산할 수
        int N = sc.nextInt();
        sc.close();

        int cp = N;
        int result = 0;

        while (true) {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            result++;

            if (N == cp) {
                break;
            }

        }
        System.out.println(result);

    }
}
