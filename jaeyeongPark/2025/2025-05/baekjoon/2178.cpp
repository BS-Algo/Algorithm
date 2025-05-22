#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> maze;
vector<vector<bool>> visited;
vector<vector<int>> dist;

int dx[4] = { 0, 0, -1, 1 };  // 좌우
int dy[4] = { -1, 1, 0, 0 };  // 상하

void bfs(int startX, int startY) {
    queue<pair<int, int>> q;
    q.push({startX, startY});
    visited[startX][startY] = true;
    dist[startX][startY] = 1; // 시작 지점도 한 칸으로 계산

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위 체크
            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            // 방문하지 않았고, 갈 수 있는 칸인 경우
            if (!visited[nx][ny] && maze[nx][ny] == 1) {
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1; // 거리 갱신
                q.push({nx, ny});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    maze.assign(N, vector<int>(M));
    visited.assign(N, vector<bool>(M, false));
    dist.assign(N, vector<int>(M, 0));

    // 미로 입력
    for (int i = 0; i < N; i++) {
        string row;
        cin >> row;
        for (int j = 0; j < M; j++) {
            maze[i][j] = row[j] - '0';
        }
    }

    bfs(0, 0); // 시작 좌표는 (0,0)

    // 도착 지점까지의 최단 거리 출력
    cout << dist[N - 1][M - 1] << '\n';

    return 0;
}
