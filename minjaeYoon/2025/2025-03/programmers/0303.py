# [PCCE 기출문제] 7번 / 버스
def func1(num):
    if 0 > num:
        return 0
    else:
        return num

def func2(num):
    if num > 0:
        return 0
    else:
        return num

def func3(station):
    num = 0
    for people in station:
        if people == "Off":
            num += 1
    return num

def func4(station):
    num = 0
    for people in station:
        if people == "On":
            num += 1
    return num

def solution(seat, passengers):
    num_passenger = 0
    for station in passengers:
        num_passenger += func4(station)  # 승차 인원 추가
        num_passenger -= func3(station)  # 하차 인원 감소
    answer = func1(seat - num_passenger)  # 최종 인원 계산
    return answer

seat = 5
passengers = [["On", "On", "On"], ["Off", "On", "-"], ["Off", "-", "-"]]

print(solution(seat, passengers))  # 출력: 3