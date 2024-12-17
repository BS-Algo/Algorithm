
public class Main1 {
    public static void main(String[] args) {

        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = generator(i);

            if (n < 10001) {
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int e = 1; e < 10001; e++) {
            if (!check[e]) {
                sb.append(e).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static int generator(int number) {
        int sum = number;

        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }

        return sum;
    }
}
