from collections import deque

dx = [0, 0, 0, 1, -1]
dy = [0, 1, -1, 0, 0]

def flip(board, x, y):
    for k in range(5):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < N and 0 <= ny < N:
            board[nx][ny] = 1 - board[nx][ny]

def bfs(start_board):
    queue = deque()
    queue.append((start_board, 0))
    visited = set()
    visited.add(str(start_board))

    while queue:
        board, cnt = queue.popleft()

        if board == [[0, 0, 0,], [0, 0, 0,], [0, 0, 0]]:
            return cnt
        
        for x in range(3):
            for y in range(3):
                new_board = [row[:] for row in board]
                flip(new_board, x, y)
                board_state = str(new_board)

                if board_state not in visited:
                    visited.add(board_state)
                    queue.append((new_board, cnt+1))


P = int(input())
N = 3
for _ in range(P):
    board = [list(map(str, input())) for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if board[i][j] == '*':
                board[i][j] = 1
            else:
                board[i][j] = 0
    print(bfs(board))