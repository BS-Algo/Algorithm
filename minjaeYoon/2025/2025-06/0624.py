# 주사위의 개수
def solution(box, n):
    answer = 0
    cnt = 1
    for i in range(3):
        if box[i] < n:
            return answer
        cnt *= box[i] // n
        
    
    return cnt

box = [10, 8, 6]
n = 3

print(solution(box, n))