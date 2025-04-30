#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

// DP
// 문자열로 저장된 큰 수에 대한 덧셈하기
// 범위 초과 주의하기
// 
string add(string a, string b) {
    string res;
    int carry = 0;

    if (a.size() < b.size()) swap(a, b);
    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    for (int i = 0; i < a.size(); i++) {
        int digitA = a[i] - '0';
        int digitB = (i < b.size()) ? b[i] - '0' : 0;
        int sum = digitA + digitB + carry;
        carry = sum / 10;
        res += (sum % 10 + '0');
    }

    if (carry) res += (carry + '0');
    reverse(res.begin(), res.end());
    return res;
}

// 문자열 a가 b보다 작거나 같은지
bool leq(const string& a, const string& b) {
    if (a.size() != b.size())
        return a.size() < b.size();
    return a <= b;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    // 피보나치 수열을 미리 구함
    vector<string> fib;
    fib.push_back("1"); // F(1)
    fib.push_back("2"); // F(2)

    while (true) {
        string next = add(fib[fib.size() - 1], fib[fib.size() - 2]);
        if (next.size() > 100) break; // 10^100 초과
        fib.push_back(next);
    }

    string a, b;
    while (cin >> a >> b) {
        if (a == "0" && b == "0") break;
        int count = 0;
        for (const string& f : fib) {
            if (leq(a, f) && leq(f, b)) {
                count++;
            }
        }
        cout << count << "\n";
    }

    return 0;
}
