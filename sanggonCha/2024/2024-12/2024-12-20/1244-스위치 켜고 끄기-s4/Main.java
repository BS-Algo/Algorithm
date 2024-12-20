import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchN = Integer.parseInt(br.readLine());

        String[] switchesString = br.readLine().split(" ");
        int[] switches = new int[switchN];
        for (int i = 0; i < switchN; i++) {
            switches[i] = Integer.parseInt(switchesString[i]);
        }

        int studentN = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentN; i++) {
            String[] studentInfo = br.readLine().split(" ");
            int switchNumber = Integer.parseInt(studentInfo[1]);

            if (studentInfo[0].equals("1")) { // 남학생
                for (int j = switchNumber - 1; j < switchN; j += switchNumber) {
                    if (switches[j] == 0) {
                        switches[j] = 1;
                    } else {
                        switches[j] = 0;
                    }
                }
            } else { // 여학생
                if (switches[switchNumber - 1] == 1) {
                    switches[switchNumber - 1] = 0;
                } else {
                    switches[switchNumber - 1] = 1;
                }
                int k = 1;
                while (switchNumber - 1 - k >= 0 && switchNumber - 1 + k < switchN) {
                    if (switches[switchNumber - 1 - k] == switches[switchNumber - 1 + k]) {
                        if (switches[switchNumber - 1 - k] == 1) {
                            switches[switchNumber - 1 - k] = 0;
                            switches[switchNumber - 1 + k] = 0;
                        } else {
                            switches[switchNumber - 1 - k] = 1;
                            switches[switchNumber - 1 + k] = 1;
                        }
                    } else {
                        break;
                    }
                    k++;
                }
            }
        }

        for (int i = 0; i < switchN; i++) {
            if (i != 0 && i % 20 == 0) {
                System.out.println();
            }
            System.out.printf("%d ", switches[i]);
        }
    }
}