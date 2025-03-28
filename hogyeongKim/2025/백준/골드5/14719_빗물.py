
# 세로 H, 가로 W
H, W = map(int, input().split())

# 블록의 높이 0 이상 H 이하
heights = list(map(int, input().split()))

# 가장 높은 기둥
mx_height = max(heights)

idx = heights.index(mx_height)

result = 0
cur_idx = 0
# 왼쪽부터 탐색
# 시작 인덱스는 0, 가장 큰 값의 인덱스까지 탐색
for i in range(0, idx + 1):
    # 만약 시작 인덱스와 같거나 큰 값을 만나면 계산 수행
    if heights[i] >= heights[cur_idx]:
        for j in range(cur_idx, i):
            result += heights[cur_idx] - heights[j]
        cur_idx = i

# 오른쪽부터 탐색
cur_idx = W - 1
for i in range(W-1, idx - 1, -1):
    if heights[i] >= heights[cur_idx]:
        for j in range(cur_idx, i, -1):
            result += heights[cur_idx] - heights[j]
        cur_idx = i

print(result)