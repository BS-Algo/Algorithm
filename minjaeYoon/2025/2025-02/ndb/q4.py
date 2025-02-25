# 만들 수 없는 금액
n = int(input())
coin = list(map(int, input().split()))
coin.sort()

# 5
# 3 2 1 1 9
# 정렬하고 하나씩 확인하는 알고리즘

target = 1

for c in coin:
    if target < c:
        break
    target += c
    
print(target)