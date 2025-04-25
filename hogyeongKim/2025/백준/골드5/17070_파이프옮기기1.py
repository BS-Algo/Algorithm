import sys
input = sys.stdin.readline
dt = [(1, 0), (0, 1), (1, 1)]

n = int(input())

house = [list(map(int, input().split())) for _ in range(n)]

# 3중 리스트. [x방향][y방향][파이프방향]
pipe = [[[0]*3 for _ in range(n)] for _ in range(n)]

# 첫 파이프는 0, 1에서 가로 방향으로 시작
pipe[0][1][0] = 1

for i in range(n):
    for j in range(n):
        # 진행 방향 확인
        if house[i][j] == 1:
            continue
        
        # 파이프가 가로 방향으로 갔을 때
        if j > 0:
            # 이전에 가로, 대각선인 경우 확인
            pipe[i][j][0] += pipe[i][j-1][0] + pipe[i][j-1][2]
        
        # 파이프가 세로 방향으로 갔을 때
        if i > 0:
            # 이전에 세로, 대각선인 경우 확인
            pipe[i][j][1] += pipe[i-1][j][1] + pipe[i-1][j][2]
        
        # 파이프가 대각선으로 갔을 때
        if i > 0 and j > 0 and house[i-1][j] != 1 and house[i][j-1] != 1:
            #이전의 모든 방향 확인
            pipe[i][j][2] += pipe[i-1][j-1][0] + pipe[i-1][j-1][1] + pipe[i-1][j-1][2]
        
print(sum(pipe[n-1][n-1]))