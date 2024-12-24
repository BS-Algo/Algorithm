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
	
	// 5로나눈 몫을 가지고 5*(몫-n) 한것을 원래 값을 뺀후 2로 나눌수있는지 봐야한다. n은 0부터 몫까지
	// 만약 몫-1이 0이 되고도 2로 안나눠 진다면 -1을 출력한다.

	int n;
	cin >> n;

	
	int x = n / 5;
	int five;
	int two;
	int result;

	for (int i = 0; i <= x; i++) {
		if ((n - (5 * (x - i))) % 2 == 0) {
			five = x-i;
			two = (n - (5 * (x - i))) / 2;
			result = five + two;
			cout << result;
			break;
		}
		else if (i == x and (n - (5 * (x - i))) % 2 != 0) {
			result = -1;
			cout << result;
		}
	}

	
	return 0;

}