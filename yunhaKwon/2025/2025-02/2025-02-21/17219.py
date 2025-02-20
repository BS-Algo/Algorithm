N, M = map(int, input().split())
graph = {}
for _ in range(N):
    site, password = map(str, input().split())
    graph[site] = password
for _ in range(M):
    find_site = str(input())
    print(graph[find_site])