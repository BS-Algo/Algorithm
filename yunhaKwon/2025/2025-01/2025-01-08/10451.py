def dfs(start):
    visited[start] = 1

    for i in graph[start]:
        if not visited[i]:
            dfs(i)

T = int(input())
for _ in range(T):
    N = int(input())
    graph = [[] for _ in range(N+1)]
    seq = list(map(int, input().split()))
    for i in range(1, N+1):
        graph[i].append(seq[i-1])

    visited = [0] * (N+1)
    cnt = 0

    for i in range(1, N+1):
        if not visited[i]:
            dfs(i)
            cnt += 1

    print(cnt)