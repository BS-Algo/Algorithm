#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> graph(N + 1);
    vector<int> dist(N + 1, -1); 

    for (int i = 0; i < M; ++i) {
        int a, b;
        cin >> a >> b;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    queue<int> q;
    q.push(1);
    dist[1] = 0;

    while (!q.empty()) {
        int cur = q.front(); q.pop();

        for (int next : graph[cur]) {
            if (dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.push(next);
            }
        }
    }

 
    int max_dist = 0;
    int min_idx = 0;
    int count = 0;

    for (int i = 1; i <= N; ++i) {
        if (dist[i] > max_dist) {
            max_dist = dist[i];
            min_idx = i;
            count = 1;
        } else if (dist[i] == max_dist) {
            count++;
            if (i < min_idx) min_idx = i;
        }
    }

    cout << min_idx << ' ' << max_dist << ' ' << count << '\n';

    return 0;
}
