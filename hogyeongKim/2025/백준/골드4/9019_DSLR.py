from collections import deque

operations = {
    'D': lambda n: (n * 2) % 10000,
    'S': lambda n: (n - 1 + 10000) % 10000,
    'L': lambda n: (n % 1000) * 10 + n // 1000,
    'R': lambda n: (n % 10) * 1000 + n // 10
}

for _ in range(int(input())):
    start, end = map(int, input().split())
    visited = [False] * 10000
    visited[start] = True
    def bfs(sx, pth):
        global end
        q = deque([(sx, pth)])
        while q:
            x, p = q.popleft()
            for cmd in 'DSLR':
                nx = operations[cmd](x)
                if nx == end:
                    return p + cmd
                if not visited[nx]:
                    visited[nx] = True
                    q.append((nx, p + cmd))
    print(bfs(start, ''))