#include<iostream>
#include<vector>
using namespace std;

vector<int> dx = {1, -1, 0, 0}; // 상하좌우 이동
vector<int> dy = {0, 0, 1, -1};

// DFS 함수 정의
void dfs(int x, int y, vector<vector<int>>& arr, int N, int M) {
    arr[x][y] = 0; // 방문처리 (배추를 0으로 변경)
    
    // 상하좌우로 탐색
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 배열 범위 내에 있고, 아직 방문하지 않은 배추가 있으면
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1) {
            dfs(nx, ny, arr, N, M); // 해당 배추와 연결된 다른 배추도 모두 탐색
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, M, N, K, x, y;

    cin >> T; // 테스트 케이스 개수 입력
    for (int t = 0; t < T; t++) { // 각 테스트 케이스 처리
        int count = 0; // 군집의 개수를 셀 변수
        cin >> M >> N >> K; // M: 가로, N: 세로, K: 배추의 개수

        // 배추 밭 초기화 (0으로 채움)
        vector<vector<int>> arr(N, vector<int>(M, 0));

        // 배추 위치 입력
        for (int j = 0; j < K; j++) {
            cin >> x >> y;
            arr[y][x] = 1; // 배추 위치에 1을 채운다
        }

        // 배추 군집 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) { // 아직 방문하지 않은 배추가 있다면
                    dfs(i, j, arr, N, M); // 해당 배추와 연결된 군집을 모두 방문
                    count++; // 군집이 하나 발견되었으므로 카운트 증가
                }
            }
        }

        cout << count << "\n"; // 각 테스트 케이스의 결과 출력
    }

    return 0;
}
