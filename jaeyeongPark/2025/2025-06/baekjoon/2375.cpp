#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int N, M;
int board[301][301];
bool visited[301][301];

int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };
// 2일 걸림
// BFS로 연결된 빙산 탐색
void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push({ x, y });
    visited[x][y] = true;

    while (!q.empty()) {
        auto [cx, cy] = q.front(); q.pop();

        for (int dir = 0; dir < 4; ++dir) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (!visited[nx][ny] && board[nx][ny] > 0) {
                visited[nx][ny] = true;
                q.push({ nx, ny });
            }
        }
    }
}

// 빙산 높이 감소 계산
void melt() {
    int temp[301][301];
    memcpy(temp, board, sizeof(board));

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (board[i][j] > 0) {
                int sea = 0;
                for (int d = 0; d < 4; ++d) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (board[nx][ny] == 0) sea++;
                }
                temp[i][j] = max(0, board[i][j] - sea);
            }
        }
    }

    memcpy(board, temp, sizeof(board));
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
        for (int j = 0; j < M; ++j)
            cin >> board[i][j];

    int year = 0;
    while (true) {
        memset(visited, false, sizeof(visited));
        int count = 0;

        // 빙산 덩어리 개수 세기
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        if (count == 0) {
            cout << 0 << '\n'; // 다 녹을 때까지 분리되지 않음
            break;
        }

        if (count >= 2) {
            cout << year << '\n'; // 분리된 해
            break;
        }

        melt(); // 1년 경과
        year++;
    }

    return 0;
}
