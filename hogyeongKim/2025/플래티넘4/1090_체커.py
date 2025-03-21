N = int(input())

checker_lst = [list(map(int, input().split())) for _ in range(N)]

# 한 곳에서 모인다고 할 때, 비용을 최소화 하려면 각 x좌표 중 한 곳, 각 y좌표 중 한 곳에서 모이는 것이 최소화.
x_lst = [checker[0] for checker in checker_lst]
y_lst = [checker[1] for checker in checker_lst]
x_lst, y_lst = set(x_lst), set(y_lst)

# for문 1: k의 개수
# for문 2, 3: 좌표 구하기(오름차순으로 정렬)
dist_lst = [1000000*N] * N

for x in list(x_lst):
    for y in list(y_lst):
        temp_lst = []
        for checker in checker_lst:
            cur_x, cur_y = checker
            temp_lst.append(abs(cur_x - x) + abs(cur_y - y))
        temp_lst.sort()
        result = 0
        for i in range(N):
            result += temp_lst[i]
            dist_lst[i] = min(result, dist_lst[i])
    
print(*dist_lst)