#include <iostream>
#include <vector>

using namespace std;

int M, N; 

// d는 방향
int r, c, d;

//room에 0,1,2로 상태 표현하기
vector<vector<int>> room;

// 북(0), 동(1), 남(2), 서(3)
int dx[4] = { -1, 0, 1, 0 }; // 행 변화
int dy[4] = { 0, 1, 0, -1 }; // 열 변화

// 처음 상태
int cleaned = 0;

bool isIn(int x, int y) {
    return x >= 0 && x < M&& y >= 0 && y < N;
}

void simulate() {
    while (true) {
        //칸이 청소되지 않은 경우
        if (room[r][c] == 0) {
            room[r][c] = 2;
            cleaned++;
        }

        // 4칸 중 청소되지 않은 곳이 있는지 확인
        bool found = false;
        for (int i = 0; i < 4; ++i) {
            // 왼쪽 회전
            d = (d + 3) % 4; 
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (isIn(nx, ny) && room[nx][ny] == 0) {
                r = nx;
                c = ny;
                found = true;
                break;
            }
        }

        if (!found) {
            // 후진
            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            // 벽이면 종료
            if (!isIn(bx, by) || room[bx][by] == 1)
                return; 

            r = bx;
            c = by;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> M >> N;
    cin >> r >> c >> d;

    room.assign(M, vector<int>(N));
    for (int i = 0; i < M; ++i)
        for (int j = 0; j < N; ++j)
            cin >> room[i][j];

    simulate();

    cout << cleaned << '\n';
    return 0;
}
