#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> v[1001];
    bool check[1001];

    int T;
    cin >> T;
    for (int t = 0; t < T; t++) {
        int N, M, a, b;
        cin >> N >> M;
        for (int i = 1; i <= N; i++) {
            v[i].clear();
            check[i] = false;
        }
        for (int i = 0; i < M; i++) {
            cin >> a >> b;
            v[a].push_back(b);
            v[b].push_back(a);
        }
        int result = 0;
        queue<int> q;
        q.push(1);
        check[1] = true;
        while (!q.empty()) {
            int cidx = q.front();
            q.pop();
            for (int i = 0; i < v[cidx].size(); i++) {
                int next = v[cidx][i];
                if (!check[next]) {
                    check[next]=true;
                    result++;
                    q.push(next);
                }
            }
        }
        cout << result << '\n';
    }
    return 0;
}