import java.util.*;

class Main {
    public int solution(int[] mats, String[][] park) {
        // mat의 길이가 뒤죽박죽이므로 길이를 오름차순으로 정렬해야함
        Arrays.sort(mats);
        
        // 결과로 출력할 값
        int answer = -1;
    
        // mat의 길이에 따른 체크
        for (int i = 0; i < mats.length; i++) {
            int matLength = mats[i];
            
            // 공원의 범위를 넘지 않는 선에서 확인
            for (int j = 0; j <= park.length - matLength; j++) {
                for (int q = 0; q <= park[0].length - matLength; q++) {
                    boolean isMat = true;
                    
                    for (int k = 0; k < matLength; k++) {
                        for (int w = 0; w < matLength; w++) {
                            if (!park[j + k][q + w].equals("-1")) {
                                isMat = false;
                            }
                        }    
                    }
                    
                    if (isMat) {
                       answer = matLength; 
                    }
                                    
                }
            }   
        }
        
        return answer;
    }
}