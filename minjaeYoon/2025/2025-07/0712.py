# 아이스 아메리카노
def solution(money):
    answer = [0] * 2
    answer[0] = money // 5500
    answer[1] = money - 5500 * answer[0]
    
    return answer

money = 15000

print(solution(money))

# 키큰 사람
def solution(array, height):
    answer = [i for i in array if i > height]
    return len(answer)

array = [149, 180, 192, 170]	
height = 167

print(solution(array, height))

# 분수의 덧셈
# fractions 모듈의 Fraction 클래스 사용하기
def solution(numer1, denom1, numer2, denom2):
    from fractions import Fraction
    FS = Fraction(numer1, denom1) + Fraction(numer2, denom2)
    answer = [FS.numerator, FS.denominator]
    return answer

# 옷가게 할인 받기
def solution(price):
    price = int(price)
    if price >= 500000:
        return int(price*0.8)
    elif 300000 <= price < 500000:
        return int(price * 0.9)
    elif 100000 <= price < 300000:
        return int(price * 0.95)
    else:
        return int(price)

price = 150000

print(solution(price))

# dic로 케이스 분리 시켜서 풀기
def solution(price):
    discount_rates = {500000: 0.8, 300000: 0.9, 100000: 0.95, 0: 1}
    for discount_price, discount_rate in discount_rates.items():
        if price >= discount_price:
            return int(price * discount_rate)
        
# 피자 나눠 먹기 2
def solution(n):
    m = 1
    if n % 6 == 0:
        return int(n/6)
    while 6*m % n != 0:
        m += 1
    return m
        
n = 10

print(solution(n))

# 피자 나눠 먹기 3
def solution(slice, n):
    answer = 0
    if n % slice == 0:
        return n // slice
    else:
        return n // slice + 1

slice = 7
n = 10

print(solution(slice, n))

# 2차원으로 만들기
def solution(num_list, n):
    answer = [[] for _ in range(len(num_list) // n)]
    for i in range(0, len(num_list), n):
        answer[i//n] = num_list[i:n+i]
        
    return answer

num_list = [100, 95, 2, 4, 5, 6, 18, 33, 948]
n = 3

print(solution(num_list, n))