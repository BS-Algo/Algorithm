from collections import deque

def bfs():
    queue = deque()
    queue.append((N, [N]))

    while queue:
        num, path = queue.popleft()
        if num == 1:
            print(len(path) - 1)
            print(*path)
            break

        if not visited[num]:
            visited[num] = 1
            if num % 3 == 0:
                queue.append((num // 3, path + [num // 3]))

            if num % 2 == 0:
                queue.append((num // 2, path + [num // 2]))

            queue.append((num - 1, path + [num - 1]))

N = int(input())
visited = [0] * (N + 1)
bfs()