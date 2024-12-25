N, M = map(int, input().split())
graph = []
for _ in range(N):
    arr = list(map(int, input().split()))
    graph.append(arr)
K  = int(input())
result = []
for x in range(K):
    a, b, c, d= map(int, input().split())
    for i in range(a, c):
        for j in range(b, d):
            result.append(graph[i][j])
print(result)
