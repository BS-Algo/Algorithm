N = int(input())
lst = []
for _ in range(N):
    arr = list(map(int, input().split()))
    arr.sort(reverse=True)
    if arr[0] == arr[1] == arr[2]:
        lst.append(10000+arr[0]*1000)
    elif arr[0] == arr[1]: 
        lst.append(1000 + arr[0] * 100)
    elif arr[1] == arr[2]:
        lst.append(1000 + arr[1] * 100)
    elif arr[0] == arr[2]:
        lst.append(1000 + arr[0] * 100)
    else:
        lst.append(arr[0] * 100)
print(max(lst))