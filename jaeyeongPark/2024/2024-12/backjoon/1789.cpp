#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long sum;
	cin >> sum;

	//숫자가 워낙 크기때문에 long으로 설정하고 num을 0으로 준다음 sum에 sum-num을 대입, 만약 마이너스면 횟수를 1차감
	int num = 0;
	while (sum > 0) {
		num++;
		sum = sum - num;
	}

	if (sum < 0) {
		num--;
	}
	cout << num;
	


	return 0;
}