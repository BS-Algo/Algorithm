#include <iostream>
using namespace std;

int main(void) {
    int score = 0, sum = 0;
    for(int i = 0;i<5;i++){
        cin >> score;
        sum += score;
    }
    cout << sum << endl;
    return 0;
}