#include <string>
#include <vector>
#include <unordered_map>

using namespace std;
// 이름이 나오면 그사람의 등수가 1증가하고 1증가한 등수에있던 사람이 이름 나온사람의 등수로감
// 1등부터 현재 등수 가 적힌 배열, 해설진이 부른 배열이 주어질때 경주가 끝났을때 1등부터 배열

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    answer = players;
    // 1. 먼저 불린 이름을 순서대로 가져옴
    // 2. 불린 이름을 players에서 for문으로 찾음
    // 3. index를 알고 i-1이랑 i랑 서로 바꿈
    // 위 방법은 시간초과, index를 부여해줘야 하나?
    
    // for(int i = 0;i<callings.size();i++){
    //     for(int j = 0;j<answer.size();j++){
    //         if(callings[i]==answer[j]){
    //             string temp;
    //             temp = answer[j-1];
    //             answer[j-1] = answer[j];
    //             answer[j] = temp;
    //             continue;
    //         }
    //     }
    // }
    unordered_map<string,int> rank;
    for(int i = 0;i<players.size();i++){
        rank[players[i]] = i;
    }
    
    for(auto &name : callings){
        int cur = rank[name];
        int front = cur - 1;
        
        string frontPlayer = players[front];
        players[front] = players[cur];
        players[cur] = frontPlayer;
        
        rank[name] = front;
        rank[frontPlayer] = cur;
    }
    
    return players;
}