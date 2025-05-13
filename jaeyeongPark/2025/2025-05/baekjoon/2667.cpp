#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

//BFS

int N;
vector<vector<int>> map;
vector<vector<bool>> visited;
vector<int> result;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

void bfs(int y, int x) {
	queue<pair<int,int>> q;
	q.push({ y, x });
	visited[y][x] = true;
	int count = 1;

	while (!q.empty()) {
		int cy = q.front().first;
		int cx = q.front().second;
		q.pop();

		for (int dir = 0; dir < 4; dir++) {
			int ny = cy + dy[dir];
			int nx = cx + dx[dir];

			// 지도 범위 벗어나면 무시
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				continue;

			// 집이 없거나 방문한 곳이면 무시
			if (visited[ny][nx] || map[ny][nx] == 0)
				continue;

			visited[ny][nx] = true;
			q.push({ ny,nx });
			count++;
		}
	}
	//단지 크기 저장
	result.push_back(count);

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	//배열을 초기화함, N은 요소 개수, vector<int>(N)은 초기화할 값 즉 N개의 행을 vector<int>(N)의 열로 초기화함
	//resize는 크기만 바꾸고 기존요소는 남아있지만 assign은 기존 요소전부 삭제하고 새롭게 채움
	map.assign(N, vector<int>(N));

	//방문 배열을 초기화함
	//N*N 크기의 2차원 배열을 만들고 모든 값을 false로 초기화
	
	visited.assign(N, vector<bool>(N, false));

	//이렇게 입력 받을수 없음 이 문제에 입력 받는 값에 공백이 존재하지 않기 때문에 문자로 입력받은 다음 숫자로 변경해야함
	/*for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}*/

	for (int i = 0; i < N; i++) {
		string line;
		cin >> line;
		for (int j = 0; j < N; j++) {
			map[i][j] = line[j] - '0';
		}
	}

	//지도 전체를 순회하면서 BFS실행
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j] && map[i][j] == 1) {
				bfs(i, j);
			}
		}
	}

	//결과 정렬 후 출력
	sort(result.begin(), result.end());

	cout << result.size() << '\n';
	for (int size : result) {
		cout << size << '\n';
	}

	return 0;

}