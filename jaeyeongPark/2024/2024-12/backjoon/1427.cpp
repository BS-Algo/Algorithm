#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    int N;

    cin >> N;

    string number = to_string(N);

    sort(number.rbegin(), number.rend());

    cout << number;

    return 0;
}