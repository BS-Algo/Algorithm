#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> graph;
vector<bool> visited;
int n, m;

void dfs(int node) {
	visited[node] = true;
	for (int next : graph[node]) {
		if (!visited[next]) {
			dfs(next);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	graph.resize(n + 1);
	visited.resize(n + 1, false);

	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	int components = 0;
	for (int i = 1; i <= n; i++) {
		// 방문하지 않은 새로운 연결 요소 
		if (!visited[i]) { 
			dfs(i);
			components++;
		}
	}

	cout << components << '\n';
	return 0;
}