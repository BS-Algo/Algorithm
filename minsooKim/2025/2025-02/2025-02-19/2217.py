N = int(input())
arr = []
for _ in range(N):
    arr.append(int(input()))
arr.sort()
# N = 5
# arr = [1, 3, 5, 7, 9]
# 로프 1개 = 9
# 로프 2개 = 7, 9 사용 14
# 로프 3개 = 5, 7, 9 사용 15
# 로프 4개 = 3, 5, 7, 9 사용, 12
# 로프 5개 = 1, 3, 5, 7, 9 사용, 5
# 따라서 lst = [9, 14, 15, 12, 5]

lst = []
for i in range(1, N+1):
    lst.append(i * arr[-i])
print(max(lst))