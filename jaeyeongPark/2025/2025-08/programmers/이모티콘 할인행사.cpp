#include <string>
#include <vector>

using namespace std;

int user_cnt;
int emo_cnt;

vector<vector<int>> g_users;
vector<int> g_emoticons;
vector<int> discount = {10,20,30,40};

pair<int,int> simulate(const vector<int>& applied){
    int plusCnt = 0;
    int totalSales = 0;
    
    for(const auto&user : g_users){
        // 할인 이모티콘, 값 이상시 이모티콘 구매
        int needDiscount = user[0];
        int limitPrice = user[1];
        
        int buyCost = 0;
        
        // 이 유저가 사는 이모티콘들의 할인가 값
        for(int i = 0; i<emo_cnt;i++){
            // 
            if(applied[i] >= needDiscount){
                int price = g_emoticons[i]*(100-applied[i])/100;
                buyCost += price;
            }
        }
        
        // 구독/구매 결정
        if(buyCost >= limitPrice){
            plusCnt++;
        }else{
            totalSales += buyCost;
        }
        
    }
    return {plusCnt, totalSales};
    
}

pair<int,int> bestResult = {0,0};

void dfs(int idx, vector<int>& applied){
    // idx는 dfs에서 높이, emo_cnt는 높이만큼
    // 모든 이모티콘에 할인율을 배정했을때 평가함
    if(idx == emo_cnt){
        auto result = simulate(applied);
        
        // 플러스 가입자수가 먼저
        if(result.first > bestResult.first){
            bestResult = result;
        }else if(result.first == bestResult.first && result.second > bestResult.second){
            bestResult = result;
        }
        return;
    }
    
    for(int d:discount){
        applied[idx] = d;
        dfs(idx + 1, applied);
    }
    
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    g_users = users;
    g_emoticons = emoticons;
    user_cnt = users.size();
    emo_cnt = emoticons.size();
    
    bestResult = {0,0};
    
    //이모티콘 별 할인율 배정결과,초기값 0
    vector<int> applied(emo_cnt);
    
    //dfs로 깊이 탐색으로 모든 이모티콘 별 할인율 될때마다 경우의 수 다계산
    dfs(0,applied);
    
    
    return {bestResult.first, bestResult.second};
}