# 모험가 길드
n = int(input())
fear = list(map(int, input().split()))
fear.sort()

result = 0
cnt = 0

for i in fear:
    cnt += 1
    if cnt >= i:
        result += 1
        cnt = 0
        
print(result)

