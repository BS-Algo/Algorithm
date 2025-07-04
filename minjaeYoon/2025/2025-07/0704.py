# 합성수 찾기
# On^2
def solution(n):
    answer = 0
    for i in range(1, n+1):
        cnt = 0
        for j in range(1, i+1):
            if i % j == 0:
               cnt += 1
        if cnt >= 3:
            answer += 1 
    return answer

# Onlogn
def solution(n):
    divisor_count = [0] * (n + 1)
    for i in range(1, n + 1):
        for j in range(i, n + 1, i):
            divisor_count[j] += 1
    return sum(1 for i in range(1, n + 1) if divisor_count[i] >= 3)

n = 10

print(solution(n))

