#include<iostream>
#include<vector>
#include<queue>	

using namespace std;


	// 테트리스처럼 바닥이나 뿌요가 나올때까지 아래로 떨어짐
	// 같은색 뿌요가 상하좌우로 4개이상 연결되어있으면 같은색 뿌요가 없어짐
	// 1연쇄시작, 없어지고 나서 없어진 뿌요위에 다른 뿌요가 있다면 아래로 떨어짐
	// 떨어지면서 또 상하좌우 4개이상 되면 없어짐 1연쇄 추가
	// 연쇄가 몇번 일어날지 계산하기

	// .은 빈 공간이고 R은빨, G는 초, B는 파, P는 보, Y는 노
	// bfs로 델타 탐색하기, 그 칸의 색을 저장하고 상하좌우로 1칸씩 가면서 큐에 저장하고 처음 저장한 색과 같으면 1을 더해서 4이상이 되면 연쇄
	// 아래로 떨어지는거 구현

    const int H = 12;
    const int W = 6;
    vector<string> board(H);

    // 상하좌우 이동
    int dy[4] = { -1, 1, 0, 0 };
    int dx[4] = { 0, 0, -1, 1 };

    // 현재 판에서 터질 그룹이 있는지 탐색하는 함수
    bool bfs(int y, int x, vector<vector<bool>>&visited, vector<pair<int, int>>&to_pop) {
        queue<pair<int, int>> q;
        char color = board[y][x];
        q.push({ y, x });
        visited[y][x] = true;

        // 그룹을 만들고 그룹 수를 계산해서 만약 그룹 사이즈가 4보다 크면 to_pop에 저장

        vector<pair<int, int>> group = { {y, x} };

        while (!q.empty()) {
            auto [cy, cx] = q.front(); q.pop();

            for (int d = 0; d < 4; ++d) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;

                // 같은색이고 방문하지 않았으면 큐에 집어넣기
                if (!visited[ny][nx] && board[ny][nx] == color) {
                    visited[ny][nx] = true;
                    q.push({ ny, nx });
                    group.push_back({ ny, nx });
                }
            }
        }

        // 제거할 좌표들을 저장하기 auto&p로 pair<int,int>를 받아오고, to_pop으로 좌표를 하나씩 복사해서 저장하기, 터질수 있으면 true 반환하기
        if (group.size() >= 4) {
            for (auto& p : group) to_pop.push_back(p);
            return true;
        }
        return false;
    }

    // 터질 뿌요 제거 및 중력 적용
    void apply_gravity() {
        //중력적용하기
        for (int x = 0; x < W; ++x) {
            int write_row = H - 1;
            for (int y = H - 1; y >= 0; --y) {
                if (board[y][x] != '.') {
                    board[write_row][x] = board[y][x];
                    if (write_row != y) board[y][x] = '.';
                    write_row--;
                }
            }
            for (int y = write_row; y >= 0; --y) {
                board[y][x] = '.';
            }
        }
    }

    int main() {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);

        for (int i = 0; i < H; ++i) {
            cin >> board[i];
        }

        int chain_count = 0;

        while (true) {
            vector<vector<bool>> visited(H, vector<bool>(W, false));
            vector<pair<int, int>> to_pop;
            bool popped = false;

            for (int y = 0; y < H; ++y) {
                for (int x = 0; x < W; ++x) {
                    if (board[y][x] != '.' && !visited[y][x]) {
                        if (bfs(y, x, visited, to_pop)) {
                            popped = true;
                        }
                    }
                }
            }

            if (!popped) break;

            
            for (auto& p : to_pop) {
                board[p.first][p.second] = '.';
            }

            apply_gravity();
            chain_count++;
        }

        cout << chain_count << '\n';
        return 0;
    }