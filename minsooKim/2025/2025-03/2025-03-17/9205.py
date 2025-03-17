from collections import deque

t = int(input())
for _ in range(t):
    n = int(input()) # 편의점 개수
    location = [tuple(map(int, input().split())) for _ in range(n+2)] #시작점, 편의점 좌표, 도착점

    queue = deque([0])
    visited = [False] * (n + 2)
    visited[0] = True

    while queue:
        now = queue.popleft()

        for i in range(1, n+2):
            if not visited[i]:
                dist = abs(location[now][0] - location[i][0]) + abs(location[now][1] - location[i][1])

                if dist <= 1000:
                    queue.append(i)
                    visited[i] = True
   
    if visited[n+1] == True:
        print("happy")
    else:
        print("sad")