N = 10
lst = []
num = 0
for _ in range(N):
    start, end = map(int, input().split())
    num -= start
    num += end
    lst.append(num)
print(lst)

