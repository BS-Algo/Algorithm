def solution(numbers, our_score, score_list):
    answer = []
    for i in range(len(numbers)):
        if our_score[i] == score_list[numbers[i]-1]:
            answer.append("Same")
        else:
            answer.append("Different")
    
    return answer

numbers = [3, 4]
our_score = [85, 93]
score_list = [85, 92, 38, 93, 48, 85, 92, 56]

print(solution(numbers, our_score, score_list))