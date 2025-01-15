#include <iostream>

using namespace std;

int n, price = 0, p, mmax = 0;
string name, maxname;

int main(void)
{
    cin >> n;
    
    for (int i=1; i <= n; i++) {
        cin >> p;
        mmax = 0;
        maxname = "";
        for (int j=1; j <= p; j++) {
            cin >> price >> name;
            if (price > mmax) {
                mmax = price;
                maxname = name;
            }
            
        }
        cout << maxname << "\n";
            
    }
}