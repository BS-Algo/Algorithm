#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    typedef long long ll;
    int n;
    cin >> n;

    vector<int> v(n);

    for (int i = 0;i < n;i++) {
        cin >> v[i];
    }

    int b, c;
    cin >> b >> c;

    ll result = n;
    for (int i = 0;i < n;i++) {
        v[i] -= b;
        if (v[i] <= 0)continue;
        result += v[i] / c;
        if (v[i] % c)result += 1;
    }
    cout << result;
    return 0;

}
