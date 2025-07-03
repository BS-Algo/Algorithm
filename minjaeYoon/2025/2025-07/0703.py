# 순서쌍의 개수
# On^2
def solution(n):
    answer = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i <= n and j <= n and i * j == n:
                answer += 1
    return answer

# On
def solution(n):
    return sum(1 for i in range(1, n+1) if n % i == 0)

n = 20

print(solution(n))