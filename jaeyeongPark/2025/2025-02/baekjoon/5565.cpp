#include <iostream>
using namespace std;

int main() {
    int total_price, sum = 0, book_price;
    cin >> total_price; // 총 가격 입력

    for (int i = 0; i < 9; i++) {
        cin >> book_price; // 9개의 책 가격 입력
        sum += book_price;
    }

    cout << total_price - sum << "\n"; // 남은 책 가격 출력
    return 0;
}
