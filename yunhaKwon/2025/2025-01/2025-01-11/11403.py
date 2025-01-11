from collections import deque

def bfs(x):
    queue = deque()
    queue.append(x)
    check = [0] * N

    while queue:
        v = queue.popleft()

        for i in range(N):
            if check[i] == 0 and graph[v][i] == 1:
                queue.append(i)
                check[i] = 1
                visited[x][i] = 1

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * N for _ in range(N)]

for i in range(N):
    bfs(i)

for g in visited:
    print(*g)