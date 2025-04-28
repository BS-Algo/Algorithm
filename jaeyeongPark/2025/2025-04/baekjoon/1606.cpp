#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct State {
    int x, y, broken;
};

int n, m;
vector<vector<int>> map;
vector<vector<vector<int>>> visited; // visited[x][y][0]: 벽 안부숨, visited[x][y][1]: 벽 부숨

// 4방향
const int dx[4] = {0, 0, 1, -1};
const int dy[4] = {1, -1, 0, 0};

int bfs() {
    queue<State> q;
    q.push({0, 0, 0});
    visited[0][0][0] = 1; // 시작 위치 방문 (벽 안 부순 상태)

    while (!q.empty()) {
        State cur = q.front();
        q.pop();

        int x = cur.x;
        int y = cur.y;
        int broken = cur.broken;

        // 도착했으면 거리 리턴
        if (x == n - 1 && y == m - 1) {
            return visited[x][y][broken];
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 맵 범위 체크
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 벽이 없고, 아직 방문 안했으면
                if (map[nx][ny] == 0 && visited[nx][ny][broken] == 0) {
                    visited[nx][ny][broken] = visited[x][y][broken] + 1;
                    q.push({nx, ny, broken});
                }
                // 벽이 있는데, 아직 부순 적 없으면
                else if (map[nx][ny] == 1 && broken == 0 && visited[nx][ny][1] == 0) {
                    visited[nx][ny][1] = visited[x][y][broken] + 1;
                    q.push({nx, ny, 1}); // 벽 부숨
                }
            }
        }
    }

    // 도달 못함
    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    map.assign(n, vector<int>(m));
    visited.assign(n, vector<vector<int>>(m, vector<int>(2, 0)));

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < m; j++) {
            map[i][j] = s[j] - '0';
        }
    }

    cout << bfs() << "\n";
    return 0;
}
