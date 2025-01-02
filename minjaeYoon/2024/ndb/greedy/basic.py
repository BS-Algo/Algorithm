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
def only(n, k):
    result = 0
    while n >= k:
        if n % k == 0:
            n /= k
            result += 1
        else:
            n -= 1
            result += 1
    return result

n = 25
k = 5
print(only(n, k))

def only2(n, k):
    result = 0
    while n >= k:
        while n % k != 0:
            n -= 1
            result += 1
        n //= k
        result += 1
        
    while n > 1:
        n -= 1
        result += 1
    
    return result

print(only2(n, k))

# example 4-1 (구현) 상하좌우
def wasd(n, plans):
    x, y = 1, 1
    
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    move_types = ['L', 'R', 'U', 'D']
    
    for plan in plans:
        for i in range(len(move_types)):
            if plan == move_types[i]:
                nx = x + dx[i]
                ny = y + dy[i]
        if nx < 1 or ny < 1 or nx > n or ny > n:
            continue
        x, y = nx, ny
        
    return x, y

n = 5
plans = ['R', 'R', 'R', 'U', 'D', 'D']

print(wasd(n, plans))

# example 4-2 시각 (완전 탐색으로 풀기 및 이중 for 문 복습용 문제)
def time(n):
    cnt = 0
    for i in range(n+1):
        for j in range(60):
            for k in range(60):
                if '3' in str(i) + str(j) + str(k):
                    cnt += 1
    return cnt

n = 5
print(time(n))