from collections import deque

def bfs():
    queue = deque()
    queue.append(s)
    visited[s] = 1

    while queue:
        now = queue.popleft()

        if now == g:
            return visited[now] - 1

        else:
            for i in (now + u, now - d):
                if (0 < i <= f) and visited[i] == 0:
                    visited[i] = visited[now] + 1
                    queue.append(i)

    return "use the stairs"

f, s, g, u, d = map(int, input().split())
visited = [0] * (f+1)
print(bfs())