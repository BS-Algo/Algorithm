class Solution {
    // 제일 위
    static int lux = 51;
    // 제일 왼쪽
    static int luy = 51;
    // 제일 오른쪽
    static int rdx = -1;
    // 제일 아래
    static int rdy = -1;
    
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(i, lux);
                    luy = Math.min(j, luy);
                    rdx = Math.max(i, rdx);
                    rdy = Math.max(j, rdy);
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;


        return answer;
    }
}