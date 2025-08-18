class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int start = 1;
        int end = 100000;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            long cur_limit = times[0];

            for (int i = 1; i < n; i++) {
                int diff = diffs[i];
                int time = times[i];
                int prev_time = times[i - 1];
                
                if (diff <= mid) {
                    cur_limit += time;
                } else {
                    int count = diff - mid;
                    cur_limit += (time + prev_time) * count + time;
                }    
            }
            
            if (cur_limit > limit) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}