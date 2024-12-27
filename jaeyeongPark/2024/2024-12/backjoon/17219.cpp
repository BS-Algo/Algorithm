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
	
	int N,M;
	map<string, string> m;
	string a, b;

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> a >> b;
		m[a] = b;
	}

	for (int i = 0; i < M; i++) {
		cin >> a;

		cout << m[a] << '\n';
	}

	

	
	return 0;

}