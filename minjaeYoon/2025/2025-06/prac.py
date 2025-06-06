# 삼각형의 완성조건 (2)
def solution(sides):
    answer = 0
    # 조건 1 : 가장 긴 변이 sides 안에 있을 경우
    maxi = max(sides)
    mini = min(sides)
    sums = sum(sides)
    for i in range(maxi): # 자연적으로 -1까지 되니까
        if i + mini > maxi:
            answer += 1
    # 조건 2 : 가장 긴 변을 찾는 경우
    for i in range(sums):
        if i < sums and i >= maxi:
            answer += 1
    return answer

sides = [3, 6]

print(solution(sides))