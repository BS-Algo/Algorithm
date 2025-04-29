#include <iostream>
#include <vector>
#include <string>
#include <climits>
using namespace std;

int main() {
    string target;
    cin >> target;

    int N;
    cin >> N;

    vector<int> prices(N);
    vector<string> titles(N);
    for (int i = 0; i < N; ++i) {
        cin >> prices[i] >> titles[i];
    }

    int min_cost = INT_MAX;

    // 모든 조합을 확인 해보기
    // alphacount 이용
    // #include <climits>는 한계값 ㅇ사용하기 위해서 이용
    for (int mask = 1; mask < (1 << N); ++mask) {
        vector<int> alpha_count(26, 0);
        int total_cost = 0;

        // 선택된 전공책들의 알파벳 개수와 총 비용 계산
        for (int i = 0; i < N; ++i) {
            if (mask & (1 << i)) {
                total_cost += prices[i];
                for (char c : titles[i]) {
                    alpha_count[c - 'A']++;
                }
            }
        }

        // 원하는 단어를 만들 수 있는지 확인
        bool can_make = true;
        for (char c : target) {
            if (--alpha_count[c - 'A'] < 0) {
                can_make = false;
                break;
            }
        }

        if (can_make) {
            min_cost = min(min_cost, total_cost);
        }
    }

    if (min_cost == INT_MAX) {
        cout << -1 << endl;
    } else {
        cout << min_cost << endl;
    }

    return 0;
}
