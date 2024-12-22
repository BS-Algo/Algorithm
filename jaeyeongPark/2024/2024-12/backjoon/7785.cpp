#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;

	vector<string> arr;
	map<string, string, greater<string>> m;

	for (int i = 0; i < n; i++) {
		string name;
		string state;

		cin >> name >> state;
		if (state == "enter") {
			m.insert(make_pair(name, state));
		}
		else {
			m.erase(name);
		}
	}
	for (auto it : m) {
		cout << it.first << "\n";
	}
	return 0;

}