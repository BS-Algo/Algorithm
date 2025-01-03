from collections import deque

def bfs():
    queue = deque()
    queue.append((s, 0))
    visited[s] = 1

    while queue:
        now, cnt = queue.popleft()

        if now == g:
            return cnt

        if now + u <= f and visited[now + u] != 1:
            visited[now + u] = 1
            queue.append((now + u, cnt + 1))

        if now - d > 0 and visited[now - d] != 1:
            visited[now - d] = 1
            queue.append((now - d, cnt + 1))

    return "use the stairs"

f, s, g, u, d = map(int, input().split())
visited = [0] * (f+1)
print(bfs())