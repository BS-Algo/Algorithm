# 짝수 더하기
def solution(n):
    answer = 0
    for i in range(1, n+1):
        if i % 2 == 0:
            answer += i
    return answer

n = 10

print(solution(n))