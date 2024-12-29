import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
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
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(arrayList.getLast()).append('\n');
                        arrayList.removeLast();
                    }
                    break;
                case "size":
                    sb.append(arrayList.size()).append('\n');
                    break;
                case "empty":
                    if (arrayList.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "top":
                    if (arrayList.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(arrayList.getLast()).append('\n');
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
