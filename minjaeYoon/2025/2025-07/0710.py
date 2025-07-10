# 홀짝 구하기
def solution(num_list):
    lft = 0
    rgt = 0
    answer = []
    for i in range(len(num_list)):
        if num_list[i] % 2 == 0:
           lft += 1
        else:
            rgt += 1
    answer.append(lft)
    answer.append(rgt)
    return answer

num_list = [1, 2, 3, 4, 5]

print(solution(num_list))