class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int currentIdx1 = 0;
        int currentIdx2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if (currentIdx1 < cards1.length && cards1[currentIdx1].equals(goal[i])) {
                currentIdx1++;
                continue;
            }
            
            if (currentIdx2 < cards2.length && cards2[currentIdx2].equals(goal[i])) {
                currentIdx2++;
                continue;
            }
            
            return "No";
        }
        
        
        return "Yes";
    }
}