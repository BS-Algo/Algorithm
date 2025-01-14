def binary(start, end):
    while start <= end:
        mid = (start + end) // 2 # 75
        cnt = 0
        for i in arr:
            if mid < i: # 75 < i
                cnt += mid # 75 + 75 + 75 + 75
            else:
                cnt += i
        if cnt > M:
            end = mid - 1
        else:
            result = mid # result = 75
            start = mid + 1 # start = 76
    return result     

N = int(input())
arr = list(map(int, input().split()))
arr.sort()
M = int(input())
start = 1 # 1
end = max(arr) # 150
print(binary(start, end))