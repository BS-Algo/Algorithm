def solution(cpr):
    answer = []
    basic_order = ["check", "call", "pressure", "respiration", "repeat"]
    for action in basic_order:
        for i in range(len(basic_order)):
            if action == basic_order[i]:
                answer.append(cpr.index(action)+1)
    return answer

cpr = ["call", "respiration", "repeat", "check", "pressure"]

print(solution(cpr))