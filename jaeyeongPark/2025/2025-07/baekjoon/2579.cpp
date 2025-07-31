#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

// 1칸 또는 2칸씩 올라감, 연속된 3칸 못올라감, 시작점은 포함안되고, 마지막은 무조건 가야함

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;
	int a;
	int arr[301];
	int dp[301];


	// dp로 풀어야함
	// 칸 올라가는 방식은 두가지
	// 2칸 올라가는 경우 i-2에서 i로
	// 1칸 + 1칸 경우 i-3 -> i-1 -> i (3연속 방지하기 위해서 i-3에서 시작)
	// dp[i] = max(dp[i-2],dp[i-3] + score[i-1]) + score[i];

	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}

	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	dp[3] = max(arr[1] + arr[3], arr[2] + arr[3]);

	for (int i = 4; i <= N; i++) {
		dp[i] = max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
	}

	cout << dp[N] << '\n';
	return 0;


}