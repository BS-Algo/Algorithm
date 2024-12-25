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
def bignum(arr, data):
    n, m, k = arr
    data.sort()
    first = data[n-1]
    second = data[n-2]
    result = 0
    while True:
        for i in range(k):
            if m == 0:
                break
            result += first
            m -= 1
        if m == 0:
            break 
        result += second
        m -= 1
    return result
arr = [5, 8, 3]
data = [2, 4, 5, 4, 6]
print(bignum(arr, data))

# 실전 문제 숫자 카드 게임
def card(arr, num):
    n, m = arr
    result = 0
    for i in range(n):
        min_num = min(num[i])
        result = max(result, min_num)
    return result

arr = [3, 3]
num = [
    [3, 1, 2],
    [4, 1, 4],
    [2, 2, 2]
]
print(card(arr, num))

# 실전 문제 1이 될 때 까지
