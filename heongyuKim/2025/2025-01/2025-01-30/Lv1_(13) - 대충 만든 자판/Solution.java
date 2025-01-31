class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int result = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int count = 10001;
                for (int w = 0; w < keymap.length; w++) {
                    for (int q = 0; q < keymap[w].length(); q++) {
                        if (targets[i].charAt(j) == keymap[w].charAt(q)) {
                            count = Math.min(q + 1, count);
                            break;
                        }
                    }
                }
                result += count;
            }
            
            if (result >= 10001) {
                answer[i] = -1;    
            } else {
                answer[i] = result;
            }
        }

        return answer;
    }
}