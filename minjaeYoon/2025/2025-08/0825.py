# 짝수와 홀수
def solution(num):
    if num % 2 == 1:
        return "Odd"
    else:
        return "Even"

def solution(num):
    return "Even" if num % 2 == 0 else "Odd"

print(solution(3))
print(solution(4))