#include <iostream>
#include <string>
using namespace std;

int main()
{
    int N, sum = 0;
    string n;

    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> n;

        int tf = 1;

        for (int j = 0; j < n.length(); j++)
        {
            for (int k = j + 1; k < n.length(); k++)
            {
                if (n[k - 1] != n[j] && n[k] == n[j])
                {
                    tf = 0;
                    break;
                }
            }

            if (tf == 0)
                break;
        }

        if (tf == 1)
            sum++;
    }

    cout << sum << '\n';

    return 0;
}