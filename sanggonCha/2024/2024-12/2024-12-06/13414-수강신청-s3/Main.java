import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] kl = br.readLine().split(" ");
        int k = Integer.parseInt(kl[0]);
        int l = Integer.parseInt(kl[1]);

        LinkedHashSet<String> studentSet = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            String studentNumber = br.readLine();
            // 중복 제거 부분
            // 기존 링크드해쉬셋은 중복된 값은 추가하지 않는다.
            // 그렇기에 항상 값을 제거한 후에 추가를 하면, 없으면 제거를 하지 않고, 있으면 제거를 한다
            // 따라서 항상 중복된 값은 제일 마지막에 삽입되게 된다.
            studentSet.remove(studentNumber);
            studentSet.add(studentNumber);
        }

        int count = 0;
        for (String student : studentSet) {
            System.out.println(student);
            count++;
            if (count == k) {
                break;
            }
        }
    }
}