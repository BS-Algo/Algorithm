#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

//DFS는 인접 리스트로 표현, 방문한 노드를 출력하고 방문하지 않은 인접 노드를 재귀
//방문여부는 visited 배열로 체크하기

//인접리스트
vector<int> graph[1001];

bool visited[1001];

//dfs
void dfs(int node) {
	//현재 노드 출력
	cout << node << " ";
	visited[node] = true;

	for (int next : graph[node]) {
		if (!visited[next]) {
			dfs(next);
		}
	}
}

void bfs(int start) {
	queue<int> q;
	//방문 초기화
	fill(visited, visited + 1001, false);
	q.push(start);
	visited[start] = true;

	while (!q.empty()) {
		int node = q.front();
		q.pop();
		cout << node << " ";

		for (int next : graph[node]) {
			if (!visited[next]) {
				visited[next] = true;
				q.push(next);
					
				
			}
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, M, V;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		//무방향 그래프라서 양쪽 모두 추가해야함
		graph[a].push_back(b);
		graph[b].push_back(a);
	}

	// 방문순서 때문에 정렬
	for (int i = 1; i <= N; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	fill(visited, visited + 1001, false);
	dfs(V);
	cout << "\n";

	bfs(V);
	cout << "\n";

	return 0;

	


}