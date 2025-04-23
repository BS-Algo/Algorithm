#include <iostream>
#include <vector>

using namespace std;

long long solve(int n, vector<int>& dist, vector<int>& cost) {
    long long total_cost = 0;
    int MINcost = cost[0];  // 첫 번째 도시의 리터당 가격으로 초기화

    for (int i = 0; i < n - 1; i++) {
        if (cost[i] < MINcost) {
            MINcost = cost[i];
        }
        total_cost += (long long)MINcost * dist[i];
    }

    return total_cost;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> dist(N - 1);
    vector<int> cost(N);

    for (int i = 0; i < N - 1; i++) {
        cin >> dist[i];
    }

    for (int i = 0; i < N; i++) {
        cin >> cost[i];
    }

    cout << solve(N, dist, cost) << "\n";
    return 0;
}
