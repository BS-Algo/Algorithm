#include <iostream>
#include <algorithm>
using namespace std;

long long int ucl(long long int a, long long int b)
{
	long long int c;
	c = a % b;
	if (c != 0)
		return ucl(b, c);
	else
		return b;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	long long int c;
	long long int a, b;
	long long int result;
	cin >> a >> b;
	if (a > b)
		c = ucl(a, b);
	else
		c = ucl(b, a);
	result = c * (a / c) * (b / c);
	cout << result;
	return 0;
}