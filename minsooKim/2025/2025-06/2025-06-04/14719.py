H, W = map(int, input().split())
block = list(map(int, input().split()))
arr = [[0] * W for _ in range(H)]

# 빗물이 내렸을 때 2차원 배열
for i in range(W):
    for j in range(H-block[i], H):
        arr[j][i] = 1

# 각 행을 돌면서 스택을 사용해보면 어떨까?
# 1 0 0 1 1 0 0 0의 경우 스택에 1을 넣고, 다음 1이 들어올때까지 cnt를 증가. 
# 만약 다음 1이 들어오면 안에있던 1을 pop.
cnt = 0

for i in range(H):
    # 각 행에서 왼쪽 벽과 오른쪽 벽을 찾아야 함
    left_wall = -1

    for j in range(W):
        if arr[i][j] == 1:
            if left_wall == -1:
                left_wall = j
                # left_wall = j = 1
            else:
                # 왼쪽 벽부터 현재있는 공간까지 cnt에 추가
                for k in range(left_wall +1, j):
                    if arr[i][k] == 0:
                        cnt += 1
                left_wall = j
print(cnt)

# 0 0 0 1   
# 1 0 0 1   #[1][0] [1][1] [1][2] [1][3]
# 1 0 0 1
# 1 0 1 1
        
# 0 0 0 0 1 0 0 0
# 1 0 0 1 1 0 0 0
# 1 0 1 1 1 0 0 1
# 1 1 1 1 1 1 1 1