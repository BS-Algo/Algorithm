#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int M, N, K;
vector<vector<int>> board;
vector<vector<bool>> visited;

int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { -1, 1, 0, 0 };

int bfs(int y, int x) {
    queue<pair<int, int>> q;
    q.push({ y, x });
    visited[y][x] = true;
    int area = 1;

    while (!q.empty()) {
        auto [cy, cx] = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
            if (visited[ny][nx] || board[ny][nx] == 1) continue;

            visited[ny][nx] = true;
            q.push({ ny, nx });
            area++;
        }
    }

    return area;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> M >> N >> K;

    board.assign(M, vector<int>(N, 0));
    visited.assign(M, vector<bool>(N, false));

    // 직사각형 좌표 입력 받아서 1로 채우기
    for (int i = 0; i < K; i++) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                board[y][x] = 1;
            }
        }
    }

    vector<int> areas;

    for (int y = 0; y < M; y++) {
        for (int x = 0; x < N; x++) {
            if (!visited[y][x] && board[y][x] == 0) {
                int area = bfs(y, x);
                areas.push_back(area);
            }
        }
    }

    sort(areas.begin(), areas.end());

    cout << areas.size() << '\n';
    for (int a : areas) {
        cout << a << ' ';
    }
    cout << '\n';

    return 0;
}
