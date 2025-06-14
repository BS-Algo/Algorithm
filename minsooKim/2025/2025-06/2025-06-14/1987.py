from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(x, y, count):
    global max_cnt

    max_cnt = max(max_cnt, count)

    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]

        if 0 <= nx < R and 0 <= ny < C:
            alpha_index = ord(board[nx][ny]) - ord('A')
            if not visited[alpha_index]:
                visited[alpha_index] = True
                dfs(nx, ny, count + 1)
                visited[alpha_index] = False

R, C = map(int, input().split())
board = [list(map(str, input())) for _ in range(R)]
visited = [False] * 26
max_cnt = 1
visited[ord(board[0][0]) - ord('A')] = True

dfs(0, 0, 1)
print(max_cnt)
