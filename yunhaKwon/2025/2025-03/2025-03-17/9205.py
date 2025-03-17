import sys
input = sys.stdin.readline
from collections import deque

def bfs():
    q = deque()
    q.append((home_x, home_y))

    while q:
        x, y = q.popleft()
        if abs(x - dest_x) + abs(y - dest_y) <= 1000:
            print('happy')
            return

        else:
            for i in range(n):
                if not visited[i]:
                    nx, ny = graph[i]
                    if abs(x - nx) + abs(y - ny) <= 1000:
                        visited[i] = 1
                        q.append((nx, ny))

    print('sad')
    return

t = int(input())
for _ in range(t):
    n = int(input())
    home_x, home_y = map(int, input().split())

    graph = []
    for _ in range(n):
        con_x, con_y = map(int, input().split())
        graph.append((con_x, con_y))

    dest_x, dest_y = map(int, input().split())

    visited = [0] * (n+1)
    bfs()