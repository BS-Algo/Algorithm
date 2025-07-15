# 점의 위치 구하기
def solution(dot):
    x, y = dot
    
    if x > 0 and y > 0:
        return 1
    elif x < 0 and y > 0:
        return 2
    elif x < 0 and y < 0:
        return 3
    else:  
        return 4

dot = [2, 4]

print(solution(dot))