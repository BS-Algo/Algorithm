# 서울에서 김서방 찾기
def solution(seoul):
    return f"김서방은 {seoul.index('Kim')}에 있다"

print(solution(["Jane", "Kim"]))

def solution(seoul):
    answer = ''
    return ('김서방은 %d에 있다' %seoul.index('Kim'))

def solution(seoul):
    return "김서방은 {}에 있다".format(seoul.index("Kim"))

# 콜라츠 추측
def solution(num):
    if num == 1:
        return 0

    answer = 0
    
    while answer <= 500:
        if num % 2 == 0:
            num //= 2
        elif num % 2 != 0:
            num *= 3
            num += 1
        answer +=1
        
        if num == 1:
            return answer
            
    return -1

print(solution(6))
print(solution(16))
print(solution(626331))