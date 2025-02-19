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
