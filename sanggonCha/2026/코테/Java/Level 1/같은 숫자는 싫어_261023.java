import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]); // 첫 번째 원소 insert
        
        int before = arr[0]; // 이전 숫자와 비교할 변수
        int now; // 현재 숫자를 저장할 변수
        for (int i = 1; i < arr.length; i++) {
            now = arr[i]; // 현재 숫자 저장
            
            if (before != now) { // 이전 숫자와 다르면
                list.add(now); // insert
            }
            
            before = now;
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);   
        }
        
        return answer;
    }
}