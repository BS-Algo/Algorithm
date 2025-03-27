#include <iostream>
#include <vector>
using namespace std;

vector<int> graph;
vector<bool> visited;

void dfs(int node) {
    visited[node] = true;
    int next = graph[node]; // 현재 노드에서 이동할 다음 노드
    if (!visited[next]) {
        dfs(next);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;

        graph.assign(N + 1, 0);
        visited.assign(N + 1, false);

        for (int i = 1; i <= N; i++) {
            cin >> graph[i]; // i번째 노드가 가리키는 값 저장
        }

        int cycle_count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 노드라면 새로운 사이클 시작
                dfs(i);
                cycle_count++;
            }
        }

        cout << cycle_count << "\n";
    }

    return 0;
}
