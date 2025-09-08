#include <string>
#include <vector>
#include <algorithm>

using namespace std;
// 1개이상 단위로 잘라서 가장 짧은 길이의 문자열을 완성
// 반틈 잘라서 압축할수있는지 비교, 만약 압축이 된다면 문자열 길이를 구해서 리스트에 추가
// 반틈 자른 거를 한개씩 줄여가면서 비교, 일치하지 않으면 바로 continue

int solution(string s) {
    int n = s.size();
    if(n==1) return 1;
    
    int answer = n;
    //step을 한개씩 줄여가면서 비교
         
    for(int step = 1; step <= n/2; step++){
        string compressed = "";
        // 비교할 문자열
        string prev = s.substr(0,step); // 0부터 step만큼
        int count = 1;
        
        for(int j = step; j<n;j+=step){
            string curr = s.substr(j,step); // j부터 step만큼
            // 일치하면 반복되는 만큼 횟수 추가
            if(prev == curr){
                count++;
            } else {
                // 반복되는 횟수만큼 압축시켜야함 그러고 카운트 만큼 앞에 숫자를 string으로 변환해서 붙여야함
                if(count > 1) compressed += to_string(count);
                compressed += prev;
                prev = curr;
                count = 1;
            }
        }
        
        if(count > 1) compressed += to_string(count);
        compressed += prev;
        
        answer = min(answer, (int)compressed.size());
    }
    
    
    return answer;
}