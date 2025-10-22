# 기사단원의 무기
# https://school.programmers.co.kr/learn/courses/30/lessons/136798
def solution(number, limit, power):
    answer = 0
    lst = []
    
    def divide(n):
        re = 0
        for i in range(1, n+1):
            if n % i == 0:
                re += 1
        return re
    
    for i in range(1, number+1):
        lst.append(divide(i))
    
    for i in range(len(lst)):
        if lst[i] <= limit:
            answer += lst[i]
        else:
            answer += power    
        
    return answer

print(solution(5, 3, 2))

# 시간 줄이기
def solution(number, limit, power):
    answer = 0
    
    def divide(n):
        if n == 1:
            return 1
        
        cnt = 0
        
        for i in range(1, int(n**0.5) + 1):
            if n % i == 0:
                cnt += 1
                if i != n // i:
                    cnt += 1
        return cnt
    
    for i in range(1, number + 1):
        div_cnt = divide(i)
        if div_cnt <= limit:
            answer += div_cnt
        else:
            answer += power
    return answer

print(solution(5, 3, 2))
