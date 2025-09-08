#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
// stoi 
// 오른쪽 알파벳이 A면 왼쪽으로 가기 
using namespace std;

int solution(string name) {
    int answer = 0;
    int n = name.size();
    
    for(int i = 0;i<n;i++){
        int up = name[i] - 'A';
        int down = 'Z' - name[i] + 1;
        answer += min(up,down);
    }
    
    int move = n - 1;
    for(int i = 0;i<n;i++){
        int next = i+1;
        while(next < n && name[next] == 'A'){
            next++;
        }
        move = min(move,i+n-next+min(i,n-next));
    }
    answer += move;
        
    
    
    
    
    return answer;
}