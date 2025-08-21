#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;



// bill 의 [0],[1] 둘다 wallet이랑 비교해서 bill이 더 작은지 확인
// [0],[1] 바꿔서 bill 이 더 작은지 확인 둘다 안돼면 /2를 하고 cnt++ 하고 다시 while문
// 들어가지는 순간 break 

int solution(vector<int> wallet, vector<int> bill) {
    int cnt = 0;
    while(true){
        if(wallet[0]>=bill[0] && wallet[1]>=bill[1] || wallet[0]>=bill[1] && wallet[1]>=bill[0]){
            break;
        }
        else{
            if(bill[0]>bill[1]){
                bill[0]=bill[0]/2;
                cnt++;
            }
            else{
                bill[1] = bill[1]/2;
                cnt++;
            }
        }
    }
    
    return cnt;
}