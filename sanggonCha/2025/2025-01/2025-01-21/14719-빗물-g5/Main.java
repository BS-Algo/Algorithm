import java.io.*;

// 문제의 해법은 가장 높은 높이를 구하고, 그것을 두 개의 영역으로 나누어서 따로 구하는 것이다.
// 그리고 투 포인터(left, right)를 사용해서 구간들의 부분합들을 구하고 그것을 누적합 한다.
// 이렇게 생각 하게 된 계기는,,, 그냥 그려 보다가 알게 됐다..

// left -> 최대 높이까지를 생각해보자.
// 빗울은 언제 결졍될까?
// 왼쪽 블록과 그리고 본인보다 같거나 높은 오른쪽 블록을 만나는 순간 결정된다.

// 따라서 인덱스 0 -> 최대 높이 인덱스 구간 안에서 살펴 보되,
// left 블록 보다 높은 블록을 만날 때까지 계속 right를 증가시키고,
// 만나면 여태까지의 구간(left -> right)에 고일 빗물을 계산하고,
// 그 다음 다시 left = right로 갱신한다.

// 최대 높이 인덱스 ~ right 구간은 대칭이되 방식은 똑같이 진행하면 된다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // H, W 입력 받기
        String[] HW = br.readLine().split(" ");
        int H = Integer.parseInt(HW[0]); // H는 사실 필요 없음
        int W = Integer.parseInt(HW[1]);

        String[] heightsString = br.readLine().split(" ");
        int[] heights = new int[W];

        // 블록 입력 받기
        int maxIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(heightsString[i]);
            if (maxHeight < heights[i]) {
                maxHeight = heights[i];
                maxIndex = i;
            }
        }

        // 왼쪽 -> 최대 높이
        int water = 0;
        int left = 0, right = 1;
        while (left < maxIndex) {
            // left 블록보다 높은 블록을 찾을 때까지 right 왼쪽으로 이동
            while (heights[left] > heights[right] && right < maxIndex) {
                right++;
            }
            // 둘 중 더 낮은 블록만큼 물이 고임
            int waterHeight = Math.min(heights[left], heights[right]);
            // left -> right 까지 물 높이 누적합
            for (int i = left + 1; i < right; i++) {
                water += waterHeight - heights[i];
            }
            left = right;
            right++;
        }

        // 오른쪽 -> 최대 높이
        left = W - 2;
        right = W - 1;
        while (left > maxIndex) {
            // right의 블록보다 높은 블록을 찾을 때까지 left를 왼쪽으로 이동
            while (heights[left] < heights[right] && left > maxIndex) {
                left--;
            }
            // 둘 중 더 낮은 블록만큼 물이 고임
            int waterHeight = Math.min(heights[left], heights[right]);
            // right -> left 까지 물 높이 누적합
            for (int i = right - 1; i > left; i--) {
                water += waterHeight - heights[i];
            }
            right = left;
            left--;
        }

        System.out.println(water);
    }
}