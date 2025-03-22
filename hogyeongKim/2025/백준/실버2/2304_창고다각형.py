# 완전탐색, 다이나믹 프로그래밍(메모이제이션, 누적합)
N = int(input())

data_lst = [list(map(int, input().split())) for _ in range(N)]

# 박스가 최대 어디까지 있는지 알기 위해 정렬
data_lst.sort()

# 가장 마지막 값의 x가 마지막에 위치한 기둥의 좌표
x = data_lst[N-1][0]

# 박스의 index로 계산하기 편하게 x+1만큼 dp 생성
box_lst = [0] * (x + 1)

# 우선 기둥 좌표에 맞게 높이 설정
for data in data_lst:
    x, h = data
    box_lst[x] = h

# 최대 기둥 한 곳의 좌표와 높이만 알면 되므로 최대 높이와 좌표 구하기
mx_height = max(box_lst)
mx_idx = box_lst.index(mx_height)

# 왼쪽에서 최대 좌표까지 큰 값으로 덮어쓰기
for i in range(1, mx_idx):
    box_lst[i] = max(box_lst[i], box_lst[i-1])

# 오른쪽에서 최대 좌표까지 큰 값으로 덮어쓰기
for i in range(x-1, mx_idx, -1):
    box_lst[i] = max(box_lst[i], box_lst[i+1])

# 전체 합을 구하면 됨(사각형의 넓이이므로 전체합과 동일)
print(sum(box_lst))