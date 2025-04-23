#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int h, m, time;
    cin >> h >> m >> time;

    if (m + time > 59) {
        h += (m + time) / 60;

        if (((m + time) % 60) == 0) m = 0;
        else m = (m + time) % 60;
    }
    else m += time;

    if (h > 23) h -= 24;

    cout << h << ' ' << m;
    return 0;


}