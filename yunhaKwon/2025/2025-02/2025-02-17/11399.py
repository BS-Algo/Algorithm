n = int(input())
lst = list(map(int,input().split()))
lst.sort()

res = 0
time = 0

for i in range(n):
    time += lst[i]
    res += time

print(res)