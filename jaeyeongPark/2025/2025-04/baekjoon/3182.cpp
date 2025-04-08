#include <iostream>
#include <vector>
#include <cstring> // memset
using namespace std;

int n;
vector<int> graph;
bool visited[1001]; // 방문 체크

int dfs(int node) {
    int cnt = 0;
    memset(visited, false, sizeof(visited));
    while (!visited[node]) {
        visited[node] = true;
        node = graph[node];
        cnt++;
    }
    return cnt;
}

int main() {
    cin >> n;
    graph.resize(n + 1);

    for (int i = 1; i <= n; i++) {
        cin >> graph[i];
    }

    int maxCount = 0;
    int result = 0;

    for (int i = 1; i <= n; i++) {
        int count = dfs(i);
        if (count > maxCount) {
            maxCount = count;
            result = i;
        }
    }

    cout << result << "\n";
    return 0;
}
