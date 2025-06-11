#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> graph;
vector<bool> visited;
int inviteCount = 0;

void bfs(int start) {
    queue<pair<int, int>> q;
    visited[start] = true;
    q.push({start, 0}); // (사람 번호, 깊이)

    while (!q.empty()) {
        int current = q.front().first;
        int depth = q.front().second;
        q.pop();

        if (depth >= 2) continue; // 친구의 친구까지만

        for (int next : graph[current]) {
            if (!visited[next]) {
                visited[next] = true;
                inviteCount++;
                q.push({next, depth + 1});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    graph.assign(N + 1, vector<int>());
    visited.assign(N + 1, false);

    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    bfs(1); // 1번이 상근이

    cout << inviteCount << '\n';

    return 0;
}
