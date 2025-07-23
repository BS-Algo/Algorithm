def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    
    answer = [score[i] * m for i in range(len(score)) if (i+1) % m == 0]
    
    return sum(answer)