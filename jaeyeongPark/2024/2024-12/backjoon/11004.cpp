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
	int k;
	cin >> n >> k;

	long long int arr[5000000];
	

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		
	}
	
	sort(arr, arr + n);

	cout << arr[k-1];
	
	return 0;

}