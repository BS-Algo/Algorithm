import sys

sys.setrecursionlimit(10 ** 6)

N = int(input())
visited = [0] * (N+1)
graph = [[] for _ in range(N+1)]
answer = [0] * (N+1)

for _ in range(1, N):
    n1, n2 = map(int, input().split())
    graph[n1].append(n2)
    graph[n2].append(n1)

def dfs(number):
    visited[number] = 1
    for i in graph[number]:
        if not visited[i]:
            answer[i] = number
            dfs(i)

dfs(1)

for i in range(2, N+1):
    print(answer[i])