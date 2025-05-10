K = int(input())
for j in range(1, K+1):
    arr = list(map(int, input().split()))
    num = arr[0]
    arr = arr[1:]
    arr.sort(reverse=True)    
    print(arr)
    cnt = -99999
    mx = max(arr)
    mn = min(arr)
    for i in range(1, num):
        if arr[i-1] - arr[i] > cnt:
            cnt = arr[i-1] - arr[i]
    print(f'Class {j}')
    print(f'Max {mx}, Min {mn}, Largest gap {cnt}')

    
