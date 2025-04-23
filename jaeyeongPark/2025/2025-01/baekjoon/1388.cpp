#include <iostream>
#include <vector>
#include <string>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int N, M;
    cin >> N >> M;

    //2차원 배열
    vector<vector<char>> arr(N);

    //한줄씩 str로 문자를 받아온다.
    for (int i = 0; i < N; i++) {
        string str;
        cin >> str;

        //그 줄에 str의 길이만큼 j를 넣는다.
        for (int j = 0; j < str.length(); j++) {
            arr[i].push_back(str[j]);
        }
    }

    int count = 0;

    for (int i = 0; i < N; i++) {
        // row는 그전의 그 줄의 값 - 나 ㅣ의 반복을 알기 위해서 작성
        char row = arr[i][0];
        count++;

        // 만약 1열부터 첫번째가 l일때 그전 열도 l이면 같은 판자이기 때문에 count를 1 빼준다.
        if (i > 0 && row == '|' && row == arr[i - 1][0]) count--;

        // 행을 확인한다.
        for (int j = 1; j < M; j++) {
            if (row != arr[i][j] || (row == arr[i][j] && row == '|')) {
                count++;
                row = arr[i][j];
            }
            if (i > 0 && arr[i][j] == '|' && arr[i][j] == arr[i - 1][j]) count--;
        }
    } 

    cout << count;

    return 0;

}