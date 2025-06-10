#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> iceberg;

// 상하좌우 방향
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

// 범위 확인
bool inRange(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M;
}

// BFS로 빙산 덩어리 개수 세기
int countChunks() {
    vector<vector<bool>> visited(N, vector<bool>(M, false));
    int chunks = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (iceberg[i][j] > 0 && !visited[i][j]) {
                chunks++;
                queue<pair<int,int>> q;
                q.push({i,j});
                visited[i][j] = true;

                while (!q.empty()) {
                    auto [x, y] = q.front(); q.pop();

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if (inRange(nx,ny) && iceberg[nx][ny] > 0 && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.push({nx,ny});
                        }
                    }
                }
            }
        }
    }

    return chunks;
}

// 빙산 녹이기
void melt() {
    vector<vector<int>> reduce(N, vector<int>(M, 0));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (iceberg[i][j] > 0) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d], nj = j + dy[d];
                    if (inRange(ni, nj) && iceberg[ni][nj] == 0) cnt++;
                }
                reduce[i][j] = cnt;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            iceberg[i][j] = max(0, iceberg[i][j] - reduce[i][j]);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    iceberg.assign(N, vector<int>(M));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            cin >> iceberg[i][j];

    int years = 0;

    while (true) {
        int chunks = countChunks();
        if (chunks == 0) {
            cout << 0 << '\n';
            return 0;
        }
        if (chunks >= 2) {
            cout << years << '\n';
            return 0;
        }

        melt();
        years++;
    }

    return 0;
}
