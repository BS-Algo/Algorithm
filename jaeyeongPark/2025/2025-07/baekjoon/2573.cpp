#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// 2차원 배열의 빙산
// bfs 넓이 우선 탐색
// 빙산 칸 기준으로 동서남북에 0이 있으면 0이 저장된 칸의 개수만큼 칸의 숫자가 줄어듬
// 각 칸은 0보다 더 줄어들지 않음
// 동서남북으로 붙어있으면 한 덩어리임
// 최초로 두덩어리가 되는 시간을 구해라

// 1. 각 칸을 돌면서 델타로 동서남북에 0의 갯수를 카운트함.
// 2. 카운트가 0이고 델타로 도는게 끝났으면 덩어리 갯수 카운트를 1 올림.
// 3. 결과적으로 덩어리 갯수 카운트 2가 되면 횟수를 구할수 있음.

// bfs함수에 한번에 다 넣으면 불가능 동시에 녹아야해서
// melt함수랑 덩어리 세는 함수는 따로 만들어야함
int N, M;
int year = 0;

int dx[4] = {0,0,-1,1};
int dy[4] = {1,-1,0,0};

vector<vector<int>> iceberg;

void bfs(int x, int y, vector<vector<bool>>& visited) {
	// 큐를 만들고 델타 탐색을 하고 그때 또 0이 아닌 값이 있으면 또 큐에 집어넣고
	queue<pair<int,int>> q;
	q.push({ x, y });
	visited[x][y] = true;

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		int cx = cur.first;
		int cy = cur.second;
		
		q.pop();

		for (int dir = 0;dir < 4;dir++) {
			int nx = cx + dx[dir];
			int ny = cy + dy[dir];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (iceberg[nx][ny] > 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.push({ nx,ny });
				}
			}
		}
	}



}

int countIsland() {
	vector<vector<bool>> visited(N, vector<bool>(M, false));
	int count = 0;

	for (int i = 0;i < N;i++) {
		for (int j = 0; j < M; j++) {
			if (iceberg[i][j] > 0 && !visited[i][j]) {
				bfs(i, j, visited);
				count++;
			}
		}
	}

	return count;
}

void melt() {
	// 임시 배열을 만들기
	vector<vector<int>> temp = iceberg;

	for (int i = 0;i < N;i++) {
		for (int j = 0;j < M;j++) {
			if (iceberg[i][j] > 0) {
				int sea = 0;
				for (int dir = 0;dir < 4;dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (iceberg[nx][ny] == 0) {
							sea++;
						}
					}
				}
				temp[i][j] = max(0, iceberg[i][j] - sea);
			}
		}
	}

	iceberg = temp;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> N >> M;

	iceberg.resize(N, vector<int>(M));

	for (int i = 0;i < N;i++) {
		for (int j = 0;j < M;j++) {
			cin >> iceberg[i][j];
		}
	}
	
	while (true) {
		int cnt = countIsland();

		if (cnt >= 2) {
			cout << year << '\n';
			break;
		}
		else if (cnt == 0) {
			cout << 0 << '\n';
			break;
		}

		melt();
		year++;
	}
	return 0;
}