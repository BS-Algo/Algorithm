# 주사위 게임 3
def solution(a, b, c, d):
    answer = 0

    # collection 아닌 set
    values = [a, b, c, d]
    set_values = set(values)

    if len(set_values) == 4:  # 모두 다른 경우
        return min(values)

    elif len(set_values) == 1:  # 모두 같은 경우
        return a * 1111

    elif len(set_values) == 2:
        for value in set_values: 
            if values.count(value) == 2:
                p = value
                q = (set_values - {p}).pop()
                return (10*p+q) ** 2

    elif len(set_values) == 2:
        p, q = set_values
        if values.count(p) == 2 and values.count(q) == 2:
            return (p+q) * abs(p-q)

    elif len(set_values) == 3:
        for value in set_values:
            if values.count(value) == 2:  # 2개가 같은 숫자 찾기
                p = value
                q, r = sorted(set_values - {p})  # 안전하게 두 개의 숫자 추출
                return q * r  # 남은 두 숫자의 곱

    return answer

a = 1
b = 2
c = 1
d = 2

print(solution(a, b, c, d))

# [PCCE 기출문제] 3번 / 나이 계산

year = int(input())
age_type = input()

if age_type == 'Korea':
    answer = 2030 - year + 1

elif age_type == "Year":
    answer = 2030 - year
    
print(answer)

# [PCCE 기출문제] 4번 / 저축
start = int(input())
before = int(input())
after = int(input())

money = start
month = 1
while money < 70:
    money += before
    month += 1
while 70 <= money < 100:
    money += after
    month += 1

print(month)

# [PCCE 기출문제] 5번 / 심폐소생술

def solution(cpr):
    answer = []
    basic_order = ["check", "call", "pressure", "respiration", "repeat"]
    for action in cpr:
        for i in range(len(basic_order)):
            if action == basic_order[i]:
                answer.append(basic_order.index(action)+1)
    return answer

cpr = ["call", "respiration", "repeat", "check", "pressure"]

print(solution(cpr))

# [PCCE 기출문제] 6번 / 물 부족

def solution(storage, usage, change):
    total_usage = 0
    for i in range(len(change)):
        usage += usage * change[i]/100
        total_usage += usage
        if total_usage > storage:
            return i
    
    return -1

storage = 5141
usage = 500
change = [10, -10, 10, -10, 10, -10, 10, -10, 10, -10]

print(solution(storage, usage, change))

# [PCCE 기출문제] 5번 / 산책

def solution(route):
    east = 0
    north = 0
    for i in route:
        if i == "N":
            north += 1
        elif i == "S":
            north -= 1
        elif i == "E":
            east += 1
        elif i == "W":
            east -= 1
    return [east, north]

route = "NSSNEWWN"

print(solution(route))

# [PCCE 기출문제] 6번 / 가채점

def solution(numbers, our_score, score_list):
    answer = []
    for i in range(len(numbers)):
        if our_score[i] == score_list[numbers[i]-1]:
            # .index 사용 생각했는데, 문제 제대로 읽기 (제일 앞이 0이 아닌 1)
            answer.append("Same")
        else:
            answer.append("Different")
    
    return answer

numbers = [3, 4]
our_score = [85, 93]
score_list = [85, 92, 38, 93, 48, 85, 92, 56]

print(solution(numbers, our_score, score_list))

