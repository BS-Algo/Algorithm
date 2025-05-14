# 주사위 게임 1
def solution(a, b):
    if a % 2 == 1 and b % 2 == 1:
        return a**2 + b**2
    elif a % 2 == 1 or b % 2 == 1:
        return 2 * (a+b)
    elif a % 2 == 0 and a % 2 == 0:
        return abs(a-b) 

a = 3
b = 5

print(solution(a, b))

# 날짜 비교하기
def solution(date1, date2):
    # 리스트끼리 직접 비교가 가능함
    # 0번 인덱스부터 비교를 시작 -> 0번 인덱스에서 비교가 안 된다면 다음 번수 인덱스 비교로 넘어감
    return 1 if date1 < date2 else 0

from datetime import datetime

def solution(date1, date2):
    # datetime 객체로 변환
    dt1 = datetime(date1[0], date1[1], date1[2])
    dt2 = datetime(date2[0], date2[1], date2[2])
    
    # 날짜 비교
    return 1 if dt1 < dt2 else 0

date1 = [2021, 12, 28]	
date2 = [2021, 12, 29]	

print(solution(date1, date2))