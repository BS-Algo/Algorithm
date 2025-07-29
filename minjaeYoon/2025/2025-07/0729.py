# 소인수 분해
def solution(n):
    answer = []
    
    d = 2
    
    while d * d <= n:
        if n % d == 0:
            answer.append(d)
            while n % d == 0:
                n //= d
        else:
            d += 1

    if n > 1:
        answer.append(n)
    
    return answer
    
print(solution(420))

# 원래 풀이
 # ✅ 추가
 # 소수로 남은 마지막 값 처리
 # 반례 일부 존재
def solution(n):
    answer = []
    d = 2

    while d <= n:
        if n % d == 0:
            answer.append(d)
            n //= d
        else:
            d += 1

    if n > 1:             
        answer.append(n)   

    return list(set(answer))
