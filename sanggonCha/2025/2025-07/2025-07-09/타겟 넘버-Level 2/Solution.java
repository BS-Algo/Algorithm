class Solution {
    static int count = 0, staticTarget;

    public int solution(int[] numbers, int target) {
        staticTarget = target;

        dfs(numbers, 0, 0);

        return count;
    }

    private static void dfs(int[] numbers, int index, int now) {
        if (index == numbers.length) {
            if (now == staticTarget) {
                count++;
            }
            return;
        }

        dfs(numbers, index + 1, now + numbers[index]);
        dfs(numbers, index + 1, now - numbers[index]);
    }
}