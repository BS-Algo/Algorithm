#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> graph;
vector<bool> visited;
int infected = 0;

void dfs(int node) {
    visited[node] = true;
    for (int next : graph[node]) {
        if (!visited[next]) {
            infected++;
            dfs(next);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    graph.assign(n + 1, vector<int>());
    visited.assign(n + 1, false);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    dfs(1);

    cout << infected << "\n";

    return 0;
}
