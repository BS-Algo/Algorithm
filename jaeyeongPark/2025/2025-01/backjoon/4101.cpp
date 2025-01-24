#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

	int a, b;
	while (1) {
		cin >> a >> b;
		if (a == 0 && b == 0) break;

		if (a <= b) cout << "No" << endl;
		else cout << "Yes" << endl;
	}

	return 0;


}