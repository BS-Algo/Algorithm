# 369 게임
def solution(order):
    answer = 0
    order = [x for x in str(order)]
    for i in range(len(order)):
        if int(order[i]) == 3:
            answer += 1
        elif int(order[i]) == 6:
            answer += 1
        elif int(order[i]) == 9:
            answer += 1
    return answer

order = 29423

print(solution(order))

# 람다 사용
def solution(order):
    return sum(map(lambda x: str(order).count(str(x)), [3, 6, 9]))
