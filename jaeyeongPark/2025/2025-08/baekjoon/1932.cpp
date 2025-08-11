#include<iostream>
#include<vector>
#include <algorithm>

using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;

	// 삼각형 값이랑 dp가 진행되면서 다 더한 이전 값 두개 배열을 만듬
	vector<vector<int>> triangle(n, vector<int>(n, 0));
	vector<vector<int>> dp(n, vector<int>(n, 0));


	for (int i = 0;i < n; i++) {
		for (int j = 0; j <= i; j++) {
			cin >> triangle[i][j];
		}
	}


	dp[0][0] = triangle[0][0];

	//제일 왼쪽일 때에는 오른쪽이랑 더하고, 제일 오른쪽일때에는 왼쪽인 애랑 더해야함
	//중간은 둘중에 큰 애랑 더하기
	for (int i = 1; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0) {
				dp[i][j] = dp[i - 1][j] + triangle[i][j];
			}
			else if (j == i) {
				dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
			}
			else {
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}
	}

	cout << *max_element(dp[n - 1].begin(), dp[n - 1].end()) << "\n";
	return 0;
}