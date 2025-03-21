from math import gcd

# 두 수를 비교해서 최소공약수가 1인 경우 Pass

# 숫자를 1개 또는 2개 추가하면 된다. 3개의 경우 2개 추가와 다를 것이 없다.

# 따라서 숫자들 간 최대공약수가 1이 되지 않는 경우, 1개 혹은 2개의 숫자를 사이에 추가해 주면 되는 것.

n = int(input())

num_lst = list(map(int, input().split()))
num_lst.sort()
cnt = 0
for i in range(1, n):
    a, b = num_lst[i-1], num_lst[i]
    
    if gcd(a, b) == 1:
        tmp = num_lst[i]
        continue
        
    for j in range(a + 1, b):
        if gcd(a, j) == 1:
            if gcd(j, b) == 1:
                cnt += 1
                break
        if j == (b-1):
            cnt += 2
print(cnt)
