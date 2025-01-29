class Solution {
    static int start;

    public int solution(int n, int m, int[] section) {
        int answer = 1;

        start = section[0];

        for (int i = 0; i < section.length; i++) {
            if (start + m - 1 < section[i]) {
                start = section[i];
                answer++;
            }
        }


        return answer;
    }
}
