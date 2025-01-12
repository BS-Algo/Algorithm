class Main {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) { 
        // 결과로 출력할 변수
        String answer = "";
        
        String[] videoMinAndSec = video_len.split(":");
        String[] posMinAndSec = pos.split(":");
        String[] opStartMinAndSec = op_start.split(":");
        String[] opEndMinAndSec = op_end.split(":");
        
        // 초로 통일시켜서 계산하기
        // 비디오 길이 초로 바꾸기
        int videoSec = convertSec(Integer.parseInt(videoMinAndSec[0]), Integer.parseInt(videoMinAndSec[1]));
        // 현재 시작 위치 초로 바꾸기
        int posSec = convertSec(Integer.parseInt(posMinAndSec[0]), Integer.parseInt(posMinAndSec[1]));
        // 오프닝 시작 위치 끝 위치 초로 바꾸기
        int opStartSec = convertSec(Integer.parseInt(opStartMinAndSec[0]), Integer.parseInt(opStartMinAndSec[1]));
        int opEndSec = convertSec(Integer.parseInt(opEndMinAndSec[0]), Integer.parseInt(opEndMinAndSec[1]));
        
        
        // 명령어에 따라서 처리
        // 남은 시간이 10초 미만인 경우 이전 버튼일 경우 0분 0초
        // 다음 버튼일 경우 영상 마지막 위치
        for (int i = 0; i < commands.length; i++) {
            int nextSec = 0;
            int prevSec = 0;
            
            // 오프닝 위치인지 확인해서 오프닝 위치면 오프닝 끝나는 위치로 이동시키기
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
            
            if (commands[i].equals("next")) {
                // 10초 후 비디오 시간
                nextSec = posSec + 10;
                // 만약 남은 비디오 시간이 10초도 안남으면 비디오 끝 지점으로 이동
                if (videoSec - nextSec < 10) {
                    posSec = videoSec;
                } else {
                    posSec = nextSec;
                }

            } else {
                // 10초 전 비디오 시간
                prevSec = posSec - 10;
                // 만약 10초도 안지났으면 비디오 처음 지점으로 이동
                if (prevSec < 10) {
                    posSec = 0;
                } else {
                    posSec = prevSec;
                }
            }
            
            // 명령 후에도 오프닝 위치인지 확인해서 오프닝 위치면 오프닝 끝나는 위치로 이동시키기
            if (opStartSec <= posSec && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }
       
        
        // 결과로 나온 초를 분과 초로 계산
        int posMin = posSec / 60;
        int posCalSec = posSec % 60;
        
        // 삼항 연산자
        answer += posMin < 10 ? "0" + posMin + ":" : posMin + ":";
        answer += posCalSec < 10 ? "0" + posCalSec : posCalSec;
    
        return answer;
    }
    
    static int convertSec(int min, int sec) {
        int result = (min * 60) + sec;
        
        return result;
    }
}