class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            // 갈 수 있는 거리 d에서 i만큼의 길이를 이미 사용했으면
            // 사용할 수 있는 남은 거리는 루트(d^2 - i^2) 보다 작거나 같다
            // 범위를 초과할 수 있으므로 long으로 감싸야함
            int cnt = (int) Math.sqrt(((long) d * d - (long) i * i)) / k; // k의 배수

            answer += cnt + 1; // 0콤마 포함
        }

        return answer;
    }
}