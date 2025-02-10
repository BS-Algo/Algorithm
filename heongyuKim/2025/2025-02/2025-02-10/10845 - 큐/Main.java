import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 커맨드 수
        int count = Integer.parseInt(br.readLine());

        // queue 생성
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < count; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            String command = info.nextToken();

            switch (command) {
                case "push":
                    last = Integer.parseInt(info.nextToken());
                    queue.add(last);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        int popNum = queue.poll();
                        System.out.println(popNum);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    int isEmpty = queue.isEmpty() ? 1 : 0;
                    System.out.println(isEmpty);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : last);
                    break;
            }
        }

    }


}