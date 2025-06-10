from collections import deque
import sys # sys 모듈 임포트 (input() 대신 sys.stdin.readline() 사용 권장)

dx = [0, 0, -1, 1, 0, 0] # 동, 서, 남, 북, 상, 하 (x 변화)
dy = [1, -1, 0, 0, 0, 0] # 동, 서, 남, 북, 상, 하 (y 변화)
dz = [0, 0, 0, 0, -1, 1] # 동, 서, 남, 북, 상, 하 (z 변화)

# L, R, C, build, visited는 전역 변수처럼 사용됩니다.
# point 또한 전역 변수로 E의 좌표를 저장할 것입니다.
point = [] # 'E' 지점의 좌표를 저장할 전역 리스트

def bfs(start_z, start_x, start_y): # 시작 좌표만 인자로 받도록 유지
    global point # point를 전역 변수로 사용하겠다고 명시
    
    queue = deque()
    queue.append((start_z, start_x, start_y, 0)) # (z, x, y, time)
    visited[start_z][start_x][start_y] = True

    while queue:
        z, x, y, time = queue.popleft()
        
        # 'E' 지점에 도달했는지 확인
        if z == point[0] and x == point[1] and y == point[2]:
            return f"Escaped in {time} minute(s)."
        
        # 6가지 방향으로 이동
        for i in range(6): # dx, dy, dz 배열에 접근할 때 사용할 인덱스
            nz = z + dz[i] # z축 이동 (층)
            nx = x + dx[i] # x축 이동 (행)
            ny = y + dy[i] # y축 이동 (열)

            # 유효성 검사: 범위 내인지, 벽이 아닌지, 방문하지 않았는지
            if 0 <= nz < L and 0 <= nx < R and 0 <= ny < C and \
               build[nz][nx][ny] != '#' and not visited[nz][nx][ny]:
                
                visited[nz][nx][ny] = True
                queue.append((nz, nx, ny, time + 1))
    
    return "Trapped!" # 'E'에 도달할 수 없는 경우

while True:
    L, R, C = map(int, sys.stdin.readline().split()) # input() 대신 sys.stdin.readline() 사용
    if L == R == C == 0:
        break
    
    build = [] # 빌딩 정보를 저장할 리스트
    start_s_pos = None # 'S' 지점의 좌표를 저장할 변수

    for i in range(L): # 층(level, z) 반복
        floor_rows = []
        for j in range(R): # 행(row, x) 반복
            row_chars = list(sys.stdin.readline().strip()) # 한 행을 문자로 리스트화
            for k in range(C): # 열(column, y) 반복
                if row_chars[k] == 'S':
                    start_s_pos = (i, j, k) # 'S' 좌표 (z, x, y)
                elif row_chars[k] == 'E':
                    point = [i, j, k] # 'E' 좌표 (z, x, y), 전역 point에 할당
            floor_rows.append(row_chars)
        build.append(floor_rows)
        
        # 중요: 각 층(L)을 읽은 후에는 반드시 빈 줄을 읽어주어야 합니다.
        # 이 부분이 없으면 다음 층의 정보가 아닌 빈 줄을 읽어 문제가 됩니다.
        # 마지막 테스트 케이스의 마지막 층 이후에는 빈 줄이 없거나,
        # 다음 테스트 케이스 시작 전에 빈 줄이 있을 수 있으므로
        # 루프 바깥에서 한 번 더 처리하는 것이 더 안전합니다.
        sys.stdin.readline() # 원래 temp = input() 역할을 합니다.

    # visited 배열은 매 테스트 케이스마다 새로 초기화
    visited = [[[False] * C for _ in range(R)] for _ in range(L)]
    
    # bfs 호출: 'S' 지점에서 시작. 'E' 지점은 이미 point에 저장되어 있습니다.
    if start_s_pos: # 'S' 지점이 유효한지 확인
        print(bfs(start_s_pos[0], start_s_pos[1], start_s_pos[2]))
    else:
        # 문제 조건상 S는 항상 존재한다고 가정
        print("Error: Start point 'S' not found.")