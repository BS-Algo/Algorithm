import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nums = Integer.parseInt(bf.readLine());
        
        // 연산할 집합
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());

                if (!set.contains(num)) {
                    set.add(num);
                }

            } else if (command.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());

                if (set.contains(num)) {
                    set.remove(num);
                }
            } else if (command.equals("check")) {
                int num = Integer.parseInt(st.nextToken());

                if (set.contains(num)) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }

            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }

            } else if (command.equals("all")) {
                set.clear();
                set.addAll(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
            } else {
                set.clear();
            }


        }

        bw.flush();
        bw.close();
    }
}
