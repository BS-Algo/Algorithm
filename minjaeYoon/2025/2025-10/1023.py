# 모의고사
# https://school.programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    answer = []
    score = [0, 0, 0]
    # 1번 : 12345
    first = [1, 2, 3, 4, 5]
    # 2번 : 21 23 24 25
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    # 3번 : 33 11 22 44 55 
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for i in range(len(answers)):
        # 루프를 만들려면 나머지가 필요할거고
        if answers[i] == first[i % len(first)]:
            score[0] += 1
        if answers[i] == second[i % len(second)]:
            score[1] += 1
        if answers[i] == third[i % len(third)]:
            score[2] += 1
    
    mx_score = max(score)
    
    for i in range(3):
        if score[i] == mx_score:
            answer.append(i+1)
    
    return answer

print(solution([1,3,2,4,2]))

# enumerate 사용
def solution(answers):
    pattern1 = [1,2,3,4,5]
    pattern2 = [2,1,2,3,2,4,2,5]
    pattern3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0, 0, 0]
    result = []

    for idx, answer in enumerate(answers):
        if answer == pattern1[idx%len(pattern1)]:
            score[0] += 1
        if answer == pattern2[idx%len(pattern2)]:
            score[1] += 1
        if answer == pattern3[idx%len(pattern3)]:
            score[2] += 1

    for idx, s in enumerate(score):
        if s == max(score):
            result.append(idx+1)

    return result