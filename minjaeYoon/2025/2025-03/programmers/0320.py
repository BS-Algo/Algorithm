# 문자열 여러 번 뒤집기
def solution(my_string, queries):
    answer = ''
    my_string = list(my_string)
    for query in queries:
        s, e = query
        my_string[s : e+1] = my_string[s : e+1][::-1]
        # 리스트를 역순으로 뒤집는 슬라이싱 기법 중 하나
    return answer.join(my_string)

my_string = "rermgorpsam"
queries = [[2, 3], [0, 7], [5, 9], [6, 10]]

print(solution(my_string, queries))

