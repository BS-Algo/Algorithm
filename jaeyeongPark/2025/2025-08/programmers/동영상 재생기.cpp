#include <string>
#include <vector>
#include <iostream>

using namespace std;
// prev는 10초전, 10초 미만인 경우 영상 처음으로
// next는 10초 후, 남은 시간이 10초미만이면 마지막으로(동영상 길이랑 같음)
// 현재 위치가 오프닝구간이면 오프닝이 끝나는 위치로 이동
// video_len : 영상길이, 기능 수행직전 위치 : pos, 사용자 입력 : commands
// 사용자의 입력이 모두 끝난 후 위치를 "mm:ss" 형식으로 리턴

// 풀이방법 : 전부 초로 바꿔서 계산후 다시 문자열로 변환하기
// 함수 두개만들기 초로 바꾸는 것과 문자열로 변환하는 함수

//"mm:ss" 형식을 초 단위 정수로 변환
int to_seconds(const string &time_str){
    int mm = stoi(time_str.substr(0,2));
    int ss = stoi(time_str.substr(3,2));
    return mm * 60 + ss;
}

// 답에 맞는 형식 string 으로 변환
string to_mmss(int total_seconds){
    int mm = total_seconds / 60;
    int ss = total_seconds % 60;
    // 10보다 작으면 앞에 0이 들어가야함 10보다 크면 필요없음
    string mm_str = (mm < 10 ? "0":"")+to_string(mm);
    string ss_str = (ss < 10 ? "0":"")+to_string(ss);
    return mm_str + ":" + ss_str;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    int current = to_seconds(pos);
    int video_end = to_seconds(video_len);
    int opening_start = to_seconds(op_start);
    int opening_end = to_seconds(op_end);
    
    // 현재 오프닝이면 오프닝 뒤에서 부터 시작, 건뛰
    if(current >= opening_start && current <= opening_end){
        current = opening_end;
    }
    
    for(const string &cmd : commands){
        if(cmd == "prev"){
            current -= 10;
            // 시작지점으로 가기 
            if(current < 0) current = 0;
        } else if( cmd == "next"){
            current += 10;
            if(current > video_end) current = video_end;
        }
        //이동후에도 오프닝구간이면 건뛰
        if(current >= opening_start && current <= opening_end){
            current = opening_end;
        }
    }

    return to_mmss(current);
}