#include <iostream>
#include <cmath>

using namespace std;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	while (T--) {
		int x1, y1, r1, x2, y2, r2;
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		// 두 점 사이의 거리
		int dx = x2 - x1;
		int dy = y2 - y1;
		int d2 = dx * dx + dy * dy;
		// 반지름 합의 제곱
		int r_sum2 = (r1 + r2) * (r1 + r2);

		// 반지름 차이의 제곱값
		int r_dif2 = (r1 - r2) * (r1 - r2);

		// 동일한 원
		if (d2 == 0 && r1 == r2) {
			cout << "-1\n";
		}
		// 분리 된 원이거나 포함된 원
		else if (d2 > r_sum2 || d2 < r_dif2) {
			cout << "0\n";
		}
		// 접점 1개
		else if (d2 == r_sum2 || d2 == r_dif2) {
			cout << "1\n";
		}
		else {
			cout << "2\n";
		}
	}


}