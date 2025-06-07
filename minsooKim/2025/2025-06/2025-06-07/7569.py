import sys
input = sys.stdin.readline
from collections import deque
M, N, H = map(int, input().split())
box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

dx = [0,0,-1,1,0,0] # 상하좌우앞뒤
dy = [1,-1,0,0,0,0]
dz = [0,0,0,0,-1,1]

q = deque()
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k]==1:
                q.append((i,j,k,0))

age = []

def bfs():
    while q:
        x,y,z,cnt = q.popleft()
        age.append(cnt+1) # 세대 1 증가시키고 넣어주기
        for i in range(6):
            nx = x + dx[i] # 좌표 이동
            ny = y + dy[i]
            nz = z + dz[i]
            if 0<= nx <H and 0 <= ny <N and 0 <=nz <M: # 인덱스가 범위를 벗어난다면
                if box[nx][ny][nz]==0: # 익지않은 토마토라면
                    box[nx][ny][nz] = 1 # 익히고
                    q.append((nx,ny,nz,cnt+1)) # q에 추가해주기

bfs()
flag = True # 깃발, 익지 않은 토마토가 있다면 False로 바뀜

for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k]==0:
                flag = False

if flag==False: # 익지 않은 토마토가 있다면?
    print(-1)
else: # 없다면 세대들 중에서 가장 높은 세대를 출력
    print(max(age)-1)