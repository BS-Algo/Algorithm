N, M = map(int, input().split())
arr = []
for _ in range(M):
    arr.append(int(input()))
arr.sort()
# [4, 7]
# 11 // 5 한 값인 2를 빼주면서 cnt에 더해주기
# 4 - 2, 2 - 2, 7 - 2, 5 - 2, 까지 하면 cnt 가 1로 시작하면 5. 그래서 2 2 2 2 3

print(arr)
start = 1
end = max(arr)
result = []
while start <= end :
    mid = (start + end) // 2
    num = mid
    cnt = 1

    for i in arr :
        result.append(num)
        while i - num < 0:
            num = i - num
            cnt += 1 
    if cnt < N:
        end = mid - 1
    else:
        start = mid + 1
print(result)         

