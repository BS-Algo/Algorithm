#include<iostream>
#include<vector>
using namespace std;


// 생성자로 셀프넘버를 만드는 함수
int d(int num) {
	int sum = num;
	//num가 0이 아니면 num을 10으로 나눈 나머지를 더하고 10으로 나눈다. 이러면 자리수를 줄여가며 각 자리수를 더할수 있다.
	while (num != 0) {
		sum = sum + (num % 10);
		num = num / 10;
	}
	return sum;
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	//전체 10000까지 전부 false로 하기
	bool check[10001]{ false };

	//1부터 10000까지 for문을 돌면서 생성자가 있는 셀프넘버를 전부 true로 바꾼다.
	for (int i = 1; i < 10001; i++) 
	{
		int n = d(i);
		if (n < 10001) 
		{
			check[n] = true;
		}
	}
	// false만 출력한다.
	for (int i = 1; i < 10001; i++) {
		if (!check[i]) {
			cout << i << "\n";
		}
	}
	return 0;
	

	
}