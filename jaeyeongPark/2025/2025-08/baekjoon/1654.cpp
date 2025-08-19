#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// K의 랜선의 길이는 랜덤 
// // N개의 같은 길이의 랜선을 만들어야함 300에서 140두개만들면 20을 버려야함 
// K개로 N개를 무조건 만들수있다고 가정 N개보다 많이 만드는 것도 N개를 만드는 것에 포함 
// 이때 만들 수 있는 최대 랜선의 길이를 구하라.


// 1. 가장 작은 수를 가지고 arr를 돌면서 몫만 들고와서 N과 비교해보기 
// 2. 가장 작은수를 가지고 1을 빼면서 while문 돌기 
// 3. 아니면 반으로 나눠서 몫만 들고와서 N과 비교했을때 더 많으면
// 더 왼쪽으로 탐색하고 더 작으면 반 나눈거 기준 오른쪽으로 탐색 만약 N보다 1 더크면 한칸 왼쪽인것이 최대값이됨
// 이분탐색

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int k, n;
	cin >> k >> n;
	vector<long long> arr(k);

	for (int i = 0; i < k; i++) {
		cin >> arr[i];
	}

	long long left = 1;
	long long right = *max_element(arr.begin(), arr.end());
	long long answer = 0;

	while (left <= right) {
		long long mid = (left + right) / 2;
		long long cnt = 0;

		for (int i = 0; i < k; i++) {
			cnt += arr[i] / mid;
		}

		if (cnt >= n) {
			// N개 이상 만들수있음, 더 길게 한번 시도, 최대값 구해야하니까
			answer = mid;
			left = mid + 1;

		}
		else {
			// N개 못만듬, 더 짧게 짤라야함
			right = mid - 1;
		}
	}

	cout << answer << "\n";
	return 0;

}