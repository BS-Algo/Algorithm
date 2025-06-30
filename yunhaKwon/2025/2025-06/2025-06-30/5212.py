R, C = map(int, input().split())
arr = [list(map(str, input())) for _ in range(R)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
down_arr = []
remain = []
for i in range(R):
    for j in range(C):
        if arr[i][j] == 'X':
            cnt = 0
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if 0 <= nx < R and 0 <= ny < C:
                    if arr[nx][ny] == '.':
                        cnt += 1
                else:
                    cnt += 1

            if cnt >= 3:
                down_arr.append((i, j))

for i, j in down_arr:
    arr[i][j] = '.'

for i in range(R):
    for j in range(C):
        if arr[i][j] == 'X':
            remain.append((i, j))
max_R = 0
min_R = R
max_C = 0
min_C = C
for i, j in remain:
    if i > max_R:
        max_R = i
    if i < min_R:
        min_R = i
    if j > max_C:
        max_C = j
    if j < min_C:
        min_C = j

for i in range(min_R, max_R + 1):
    for j in range(min_C, max_C + 1):
        print(arr[i][j], end = "")
    print()