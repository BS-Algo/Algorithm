def binary(start, end):
    
    while start <= end:
        mid = (start + end) // 2
        cnt = 0

        for i in arr:
            cnt += i // mid

        if cnt < N:
            end = mid - 1
        else:
            result = mid
            start = mid + 1
    return result  

K, N = map(int, input().split())
# K개의 랜선 길이가 제각각. K = 4
# 모두 N개의 같은 길이의 랜선. N = 11
# 802 743 이렇게 K가 2라치고, N이 7이라면 200 200 200 200, 200 200 200이런식으로
arr = []
for _ in range(K):
    num = int(input())
    arr.append(num)
start = 1
end = max(arr)
print(binary(start, end))



