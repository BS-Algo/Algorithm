INF = float('inf')

DIRECTIONS = [(0, 0), (0, -1), (0, 1), (-1, 0), (1, 0)]
def flip(board, r, c):
    for dy, dx in DIRECTIONS:
        ny, nx = r + dy, c + dx
        if 0 <= ny < 3 and 0 <= nx < 3:
            board[ny][nx] = '.' if board[ny][nx] == '*' else '*'

def solve(r, c, board):
    if r == 3:
        for i in range(3):
            for j in range(3):
                if board[i][j] == "*":
                    return INF
        return 0

    if (c + 1) < 3:
        ny, nx = r, c + 1
    else:
        ny, nx = r + 1, 0

    #현재 칸 클릭 X
    ans = solve(ny, nx, [row[:] for row in board])

    #현재 칸 클릭 O
    flip(board, r, c)
    ans = min(ans, solve(ny, nx, [row[:] for row in board]) + 1)
    flip(board, r, c)

    return ans

tc = int(input())
ans = []
for _ in range(tc):
    board = [list(input()) for _ in range(3)]
    res = solve(0, 0, board)

    if res != INF:
        ans.append(res)

for res in ans:
    print(res)
