# 배열 만들기 1
def solution(n, k):
    answer = []
    for i in range(1, n+1):
        if i*k <= n:
            answer.append(i*k)
    return answer

n = 10
k = 3

print(solution(n, k))