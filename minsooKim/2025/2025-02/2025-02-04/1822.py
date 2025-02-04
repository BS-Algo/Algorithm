N, M = map(int, input().split())

arr_A = set(map(int, input().split()))
arr_B = sorted(set(map(int, input().split())))

result = []

for i in arr_A:
    start = 0
    end = M - 1
    check = False

    while start <= end:
        mid = (start + end) // 2

        if arr_B[mid] == i:
            check = True
            break
        elif arr_B[mid] < i:
            start = mid + 1
        else:
            end = mid - 1
    
    if check == False:
        result.append(i)
result.sort()
if len(result) != 0:
    print(len(result))
    print(*result)
else:
    print(0)