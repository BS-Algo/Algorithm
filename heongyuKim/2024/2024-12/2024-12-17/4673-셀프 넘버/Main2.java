public class Main2 {
    public static void main(String[] args) {
        // 생성자를 체크할 리스트 만들기
        boolean[] generators = new boolean[10001];

        // 1부터 10000까지 돌면서 생성자를 계산하여 체크하기
        for (int i = 1; i < 10001; i++) {
            if (i < 10) {
                generators[i + i] = true;
            } else {
                int generator = 0;
                generator += i;
                String str = String.valueOf(i);
                for (char st : str.toCharArray()) {
                    generator += Character.getNumericValue(st);
                }
                if (generator < 10001) {
                    generators[generator] = true;
                }
            }
        }
        
        // 셀프 넘버 출력하기
        StringBuilder sb = new StringBuilder();
        
        for (int e = 1; e < 10001; e++) {
            if (!generators[e]) {
                sb.append(e).append('\n');
            }
        }

        System.out.println(sb);
    }
}
