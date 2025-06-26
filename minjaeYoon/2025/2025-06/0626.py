# 배열 회전시키기
def solution(numbers, direction):
    answer = []
    if direction == "left":
        answer = numbers[1:] + [numbers[0]]
    elif direction == "right":
        answer = [numbers[-1]] + numbers[:len(numbers)-1]
    return answer

numbers = [4, 455, 6, 4, -1, 45, 6]	
direction = "left"

print(solution(numbers, direction))