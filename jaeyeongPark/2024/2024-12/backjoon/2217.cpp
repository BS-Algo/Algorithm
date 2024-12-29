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
	
	int N;

	cin >> N;
	vector<int> arr;

	//정렬 후, 가장 큰수 부터 해서 정렬후 max값을 그 자리 수 * index + 1 을해서 가장 큰수를 구한다.

	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		arr.push_back(a);
	}

	sort(arr.begin(), arr.end(),greater<int>());

	int max = 0;
	for (int i = 0; i < arr.size(); i++) {
		int t = arr[i] * (i + 1);
		if (t > max) {
			max = t;
		}
	}
	cout << max;

	

	
	return 0;

}