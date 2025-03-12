T = int(input())
for t in range(T):
    N = int(input())
    stock_price = list(map(int, input().split()))

    cnt = 0
    mx = 0 # 최대 가격
    for i in range(N-1, -1, -1): # index N-1에서 0까지 역순으로
        if stock_price[i] > mx:
            mx = stock_price[i]
        else:
            cnt += mx - stock_price[i]

    print(cnt)
