import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 반복 횟수
        int count = Integer.parseInt(br.readLine());

        // 빈 배열 만들기
        LinkedList<Integer> arrayList = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    arrayList.add(num);
                    break;
                case "pop":
                    if (arrayList.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arrayList.getLast());
                        arrayList.removeLast();
                    }
                    break;
                case "size":
                    System.out.println(arrayList.size());
                    break;
                case "empty":
                    if (arrayList.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (arrayList.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(arrayList.getLast());
                    }
                    break;
            }

        }

    }
}
