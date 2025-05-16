#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int INF = 1e9;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> dist(N + 1, vector<int>(N + 1, INF));

    // 자기 자신과의 거리는 0
    for (int i = 1; i <= N; i++)
        dist[i][i] = 0;

    // 친구 관계 입력
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        dist[a][b] = 1;
        dist[b][a] = 1;
    }

    // 플로이드-워셜로 모든 쌍 최단 거리 구함
    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }

    int answer = 0;
    int minSum = INF;

    // 각 사람의 케빈 베이컨 수 계산
    for (int i = 1; i <= N; i++) {
        int sum = 0;
        for (int j = 1; j <= N; j++) {
            sum += dist[i][j];
        }
        if (sum < minSum) {
            minSum = sum;
            answer = i;
        }
    }

    cout << answer << '\n';

    return 0;
}
