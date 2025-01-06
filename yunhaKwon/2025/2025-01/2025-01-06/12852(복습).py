from collections import deque

def bfs():
    queue = deque()
    queue.append((n, [n]))

    while queue:
        x, path = queue.popleft()
        if x == 1:
            print(len(path) - 1)
            print(*path)
            break
        if x % 3 == 0:
            queue.append((x // 3, path + [x // 3]))
        if x % 2 == 0:
            queue.append((x // 2, path + [x // 2]))
        queue.append((x - 1, path + [x - 1]))

n = int(input())
bfs()