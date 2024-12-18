#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;
string s;
int result = 0;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);




	cin >> s;

	for(int i=0;i<s.length();i++) 
		if(s[i]!=s[i+1]) 
			result++;

	if(!result) 
		cout << result;
	else cout << result/2;

	return 0;
}