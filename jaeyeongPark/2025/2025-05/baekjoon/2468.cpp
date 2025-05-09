#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

//입력받고 bfs, 델타로 인접한 곳을 타고 가기
// 비의 양에 대한 영역 개수 중 최대값을 갱신해주기


const int MAX = 100;
int N;
int map[MAX][MAX];
bool visited[MAX][MAX];
int dy[4] = { -1,1,0,0 };
int dx[4] = { 0,0,-1,1 };

// height 보다 높은 지역만 탐색
// 연결된 지역을 모두 방문처리해서 안전영역을 탐색
void bfs(int y, int x, int height) {
	queue<pair<int, int>> q;
	q.push({ y,x });
	visited[y][x] = true;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		//델타
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cy + dy[dir];
			int nx = cx + dx[dir];

			//경계값
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				continue;
			if (visited[ny][nx])
				continue;
			if (map[ny][nx] <= height)
				continue;

			visited[ny][nx] = true;
			q.push({ ny,nx });
		}
	}

}



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N;

	int max_height = 0;
	for(int i = 0; i < N; ++ i)
		for (int j = 0; j < N; ++j) {
			cin >> map[i][j];
			max_height = max(max_height, map[i][j]);
		}

	int result = 0;

	for (int h = 0; h <= max_height; ++h) {
		memset(visited, false, sizeof(visited));
		int count = 0;

		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (!visited[i][j] && map[i][j] > h) {
					bfs(i, j, h);
					++count;
				}

		result = max(result, count);
	}

	cout << result << '\n';
	return 0;




}