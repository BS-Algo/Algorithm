N, M = map(int, input().split())
arr = list(map(int, input().split()))
start = max(arr) # 9
end = sum(arr) # 45
while start <= end:
    mid = (start+end) // 2
    cnt = 1
    current_sum = 0
    for i in arr:
        if current_sum + i > mid:
            cnt += 1
            current_sum = i
        else:
            current_sum += i

    if cnt <= M:
        end = mid - 1
    else:
        start = mid + 1
print(cnt)
print(current_sum)
print(start)
    

    
        

    

