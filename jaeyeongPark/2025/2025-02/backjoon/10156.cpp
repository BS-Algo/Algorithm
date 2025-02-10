#include <iostream>
using namespace std;

int main() {
    int price_per_snack, quantity, money;
    cin >> price_per_snack >> quantity >> money;

    int total_cost = price_per_snack * quantity;
    int result = (total_cost > money) ? (total_cost - money) : 0;

    cout << result << "\n";
    return 0;
}
