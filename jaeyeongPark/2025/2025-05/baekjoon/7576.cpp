#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

int M, N;
vector<vector<int>> box;
vector<vector<int>> days;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

queue<pair<int, int>> q;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> M >> N;

	box.assign(N, vector<int>(M));
	days.assign(N, vector<int>(M, 0));

	//토마토의 정보를 다 받기
	//익은 토마토 위치를 큐에 저장하기
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> box[i][j];`
			if (box[i][j] == 1) {
				q.push({ i,j });
			}
		}
	}

	//큐를 bfs탐색으로 돌면서 델타로 상하좌우에 0이 있는지 파악하기
    while (!q.empty()) {
        auto [y, x] = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                continue;

            if (box[ny][nx] == 0) {
                box[ny][nx] = 1; // 익게 만들기
                days[ny][nx] = days[y][x] + 1; // 날짜 증가
                q.push({ ny, nx });
            }
        }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (box[i][j] == 0) {
                cout << -1 << '\n'; // 안 익은 토마토 남아있으면 실패
                return 0;
            }
            answer = max(answer, days[i][j]); // 최댓값 갱신
        }
    }

    cout << answer << '\n'; // 걸린 일수 출력
    return 0;

}