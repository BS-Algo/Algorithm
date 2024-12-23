# example 3-1
def coin(n):
    coin_types = [500, 100, 50, 10]
    count = 0
    
    for coin in coin_types:
        count += n // coin
        n %= coin
    
    return count

n = 1260
print(coin(n))

# 실전 문제 큰 수의 법칙