import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연두의 영어 이름
        String yeonduName = br.readLine();

        int nameCount = Integer.parseInt(br.readLine());

        // 후보의 정렬하여 저장할 hashmap
        HashMap<String, Integer> candidates = new HashMap<>();

        // 확률을 계산할 배열
        int[] nums = new int[4];

        for (int i = 0; i < nameCount; i++) {
            String candidate = br.readLine();

            // 연두의 이름에서 love 찾기
            for (int p = 0; p < yeonduName.length(); p++) {
                if (yeonduName.charAt(p) == 'L') {
                    nums[0]++;
                } else if (yeonduName.charAt(p) == 'O') {
                    nums[1]++;
                } else if (yeonduName.charAt(p) == 'V') {
                    nums[2]++;
                } else if (yeonduName.charAt(p) == 'E') {
                    nums[3]++;
                }
            }

            // 첫번째부터 체크
            for (int q = 0; q < candidate.length(); q++) {
                if (candidate.charAt(q) == 'L') {
                    nums[0]++;
                } else if (candidate.charAt(q) == 'O') {
                    nums[1]++;
                } else if (candidate.charAt(q) == 'V') {
                    nums[2]++;
                } else if (candidate.charAt(q) == 'E') {
                    nums[3]++;
                }
            }

            // 확률 계산하기
            int probability = calculateCandidate(nums);
            
            // 정렬한 이름과 확률 저장
            candidates.put(candidate, probability);
            Arrays.fill(nums, 0);
        }

        // 후보의 이름과 확률을 기준으로 내림차순으로 정렬하기
        List<Map.Entry<String, Integer>> list = new ArrayList<>(candidates.entrySet());
        list.sort((o1,o2) -> {
            // 값으로 내림차순 정렬
            int valueCompare = o2.getValue().compareTo(o1.getValue());

            // 값이 같으면 키로 오름차순 정렬
            if (valueCompare == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }

            return valueCompare;
        });

        System.out.println(list.get(0).getKey());

    }

    public static int calculateCandidate(int[] nums) {
        // 나머지를 구할 수
        int devidedNum  = 1;

        // 공식대로 계산
        for (int a = 0; a < nums.length-1; a++) {
            for (int x = a+1; x < nums.length; x++) {
                devidedNum = devidedNum * (nums[a] + nums[x]);
            }
        }

        // 100으로 나눈 나머지 구하기
        return devidedNum % 100;
    }


}
