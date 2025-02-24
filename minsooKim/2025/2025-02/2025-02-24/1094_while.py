X = int(input())
N = 64
cnt = 0
while True:
    if N > X: # 64 > 23보다 크니까 실행
        N = N // 2 # N = 16
        print(N)
    else:
        X = X - N
        print(X)        
        cnt += 1
        if X == 0:
            break
print(cnt)
