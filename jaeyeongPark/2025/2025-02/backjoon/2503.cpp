#include<iostream>
#include<string>
#include<cstring>
using namespace std;

int n, number, strike, ball;
bool arr[1000];
string tmp, one, two;
int strike_cnt, ball_cnt, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;

	memset(arr, true, sizeof(arr));	//초기화(모든 것이 가능하다고 true로 설정)

	for (int i = 123; i <= 999; i++)
	{
		tmp = to_string(i);
		if (tmp[0] == tmp[1] || tmp[0] == tmp[2] || tmp[1] == tmp[2])
			arr[i] = false;//서로 다른 숫자이기에 같은 숫자가 있으면 false설정
		if (tmp[0] - '0' == 0 || tmp[1] - '0' == 0 || tmp[2] - '0' == 0)
			arr[i] = false;
	}

	for (int i = 1; i <= n; i++)
	{
		cin >> number >> strike >> ball;
		for (int i = 123; i <= 999; i++)
		{
			strike_cnt = 0;
			ball_cnt = 0;
			if (arr[i])
			{
				one = to_string(number);
				two = to_string(i);
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (x == y && one[x] == two[y])
							strike_cnt++;
						if (x != y && one[x] == two[y])
							ball_cnt++;
						//같은 숫자가 나올수가 없으니까 이렇게 해도 상관없지 (if/ if)
					}
				}
				if (strike_cnt != strike || ball_cnt != ball)
					arr[i] = false;
			}
		}

	}
	for (int i = 123; i <= 999; i++)
	{
		if (arr[i])
			ans++;
	}
	cout << ans << endl;
	return 0;
}