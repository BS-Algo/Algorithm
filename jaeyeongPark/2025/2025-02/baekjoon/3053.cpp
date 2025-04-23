#include <iostream>
#include <cmath>
using namespace std;

int main() {
    double R;
    cin >> R;

    // 유클리드 기하학 원의 넓이
    double euclidean_area = M_PI * R * R;
    
    // 택시 기하학 원의 넓이
    double taxi_area = 2 * R * R;

    cout << fixed;
    cout.precision(6); // 소수점 6자리까지 출력

    cout << euclidean_area << "\n";
    cout << taxi_area << "\n";

    return 0;
}
