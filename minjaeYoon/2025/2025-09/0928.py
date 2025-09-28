# 추억 점수
# https://school.programmers.co.kr/learn/courses/30/lessons/176963
def solution(name, yearning, photo):
    answer = []
    for j in range(len(photo)):
        score = 0
        for k in range(len(photo[j])):
            for i in range(len(name)):
                if name[i] == photo[j][k]:
                    score += yearning[i]
        answer.append(score)
    return answer

print(solution(["may", "kein", "kain", "radi"], [5, 10, 1, 3], [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]))

#     if name[i] == photo[j][k]:
# IndentationError: unexpected indent
# 들여쓰기 오류

# 리스트 컴프리헨션
def solution(이름, 점수, 사진):
    return [sum(점수[이름.index(j)] for j in i if j in 이름) for i in 사진]