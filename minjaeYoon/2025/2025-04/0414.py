# 할 일 목록
def solution(*v):
    answer = []
    for i in range(len(finished)):
        if not finished[i]:
            answer.append(todo_list[i])
    return answer

todo_list = ["problemsolving", "practiceguitar", "swim", "studygraph"]	
finished = [True, False, True, False]

v = (todo_list, finished)

## 정처기 파이썬 문제 복습

print(solution(*v))