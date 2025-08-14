import sys
from collections import deque, defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())
ladder_snakes = defaultdict(int)

for _ in range(n+m):
    a, b = map(int, input().split())
    ladder_snakes[a] = b

def bfs():
    visited = [False] * 101
    visited[1] = True
    q = deque([(1, 0)])
    while q:
        x, cnt = q.popleft()

        if x == 100:
            return cnt

        for dice in range(1, 7):
            nx = x+dice

            if nx <= 100 and not visited[nx]:
                if nx in ladder_snakes:
                    nx = ladder_snakes[nx]

                if not visited[nx]:
                    visited[nx] = True
                    q.append((nx, cnt+1))

print(bfs())