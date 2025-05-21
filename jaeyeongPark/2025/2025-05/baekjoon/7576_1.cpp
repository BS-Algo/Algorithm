#include <iostream>
#include <vector>
#include <queue>


using namespace std;

int M, N;

//날짜도 2차원 배열이 필요함, bfs기 때문에 동시적으로 날짜가 증가할수도 있기 때문
vector<vector<int>> days;
vector<vector<int>> box;

// 상하좌우
int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };

// 여기서 &는 참조하겠다는 의미, 큐를 복사하지 않고 원본을 직접 사용하겠다는 뜻
void bfs(queue<pair<int,int>> & q) {
    
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        //방향 4방향, 새로운 x,y를 정하고 범위 내의 nx,ny에서 상태를 바꾸면서 날짜를 갱신해야한다.
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //범위 밖
            if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                continue;

            // 안 익은 토마토인 경우만 처리, 날짜갱신
            if (box[nx][ny] == 0) {
                box[nx][ny] = 1;
                days[nx][ny] = days[x][y] + 1;
                q.push({ nx,ny });
            }

        }

    }


}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    box.assign(M, vector<int>(N));
    days.assign(M, vector<int>(N, 0));

    queue<pair<int, int>> q;


    //우선 토마토 전체를 박스 자체에 입력을 받고 익은 토마토 지점을 큐에 저장한다.
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            cin >> box[i][j];
            if (box[i][j] == 1) {
                q.push({ i,j });
            }
        }
    }

    bfs(q);

    int result = 0;
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            // 만약 안익은 토마토가 남아있다면 실패
            if (box[i][j] == 0) {
                cout << -1 << '\n';
                return 0;
            }
            result = max(result, days[i][j]);
        }
    }

    cout << result << '\n';

	return 0;
}
