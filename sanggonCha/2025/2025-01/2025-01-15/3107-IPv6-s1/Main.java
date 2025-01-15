import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        String beforeSplit = br.readLine();

        // :: 을 찾아서 대치
        beforeSplit = beforeSplit.replace("::", ":zero:");

        // split으로 나누기
        String[] input = beforeSplit.split(":");

        for (int i = 0; i < input.length; i++) {
            int zeroCount = 4 - input[i].length();
            // 0이 부족한 개수만큼 추가
            if (zeroCount != 4) {
                for (int j = 0; j < zeroCount; j++) {
                    sb.append('0');
                }
                sb.append(input[i]);
                if (i != input.length - 1) {
                    sb.append(':');
                }
            }
        }

        // 이미 39(숫자 32 + 콜론 7)자리가 완성 됐다면, zero만 바로 대치
        if (sb.length() == 39) {
            String result = sb.toString().replace("zero", "0000");
            sb = new StringBuilder(result);
            // 39자리보다 짧다면 부족한 만큼 00000을 추가
        } else {
            String[] result = sb.toString().split(":"); // sb를 result에 split해서 저장
            sb.setLength(0); // sb를 새로 만들기 위해 초기화
            for (int i = 0; i < result.length; i++) {
                // 해당 부분이 생략된 zero 라면
                if (result[i].equals("zero")) {
                    // 만약 마지막 부분이라면
                    if (i == result.length - 1) {
                        // 0000:을 추가하고
                        for (int j = 0; j < 8 - result.length; j++) {
                            sb.append("0000:");
                        }
                        // 마지막에는 0000만 추가
                        sb.append("0000");
                    } else {
                        // result.length 중 한 개는 zero이므로 + 1
                        for (int j = 0; j < 8 - result.length + 1; j++) {
                            sb.append("0000:");
                        }
                    }
                } else {
                    sb.append(result[i]);
                    if (i != result.length - 1) {
                        sb.append(':');
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}