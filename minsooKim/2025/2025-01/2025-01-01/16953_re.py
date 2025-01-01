from collections import deque
def bfs(start, num):
    queue = deque()
    queue.append((start, num))

    while queue:
        n, cnt = queue.popleft()
        if n > B:
            continue
        if n == B:
            print(cnt)
            return
        queue.append((n * 2 , cnt + 1))
        queue.append((int(str(n)+ "1"), cnt + 1))
    
    print(-1)

A, B = map(int, input().split())
bfs(A, 1)
