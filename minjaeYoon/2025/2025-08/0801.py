# 유한소수 판별하기
def solution(a, b):
    from fractions import Fraction

    frac = Fraction(a, b)
    x = frac.numerator
    y = frac.denominator
        
    facto = []
    
    d = 2
    
    while d * d <= y:
        if y % d == 0:
            facto.append(d)
            while y % d == 0:
                y //= d
        else:
            d += 1
    
    if y > 1:
        facto.append(y)
    
    facto = set(facto)
    
    if facto == set() or facto == {2} or facto == {5} or facto == {2, 5}: # 분모가 1 일 때의 처리를 하지 못해 틀렸음
        return 1
    else:
        return 2
    
print(solution(7, 20))

# 유클리드 호제법