import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] romaNumbers = {1, 5, 10, 50};
        int[] countList = new int[1001];

        countList[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1000; j >= 0; j--) {
                if (countList[j] == 1) {
                    for (int number : romaNumbers) {
                        if ((j + number) >= 0) {
                            countList[j + number] = 1;
                        }
                    }
                    countList[j] = 0; // 합하는 과정에서 생긴 값은 반드시 지워줘야함!!
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 1001; i++) {
            if (countList[i] == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}