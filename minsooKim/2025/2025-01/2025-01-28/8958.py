T = int(input())
for _ in range(T):
    arr = list(map(str, input()))    
    result = 0
    cnt = 0
    for i in arr:
        if i == "O":
            cnt += 1           
        else:
            cnt = 0
        result += cnt
    print(result)