# 평균 구하기
def solution(arr):
    return sum(arr) / len(arr)

print(solution([1,2,3,4]))

# x만큼 간격이 있는 n개의 숫자
def solution(x, n):
    answer = []
    for i in range(n):
        answer.append(x+x*i)
    return answer

print(solution(2, 5))

# 나머지가 1이 되는 수 찾기
def solution(n):
    for i in range(1, n+1):
        if n % i == 1:
            return i

print(solution(10))