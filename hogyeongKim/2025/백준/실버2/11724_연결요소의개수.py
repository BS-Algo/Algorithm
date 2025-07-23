import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graphs = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graphs[a].append(b)
    graphs[b].append(a)

visited = [False] * (n+1)

def dfs(start):
    stack = [start]

    while stack:
        node = stack.pop()

        for next_node in graphs[node]:
            if not visited[next_node]:
                visited[next_node] = True
                stack.append(next_node)

cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        visited[i] = True
        dfs(i)
        cnt += 1
print(cnt)