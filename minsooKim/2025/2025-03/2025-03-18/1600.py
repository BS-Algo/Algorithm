from collections import deque

# 말처럼 이동할 수 있는 경우의 수 (8방향)
horse_moves = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
# 원숭이처럼 이동 (상하좌우)
monkey_moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def bfs():
    queue = deque()
    queue.append((0, 0, K))  # (행, 열, 남은 말 이동 횟수)
    visited[0][0][K] = 0  # 시작 지점 방문 처리 (이동 횟수 저장)

    while queue:
        x, y, horse_left = queue.popleft()

        # 도착하면 종료
        if x == H - 1 and y == W - 1:
            return visited[x][y][horse_left]

        # 원숭이처럼 이동 (상하좌우)
        for dx, dy in monkey_moves:
            nx, ny = x + dx, y + dy
            if 0 <= nx < H and 0 <= ny < W and arr[nx][ny] == 0 and visited[nx][ny][horse_left] == -1:
                visited[nx][ny][horse_left] = visited[x][y][horse_left] + 1
                queue.append((nx, ny, horse_left))

        # 말처럼 이동 (8방향) → 남은 횟수 있을 때만 가능
        if horse_left > 0:
            for dx, dy in horse_moves:
                nx, ny = x + dx, y + dy
                if 0 <= nx < H and 0 <= ny < W and arr[nx][ny] == 0 and visited[nx][ny][horse_left - 1] == -1:
                    visited[nx][ny][horse_left - 1] = visited[x][y][horse_left] + 1
                    queue.append((nx, ny, horse_left - 1))

    return -1  # 도착 못하는 경우

# 입력 처리
K = int(input())
W, H = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(H)]

# 방문 체크 배열 (x, y, 남은 말 이동 횟수)
visited = [[[-1] * (K + 1) for _ in range(W)] for _ in range(H)]

# BFS 실행 후 출력
print(bfs())
