# 등수 매기기
def solution(score):
    answer = []
    ranks = []
    
    for num in score:
        a, b = num
        avg = (a+b) / 2
        answer.append(int(avg))
    
    sorted_answer = sorted(answer, reverse=True)
    
    ranks = [sorted_answer.index(s) + 1 for s in answer ]
    
    return ranks

score = [[80, 70], [90, 50], [40, 70], [50, 80]]

print(solution(score))