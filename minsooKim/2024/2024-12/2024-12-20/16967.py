H, W, X, Y = map(int, input().split())

# B 배열 입력받기
B_arr = []
for _ in range(H + X):
    B_arr.append(list(map(int, input().split())))

# A 배열 초기화
A_arr = [[0] * W for _ in range(H)]

# A 배열 채우기
for i in range(H):
    for j in range(W):
        if i >= X and j >= Y:
            A_arr[i][j] = B_arr[i][j] - A_arr[i - X][j - Y]
        else:
            A_arr[i][j] = B_arr[i][j]

# 결과 출력
for row in A_arr:
    print(*row)
