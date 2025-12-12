# 명예의 전당
# https://school.programmers.co.kr/learn/courses/30/lessons/138477
def solution(k, score):
    answer = []
    board = []
    for i in range(len(score)):
        today = score[i]
        
        if len(board) < k:
            board.append(today)

        else:
            if today > board[0]:
                del board[0]
                board.append(today)
            
        board.sort()
        answer.append(board[0])
                
    return answer

print(solution(4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]))

'''
매일 1명이 노래를 부른다
문자 투표수로 가수에게 점수를 부여한다
매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내라면 해당 가수의
점수를 명예의 전당에 올려 기념한다
프로그램 시작 이후 k일까지는 모두 명예의 전당에 올라간다
매일 발표된 명예의 전당의 최하위 점수를 return 하는 함수를 만들어라
'''
