# OX 퀴즈
def solution(quiz):
    answer = []
    quiz = [x.split() for x in quiz]
    for qu in quiz:
        x, op, y, eq, z = qu
        if op == '+':
            if int(x) + int(y) == int(z):
                answer.append("O")
            else:
                answer.append("X")
        elif op == '-':
            if int(x) - int(y) == int(z):
                answer.append("O")
            else:
                answer.append("X")            
    return answer

quiz = ["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"]

print(solution(quiz))

# 편지
def solution(message):
    return 2 * len(message)

message = "happy birthday!"

print(solution(message))

# 배열의 유사도
def solution(s1, s2):
    answer = 0
    for i in range(len(s1)):
        if s1[i] in s2:
            answer += 1
    return answer

s1 = ["a", "b", "c"]	
s2 = ["com", "b", "d", "p", "c"]

print(solution(s1, s2))

# set 사용
def solution(s1, s2):
    return len(set(s1)&set(s2))

# 약수 구하기
def solution(n):
    answer = []
    for i in range(1, n+1):
        if n % i == 0:
            answer.append(i)
    return answer

n = 24

print(solution(n))

# 숫자 찾기
def solution(num, k):
    num = str(num)
    for i in range(len(num)):
        if num[i] == str(k):
            return i+1
    return -1

num = 29183	
k = 1

print(solution(num, k))