#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> sequence(n);
    for (int i = 0; i < n; i++) {
        cin >> sequence[i];
    }

    stack<int> st;
    vector<char> result;
    int cur = 1;
    bool possible = true;

    for (int i = 0; i < n; i++) {
        int target = sequence[i];

        while (cur <= target) {
            st.push(cur);
            result.push_back('+');
            cur++;
        }

        if (st.top() == target) {
            st.pop();
            result.push_back('-');
        } else {
            possible = false;
            break;
        }
    }

    if (!possible) {
        cout << "NO\n";
    } else {
        for (char c : result) {
            cout << c << '\n';
        }
    }

    return 0;
}
