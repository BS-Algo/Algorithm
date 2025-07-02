# 진료순서 정하기
# 리스트 컴프리헨션으로 순위 결정하기
def solution(emergency):
    answer = [sum(1 for s in emergency if s > emergen) + 1 for emergen in emergency]
    return answer

emergency = [3, 76, 24]

print(solution(emergency))