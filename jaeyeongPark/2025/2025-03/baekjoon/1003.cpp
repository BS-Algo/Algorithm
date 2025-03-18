#include <iostream>

using namespace std;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, n;
	cin >> T;


	// dp활용 해야함, 재귀활용시 시간 초과
	// n이 40까지
	int dp[41][2] = { 0 };

	// 초기값 설정
	dp[0][0] = 1;
	dp[0][1] = 0;
	dp[1][0] = 0;
	dp[1][1] = 1;

	//DP를 이용해서 0이랑 1의 개수를 미리 계산

	for (int i = 2; i <= 40; i++) {
		dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
		dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
	}

	while (T--) {
		cin >> n;
		cout << dp[n][0] << " " << dp[n][1] << "\n";
	}

	return 0;

}