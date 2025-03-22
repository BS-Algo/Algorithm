import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 난이도가 높아질수록 정렬 기준과 생각해야할 부분이 늘어서나서 너무 어려워진다... 이것도 다시 풀어보자...
class Main {
    // 배송 정보를 담을 배열
    static int[][] arr;

    // 배달 할 마을과 양을 담을 배열
    static int[] delivery;

    // 결과
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer townAndTruck = new StringTokenizer(br.readLine());

        // 마을
        int town = Integer.parseInt(townAndTruck.nextToken());
        
        // 트럭 용량
        int truckVolume = Integer.parseInt(townAndTruck.nextToken());

        // 보낼 박스의 정보 갯수
        int M = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[M + 1][3];

        // 배열에 배송 정보 넣기
        for (int i = 1; i <= M; i++) {
            StringTokenizer info = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(info.nextToken());
            int end = Integer.parseInt(info.nextToken());
            int volume = Integer.parseInt(info.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
            arr[i][2] = volume;
        }

        // 정렬하기 - 이렇게 정렬하면 순서가 뒤죽박죽으로 오기 때문에 아래의 로직에서 택배를 순서대로 처리하면 너무 복잡함.
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        // 배달 할 마을과 양을 담을 배열 생성
        delivery = new int[town + 1];

        for (int i = 1; i < town; i++) {
            delivery[i] = truckVolume;
        }

        // 구간별로 옮길 수 있는 양을 차감하는 방식 - 이동 구간에서 옮길 수 있는 최대량(최솟값으로 구할 수 있음)을 차감하는 식으로 처리
        for (int i = 1; i <= M; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            int volume = arr[i][2];

            int max =Integer.MAX_VALUE;

            for (int j = start; j < end; j++) {
                max = Math.min(max, delivery[j]);
            }

            if (max >= volume) {
                for (int j = start; j < end; j++) {
                    delivery[j] -= volume;
                }
                result += volume;
            } else {
                for (int j = start; j < end; j++) {
                    delivery[j] -= max;
                }

                result += max;
            }
        }

        System.out.println(result);
    }
}