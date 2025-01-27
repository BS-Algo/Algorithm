class Solution {
    public String solution(String X, String Y) {
        int[] arrayX = new int[10];
        int[] arrayY = new int[10];

        // X의 각 숫자 빈도 계산
        for (char x : X.toCharArray()) {
            arrayX[x - '0']++;
        }

        // Y의 각 숫자 빈도 계산
        for (char y : Y.toCharArray()) {
            arrayY[y - '0']++;
        }

        // 공통 숫자를 내림차순으로 결과에 추가
        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(arrayX[i], arrayY[i]); // 공통된 숫자의 최소 빈도
            while (count-- > 0) {
                result.append(i); // 공통 숫자 추가
            }
        }

        // 결과가 비어 있으면 -1 반환
        if (result.length() == 0) {
            return "-1";
        }

        // 결과가 0으로만 구성되어 있으면 0 반환
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}