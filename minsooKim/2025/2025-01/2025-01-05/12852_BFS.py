from collections import deque

def bfs(start):
    # 각 숫자의 경로를 저장하는 배열
    parent = [0] * (start + 1)
    queue = deque([(start, 0)])  # (현재 숫자, 연산 횟수)
    visited = [False] * (start + 1)
    visited[start] = True

    while queue:
        n, cnt = queue.popleft()

        # 1에 도달했으면 결과 반환
        if n == 1:
            path = []
            while n > 0:  # 경로 추적
                path.append(n)
                n = parent[n]
            return cnt, path

        # n - 1 상태 추가
        if n - 1 >= 1 and not visited[n - 1]:
            visited[n - 1] = True
            queue.append((n - 1, cnt + 1))
            parent[n - 1] = n  # 이전 숫자를 기록

        # n // 2 상태 추가
        if n % 2 == 0 and not visited[n // 2]:
            visited[n // 2] = True
            queue.append((n // 2, cnt + 1))
            parent[n // 2] = n  # 이전 숫자를 기록

        # n // 3 상태 추가
        if n % 3 == 0 and not visited[n // 3]:
            visited[n // 3] = True
            queue.append((n // 3, cnt + 1))
            parent[n // 3] = n  # 이전 숫자를 기록

# 입력 및 출력
N = int(input())
min_count, path = bfs(N)
print(min_count)
print(*path)
