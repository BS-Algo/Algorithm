from collections import deque

def bfs(start):
    queue = deque([start])
    visited = [0]* N 

    while queue:
        node = queue.popleft()

        for i in adj_lst[node]:
            if not visited[i]:
                queue.append(i)
                visited[i] = 1
    print(*visited)

N = int(input())
adj_lst = [[] for _ in range(N)]

for i in range(N):
    arr = list(map(int, input().split()))
    for j in range(N):
        if arr[j] == 1:
            adj_lst[i].append(j)

for i in range(N):
    bfs(i)
