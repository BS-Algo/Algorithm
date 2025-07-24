#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

int N, M, K;
int x1, y1, x2, y2;

int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };

vector<vector<int>> arr;
vector<vector<bool>> visited;
vector<int> result;

//arr를 채워주는 함수
void fill(int x1, int y1, int x2, int y2) {
    for (int i = y1; i < y2; i++) {
        for (int j = x1; j < x2; j++) {
            arr[i][j] = 1;
        }
    }
}

// 그 칸이 색칠안되어있으면 들어가서 넓이 구하기
void division(int x, int y) {
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;
    int area = 1; 

    while (!q.empty()) {
        auto [cx, cy] = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.push({nx, ny});
                    area++;
                }
            }
        }
    }

    result.push_back(area);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> M >> N >> K;

    arr.resize(N, vector<int>(M, 0)); 
    visited.resize(N, vector<bool>(M, false));

    for (int i = 0; i < K; i++) {
        cin >> x1 >> y1 >> x2 >> y2;
        fill(x1, y1, x2, y2); 
    }

    for (int i = 0; i < N; i++) {     
        for (int j = 0; j < M; j++) { 
            if (arr[i][j] == 0 && !visited[i][j]) {
                division(i, j);
            }
        }
    }
// 이후에 result의 길이만큼이 나눠진 영역 개수이고 result를 정렬한후 앞에서 부터 cout하면 답 아닌가?
    sort(result.begin(), result.end());

    cout << result.size() << '\n';
    for (int i : result) {
        cout << i << ' ';
    }

    return 0;
}
