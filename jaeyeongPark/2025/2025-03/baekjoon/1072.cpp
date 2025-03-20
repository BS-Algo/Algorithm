#include <iostream>

using namespace std;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long X,Y;
	cin >> X >> Y;

	// 현재 승률
	long long Z = (Y * 100) / X;

	if (Z >= 99) {
		// 승률이 99퍼 이상이면 변화 안됨
		cout << "-1\n";
		return 0;
	}

	// 이진트리로 해야 안터짐
	long long left = 1, right = 1e9, answer = -1;
	while (left <= right) {
		long long mid = (left + right) / 2;
		// 추가 게임 후 승률
		long long dZ = ((Y + mid) * 100) / (X + mid);

		if (dZ > Z) {
			answer = mid;
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}


	}

	cout << answer << "\n";
	return 0;

	


}