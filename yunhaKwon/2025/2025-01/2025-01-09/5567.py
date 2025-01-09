N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

ans = 0
for friend in graph[1]:
    if not visited[friend]:
        visited[friend] = 1
        ans += 1

for friend in graph[1]:
    for friend_of_friend in graph[friend]:
        if not visited[friend_of_friend] and friend_of_friend != 1:
            visited[friend_of_friend] = 1
            ans += 1

print(ans)
