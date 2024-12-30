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
	

	int coin[6] = { 500,100,50,10,5,1 };
	int money;

	cin >> money;

	int lift = 1000 - money;
	int cnt = 0;

	for (int i = 0; i < 6; i++) {
		while (lift >= coin[i]) {
			lift -= coin[i];
			cnt++;
		}
	}

	cout << cnt << endl;

	
	
	

	
	return 0;

}