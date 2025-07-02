class Solution {
    public int solution(int[][] sizes) {
        
        int w = 0, h = 0;
        for (int[] size: sizes) {
            if (size[0] > size[1]) {
                w = Math.max(w, size[0]);
                h = Math.max(h, size[1]);
            } else {
                w = Math.max(w, size[1]);
                h = Math.max(h, size[0]);
            }
        }
        
        int answer = w * h;
        return answer;
    }
}