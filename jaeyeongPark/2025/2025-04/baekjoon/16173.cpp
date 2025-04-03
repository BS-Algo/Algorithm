#include <iostream>
#include <queue>

using namespace std;

int N;
int board[3][3];
bool visited[3][3];

bool bfs() {
    queue<pair<int, int>> q;
    q.push({0, 0});
    visited[0][0] = true;

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        int jump = board[x][y]; // 현재 칸의 점프 값
        if (jump == 0) continue; // 점프가 0이면 이동 불가

        // 아래 방향 이동
        int nx = x + jump;
        if (nx < N && !visited[nx][y]) {
            if (nx == N - 1 && y == N - 1) return true; // 도착점 도달
            q.push({nx, y});
            visited[nx][y] = true;
        }

        // 오른쪽 방향 이동
        int ny = y + jump;
        if (ny < N && !visited[x][ny]) {
            if (x == N - 1 && ny == N - 1) return true; // 도착점 도달
            q.push({x, ny});
            visited[x][ny] = true;
        }
    }

    return false; // 끝까지 도달하지 못함
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    if (bfs()) cout << "HaruHaru\n";
    else cout << "Hing\n";

    return 0;
}
