#include <algorithm>
#include <iostream>
using namespace std;


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int E, S, M;
    int year = 1;
    cin >> E >> S >> M;

    while (true) {
        if ((year - E) % 15 == 0 && (year - S) % 28 == 0 &&  (year - M) % 19==0) {
            break;
        }
        else {
            year++;
        }
    }
    cout << year;
    return 0;
}
