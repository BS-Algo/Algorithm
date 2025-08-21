#include <string>
#include <vector>
#include <iostream>
using namespace std;

// 2차원 배열을 만들고 i번째의 j번째 상자를 꺼내려고함, 그러면 i보다 크고 j 보다 큰 상자의 개수를 구하면됨
// 택배 상자 개수가 n, 가로 w, 꺼내려는 상자 번호 num

int solution(int n, int w, int num) {
    int h = (n+w-1)/w;
    vector<vector<int>> arr(h,(vector<int>(w,0)));
    int cnt = 1;
    
    for(int i = 0;i<h;i++){
        if(i%2==0){
            for(int j = 0;j<w;j++){
                arr[i][j] = cnt++;
                if(cnt > n) break;
            }
        } else{
            for(int j = w-1;j>=0;j--){
                arr[i][j] = cnt++;
                if(cnt > n) break;
            }
        }
    }
  
    int targetRow = -1, targetCol = -1;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (arr[i][j] == num) {
                targetRow = i;
                targetCol = j;
            }
        }
    }

  
    int answer = 0;
    for (int i = h - 1; i >= targetRow; i--) {
        if (arr[i][targetCol] != 0) answer++;
    }
    
    return answer;
}