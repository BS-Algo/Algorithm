import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 생성자를 담을 리스트 만들기
        ArrayList<Integer> generators = new ArrayList<>();

        // 1부터 10000까지 돌면서 생성자를 계산하여 리스트에 넣기
        for (int i = 1; i < 10000; i++) {
            if (i < 10) {
                generators.add(i + i);
            } else {
                int generator = 0;
                generator += i;
                String str = String.valueOf(i);
                for (char st : str.toCharArray()) {
                    generator += Character.getNumericValue(st);
                }
                generators.add(generator);
            }
        }

        // 생성자가 아닌 경우 출력
        for (int e = 1; e < 10000; e++) {
            if (!generators.contains(e)) {
                System.out.println(e);
            }
        }

    }
}
