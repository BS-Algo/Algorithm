#include <iostream>
#include <vector>

using namespace std;

int k;
vector<int> s;
vector<int> selected;

//조합문제인데 순서가 없고 오름차순 >> 중복없이 백트래킹

void dfs(int index, int count) {
	if (count == 6) {
		for (int num : selected) {
			cout << num << ' ';
		}
		cout << '\n';
		return;
	}

	for (int i = index; i < k; i++) {
		selected.push_back(s[i]);
		dfs(i + 1, count + 1);
		selected.pop_back();
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	while (true) {
		cin >> k;
		if (k == 0) break;

		s.clear();
		selected.clear();

		for (int i = 0; i < k; i++) {
			int num;
			cin >> num;
			s.push_back(num);
		}

		dfs(0, 0);
		cout << '\n';
	}

	return 0;
}
