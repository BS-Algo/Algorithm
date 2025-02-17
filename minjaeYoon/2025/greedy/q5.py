# 볼링공 고르기
n, m = map(int, input().split())
ball = list(map(int, input().split()))

# 5 3
# 1 3 2 3 2

# 8 5
# 1 5 4 3 2 4 5 2

# n = 볼 갯수, m = 볼 최대 무게

# 최대 무게 만큼 arr
arr = [0] * 11

for b in ball:
    arr[b] += 1
    
res = 0

for i in range(1, m+1):
    n -= arr[i]
    res += arr[i] * n

print(res)