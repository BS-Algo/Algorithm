import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크레인 입력
        int N = Integer.parseInt(br.readLine());
        int[] crane = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        // 박스 입력
        int M = Integer.parseInt(br.readLine());
        LinkedList<Integer> boxes = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(crane); // 크레인 오름차순
        boxes.sort(Collections.reverseOrder()); // 박스 내림차순

        // 가장 무거운 박스를 가장 센 크레인이 못 들면 불가능
        if (crane[N - 1] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0;
            for (int i = N - 1; i >= 0;) {
                if (boxIdx >= boxes.size()) break;

                if (crane[i] >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    i--; // 다음 크레인
                } else {
                    boxIdx++; // 다음 박스
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
