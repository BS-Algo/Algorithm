#include<iostream>
#include<vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N, M;
	cin >> N >> M;

	const int INF = 1e9;
	vector<vector<int>> dist(N + 1, vector<int>(N + 1, INF));
	for (int i = 1; i <= N; i++) dist[i][i] = 0;

	int a, b;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		dist[a][b] = dist[b][a] = 1;
	}

	// 플로이드 워셜 알고리즘
	// 정점 쌍 간의 최단거리 알고리즘 O(N^3)의 시간 복잡도
	// 서로 연결되어이 있으면 거리 1, 양방향으로 결정
	// k는 중간에 거쳐가는 사람 i는 시작점 j는 도착점
	// i -> k -> j 로 가는 경로가 기존 i->j 보다 더 짧으면 갱신합니다.

	for (int k = 1; k <= N; k++)
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (dist[i][j] > dist[i][k] + dist[k][j])
					dist[i][j] = dist[i][k] + dist[k][j];

	int answer = -1;
	int bestSum = INF;

	for (int i = 1; i <= N; i++) {
		int sum = 0;
		for (int j = 1; j <= N; j++) sum += dist[i][j];
		if (sum < bestSum) {
			bestSum = sum;
			answer = i;
		}
	}

	cout << answer << '\n';
	return 0;
}