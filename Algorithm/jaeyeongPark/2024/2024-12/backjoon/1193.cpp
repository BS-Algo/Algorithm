#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int line = 1;
	int x;
	cin >> x;

	//X가 위치한 대각선 찾기
	while (x - line > 0) {
		x -= line;
		line++;
	}


	if (line % 2) cout << line + 1 - x << '/' << x;
	else cout << x << '/' << line + 1 - x;
	return 0;
}