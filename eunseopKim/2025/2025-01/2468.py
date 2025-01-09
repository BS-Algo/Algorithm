from collections import deque

di = [0, 0, 1, -1]
dj = [1, -1, 0, 0]


def bfs(si, sj, h):
    queue = deque()
    queue.append((si, sj))
    visited[si][sj] = 1

    while queue:
        ci, cj = queue.popleft()
        for dir in range(4):
            ni = ci + di[dir]
            nj = cj + dj[dir]
            if 0 <= ni < N and 0 <= nj < N and not visited[ni][nj] and arr[ni][nj] > h:
                queue.append((ni, nj))
                visited[ni][nj] = 1


def solve(h):
    cnt = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and arr[i][j] > h:
                bfs(i, j, h)
                cnt += 1
    return cnt


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = 0
for h in range(100):
    visited = [[0] * N for _ in range(N+1)]
    ans = max(ans, solve(h))
print(ans)
