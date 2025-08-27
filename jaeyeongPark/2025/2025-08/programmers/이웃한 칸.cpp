#include <string>
#include <vector>
using namespace std;

vector<int> dx = {0, 0, -1, 1}; 
vector<int> dy = {1, -1, 0, 0}; 

int solution(vector<vector<string>> board, int h, int w) {
    int n = board.size();        
    int m = board[0].size();     
    int count = 0;

    for (int i = 0; i < 4; i++) {
        int ny = h + dy[i]; 
        int nx = w + dx[i]; 

        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
            if (board[h][w] == board[ny][nx]) {
                count++;
            }
        }
    }

    return count;
}
