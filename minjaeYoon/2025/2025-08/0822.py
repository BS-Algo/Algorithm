# 자연수 뒤집어 배열로 만들기
def solution(n):
    answer = []
    
    n = list(str(n))
    
    for i in range(1, len(n)+1):
        answer.append(int(n[-i]))
    
    return answer

print(solution(12345))

def solution(n):
    return [int(i) for i in str(n)][::-1]