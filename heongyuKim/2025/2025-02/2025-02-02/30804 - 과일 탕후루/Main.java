import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    static int result = 0;
    static int[] tangHooRoo;
    static HashMap<Integer, Integer> tangHooRooMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        tangHooRoo = new int[count];

        for (int i = 0; i < count; i++) {
            tangHooRoo[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;

        for (int right = 0; right < count; right++) {

            tangHooRooMap.put(tangHooRoo[right], tangHooRooMap.getOrDefault(tangHooRoo[right], 0) + 1);

            while (tangHooRooMap.size() > 2) {
                tangHooRooMap.put(tangHooRoo[left], tangHooRooMap.get(tangHooRoo[left]) - 1);

                if (tangHooRooMap.get(tangHooRoo[left]) == 0) {
                    tangHooRooMap.remove(tangHooRoo[left]);
                }

                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);

    }
}