#include<iostream>
#include<vector>
using namespace std;

int n, s;

vector<int> arr;
vector<int> result;

int count_ans = 0;

// 백트래킹 함수를 만들어서 만약 1개로 s가 되는거 부터 n개까지 자릿수를 1개씩 더해가면서 return을 주면됨
// 더해야하는 숫자의 개수를 인자로 전달하기
// 0 즉, 1개씩 다 result에 넣고 k를 1로 증가하고 리턴, arr에 모든 수를 다 더하면 k를 1증가 시키고 리턴


void back(int k, int sum) {
	// k:  현재 몇번째 원소를 보고있는지
	// sum : 지금까지 선택한 원소들의 합

	if (k == n) {
		if (!result.empty() && sum == s) {
			count_ans++;
		}
		return;
	}
	result.push_back(arr[k]);
	back(k + 1, sum + arr[k]);
	result.pop_back();

	back(k + 1, sum);
}



int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> s;
	arr.resize(n);

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	back(0,0);


	cout << count_ans;
	return 0;
}