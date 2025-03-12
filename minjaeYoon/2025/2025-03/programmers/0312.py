# 9로 나눈 나머지

def solution(number):
    answer = 0
    for i in number:
        answer += int(i)
    return answer % 9

def solution2(number):
    return sum(map(int, number)) % 9

number = "78720646226947352489"

print(solution(number))
print(solution2(number))

