#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N;
vector<string> map;
vector<vector<bool>> visited;
vector<int> complex_sizes;

// 상하좌우 이동을 위한 방향 벡터
int dx[4] = {0, 0, -1, 1}; // 좌우
int dy[4] = {-1, 1, 0, 0}; // 상하

void bfs(int y, int x) {
    queue<pair<int, int>> q;
    q.push({y, x});
    visited[y][x] = true;
    int count = 1;

    while (!q.empty()) {
        int cy = q.front().first;
        int cx = q.front().second;
        q.pop();

        for (int dir = 0; dir < 4; ++dir) {
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];

            // 범위를 벗어나면 무시
            if (ny < 0 || ny >= N || nx < 0 || nx >= N)
                continue;
            // 이미 방문했거나 집이 아니면 무시
            if (visited[ny][nx] || map[ny][nx] == '0')
                continue;

            visited[ny][nx] = true;
            q.push({ny, nx});
            count++;
        }
    }

    complex_sizes.push_back(count);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;
    map.resize(N);
    visited.assign(N, vector<bool>(N, false));

    for (int i = 0; i < N; ++i) {
        cin >> map[i];
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
            if (!visited[i][j] && map[i][j] == '1') {
                bfs(i, j);
            }
        }
    }

    sort(complex_sizes.begin(), complex_sizes.end());

    cout << complex_sizes.size() << '\n';
    for (int size : complex_sizes) {
        cout << size << '\n';
    }

    return 0;
}
