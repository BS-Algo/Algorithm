#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    int check_row = 0;
    int check_col = 0;

    char arr[N][M]; // 문자열 배열
    bool row[50] = { false }; // 행
    bool col[50] = { false }; // 열

    // 배열 입력받고 경비원이 있는지 검사
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j]; // 배열 입력 받기
            if (arr[i][j] == 'X') { // 'X'이면 경비원이 있으니까
                row[i] = true;
                col[j] = true;
            }
        }
    }

    // 경비원이 없는 행의 수 검사
    for (int i = 0; i < N; i++) {
        if (!row[i]) {
            check_row++;
        }
    }

    // 경비원이 없는 열의 수 검사
    for (int j = 0; j < M; j++) {
        if (!col[j]) {
            check_col++;
        }
    }

    // 행과 열 중 더 없는 쪽의 갯수에 맞게 경비원을 세운다.
    int answer = max(check_row, check_col);
    cout << answer << endl;

    return 0;


}