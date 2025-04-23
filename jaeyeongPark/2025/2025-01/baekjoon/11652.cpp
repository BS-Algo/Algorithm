#include <iostream>
#include <vector>
#include <map>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> v(100001,0);
    
    int N;
    cin >> N;

    map<long long, int> freq;


    for (int i = 0; i < N; i++) {
        long long num;
        cin >> num;
        freq[num] += 1;
    }

    long long mostFrequent = 0;
    int maxCount = 0;

    for (auto& pair : freq) {
        if (pair.second > maxCount) {
            maxCount = pair.second;
            mostFrequent = pair.first;
        }
    }

    cout << mostFrequent << '\n';

    return 0;
}