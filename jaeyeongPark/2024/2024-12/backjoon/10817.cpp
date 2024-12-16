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

    int arr[3];

    
    for (int i = 0; i < 3; i++) //입력받기
        cin >> arr[i];

    sort(arr, arr + 3); //오름차순 정렬

    cout << arr[1]; //두번째로 큰 값 출력
    


	return 0;
}