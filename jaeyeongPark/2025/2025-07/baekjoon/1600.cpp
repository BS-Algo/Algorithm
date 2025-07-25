#include<iostream>
#include<vector>
#include<queue>
#include<tuple>
using namespace std;

// 체스 말처럼 원숭이는 이동, K번만 말처럼 이동, 그외에는 인접한 칸으로(동서남북)
// 맨 왼쪽 위에서 오른쪽 아래로 이동, 최소한의 동작으로 도착지점까지 가는 방법
// K를 포함한 3차원 배열


int K, W, H;
vector<vector<int>> arr;

//상하좌우
int dx4[4] = { 0,0,-1,1 };
int dy4[4] = { -1,1,0,0 };

//말이동
int dx8[8] = { 1,2,2,1,-1,-2,-2,-1 };
int dy8[8] = { -2,-1,1,2,2,1,-1,-2 };


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> K;
	cin >> W >> H;

	arr.resize(H, vector<int>(W));

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			cin >> arr[i][j];
		}
	}

	//시작이랑 끝이 같은 경우
	if (H == 1 && W == 1) {
		cout << 0 << '\n';
		return 0;
	}
	// 3차원 배열, K번말 이동, y,x,에 도달한 최소이동 횟수
	vector<vector<vector<int>>> dist(K + 1, vector<vector<int>>(H, vector<int>(W, -1)));

	queue<tuple<int, int, int>> q;
	dist[0][0][0] = 0;
	q.emplace(0, 0, 0);

	// inRange의 y,x를 호출하면 y,x 가 배열 범위 안에 있는지를 true/false로 판단해주는 함수
	// [&]는 캡처 리스트라고 외부변수를 참조로 캡처한다는 뜻
	auto inRange = [&](int y, int x) {
		return(0 <= y && y < H && 0 <= x && x < W);
	};

	while (!q.empty()) {
		auto cur = q.front(); q.pop();
		int y = get<0>(cur);
		int x = get<1>(cur);
		int used = get<2>(cur);
		int curd = dist[used][y][x];

		//4방향 이동
		for (int d = 0; d < 4; d++) {
			int nx = x + dx4[d];
			int ny = y + dy4[d];
			if (!inRange(ny, nx) || arr[ny][nx] == 1) continue;
			if (dist[used][ny][nx] == -1) {
				dist[used][ny][nx] = curd + 1;
				if (ny == H - 1 && nx == W - 1) {
					cout << dist[used][ny][nx] << '\n';
					return 0;
				}
				q.emplace(ny, nx, used);
			}
		
		}

		//말 이동
		if (used < K) {
			for (int d = 0; d < 8; d++) {
				int ny = y + dy8[d], nx = x + dx8[d];
				if (!inRange(ny, nx) || arr[ny][nx] == 1) continue;
				if (dist[used + 1][ny][nx] == -1) {
					dist[used + 1][ny][nx] = curd + 1;
					if (ny == H - 1 && nx == W - 1) {
						cout << dist[used + 1][ny][nx] << '\n';
						return 0;
					}
					q.emplace(ny, nx, used + 1);
				}
			}
		}
	}
	cout << -1 << '\n';
	return 0;
}