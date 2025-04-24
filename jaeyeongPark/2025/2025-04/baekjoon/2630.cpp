#include <iostream>
using namespace std;

int paper[128][128];
int white = 0, blue = 0;

void divide(int x, int y, int size) {
    int color = paper[x][y];
    bool same = true;

    for (int i = x; i < x + size; i++) {
        for (int j = y; j < y + size; j++) {
            if (paper[i][j] != color) {
                same = false;
                break;
            }
        }
        if (!same) break;
    }

    if (same) {
        if (color == 0) white++;
        else blue++;
    } else {
        int half = size / 2;
        divide(x, y, half);               // 좌상
        divide(x, y + half, half);        // 우상
        divide(x + half, y, half);        // 좌하
        divide(x + half, y + half, half); // 우하
    }
}

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> paper[i][j];

    divide(0, 0, N);

    cout << white << "\n" << blue << "\n";
    return 0;
}
