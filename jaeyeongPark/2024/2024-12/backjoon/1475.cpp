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

	//먼저 숫자를 인덱스로 접근하기 위해 string으로 받아옴
	string num;
	cin >> num;

	//0부터9까지의 배열을 만들고
	int arr[10] = { 0 };

	//입력받은 문자열을 하나씩 돌면서 숫자로변환시키고, 그 숫자에 맞는 인덱스에 배열을 +1을 시킴
	// 6이랑 9는 동일하게 작성하며 6부터 입력받고 만약 6또는 9가 입력했을때 작은수부터 입력되게 만듬
	
	for (int i = 0; i < num.length(); i++) {
		//string을 숫자로 변환해야함
		//int N = num[i]-'0';
		int N = num[i] - '0';
		if (N == 9 or N==6) {
			if (arr[6] != arr[9]) {
				arr[9] += 1;
			}
			else {
				arr[6] += 1;
			}
		}
		else {
			arr[N] += 1;
		}
	}

	//배열중 가장 큰수가 세트 수
	int max = *max_element(arr, arr + 10);
	
	cout << max;


	return 0;
}