# 등수 매기기
def solution(score):
    answer = []
    avg_list = []
    
    for num in score:
        a, b = num
        avg = (a+b) / 2
        avg_list.append(int(avg))
    
    unique_scores = sorted(set(avg_list), reverse=True)
    rank_dict = {score: idx + 1 for idx, score in enumerate(unique_scores)}
    
    for avg in avg_list:
        answer.append(rank_dict[avg])
    
    return answer

score = [[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]

print(solution(score))