from collections import deque

def bfs(start):
    queue = deque()
    queue.append((start, 0))
    visited[start] = 1

    while queue:
        n, cnt = queue.popleft()

        if n == g:
            print(cnt)
            return
        
        if n+u <= f and not visited[n+u]:
            visited[n+u] = 1
            queue.append((n+u, cnt+1))
        if n-d >= 1 and not visited[n-d]:
            visited[n-d] = 1
            queue.append((n-d, cnt + 1))

    return "use the stairs"

f, s, g, u, d = map(int, input().split())
visited = [0] * (f+1)
bfs(s)