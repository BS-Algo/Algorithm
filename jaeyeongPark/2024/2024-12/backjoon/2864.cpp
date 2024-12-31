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
	

    string A, B;

    cin >> A >> B;

    string minA = A, maxA = A, minB = B, maxB = B;

    for (int i = 0; i < A.length(); i++)
    {
        if (A[i] == '5')
            maxA[i] = '6';

        if (A[i] == '6')
            minA[i] = '5';
    }

    for (int i = 0; i < B.length(); i++)
    {
        if (B[i] == '5')
            maxB[i] = '6';

        if (B[i] == '6')
            minB[i] = '5';
    }

    cout << stoi(minA) + stoi(minB) << " " << stoi(maxA) + stoi(maxB) << '\n';

    return 0;

}