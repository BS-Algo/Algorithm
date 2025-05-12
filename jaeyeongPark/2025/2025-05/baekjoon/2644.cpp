#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cstring>

using namespace std;

//BFS
// 


int N;
int A, B;
int m, x, y;

vector<int>graph[101];
bool visited[101];
int dist[101];


void bfs(int start) {
	queue<int> q;
	q.push(start);
	visited[start] = true;
	dist[start] = 0;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int next : graph[cur]) {
			if (!visited[next]) {
				visited[next] = true;
				dist[next] = dist[cur] + 1;
				q.push(next);
			}
		}
	}


}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	//N개의 순서쌍을 만들고 짝을 이룸
	//관계는 양방향
	//특정 노드에서 목표 노드까지 최단거리 bfs
	//스타트 지점을 정하고 dist배열을 만든다음 bfs로 배열을 만든다음 dist로 찾기
	cin >> N;

	cin >> A >> B;
	cin >> m;

	for (int i = 0; i < m; i++) {
		cin >> x >> y;

		//양방향 연결
		graph[x].push_back(y);
		graph[y].push_back(x);
		
		
	}
	
	bfs(A);

	if (dist[B] == 0 && A != B)
		cout << -1 << '\n';
	else
		cout << dist[B] << '\n';

	return 0;

}