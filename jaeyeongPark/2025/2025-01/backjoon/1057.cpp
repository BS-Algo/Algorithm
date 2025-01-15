#include <iostream>
#include <vector>
#include <map>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, l;
    int match = 0;

    cin >> n >> k >> l;

    while (k != l) {
        k = (k + 1) / 2;
        l = (l + 1) / 2;
        match++;
    }

    cout << match;


}