#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> bg(3);
    vector<int> dr(2);


    for (int i = 0; i < 3; i++) {

        cin >> bg[i];
    }

    for (int i = 0; i < 2; i++) {
        cin >> dr[i];
    }

    int result = *min_element(bg.begin(),bg.end()) + *min_element(dr.begin(),dr.end()) - 50;

    cout << result;


    return 0;

}