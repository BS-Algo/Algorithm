#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// 방향 벡터: 상, 하, 좌, 우 및 대각선(좌상, 좌하, 우상, 우하)
const vector<int> dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
const vector<int> dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

int w, h;
vector<vector<int>> map;

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push({ x, y });
    map[x][y] = 0; // 방문 처리

    while (!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();

        for (int i = 0; i < 8; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            // 유효한 좌표인지 확인 (범위 체크)
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                q.push({ nx, ny });
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (true) {
        cin >> w >> h;
        if (w == 0 && h == 0) break;

        map.assign(h, vector<int>(w, 0));

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> map[i][j];
            }
        }

        int island_count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    island_count++;
                }
            }
        }

        cout << island_count << "\n";
    }

    return 0;
}
