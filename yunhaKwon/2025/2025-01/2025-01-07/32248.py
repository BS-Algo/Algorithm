def bfs(start):
    visited = {}
    cnt = 0
    x = start

    while cnt < t:
        # 사이클 처리
        if x in visited:
            cycle_start = visited[x]
            cycle_length = cnt - cycle_start

            remaining_steps = (t - cnt) % cycle_length
            for _ in range(remaining_steps):
                x = graph[x]
            return x

        visited[x] = cnt
        cnt += 1
        x = graph[x]

    return x

n, t = map(int, input().split())
point_num = list(map(int, input().split()))

graph = [0] * (n + 1)
for i in range(1, n + 1):
    graph[i] = point_num[i - 1]

print(bfs(1))
