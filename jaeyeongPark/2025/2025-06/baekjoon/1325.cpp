#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int N, M;
vector<vector<int>> graph;
vector<int> result;

//BFS
int bfs(int start) {
    vector<bool> visited(N + 1, false);
    queue<int> q;
    int count = 1;

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int next : graph[cur]) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                q.push(next);
            }
        }
    }

    return count;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    graph.resize(N + 1);
    result.resize(N + 1);

    for (int i = 0; i < M; ++i) {
        int A, B;
        cin >> A >> B;
        // B를 해킹하면 A도 해킹된다
        graph[B].push_back(A);
    }

    int maxCount = 0;

    for (int i = 1; i <= N; ++i) {
        result[i] = bfs(i);
        maxCount = max(maxCount, result[i]);
    }

    for (int i = 1; i <= N; ++i) {
        if (result[i] == maxCount) {
            cout << i << " ";
        }
    }
    cout << '\n';

    return 0;
}
