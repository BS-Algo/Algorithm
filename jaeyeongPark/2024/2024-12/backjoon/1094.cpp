#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int X;
	cin >> X;

	int stick = 64;
	int sum = 0;
	int count = 0;

	while (sum < X) {
		if (stick > X - sum) {
			stick /= 2;
		}
		else{
			sum += stick;
			count++;
		}
	}
	cout << count;

	return 0;
}