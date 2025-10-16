# 최소 직사각형
# https://school.programmers.co.kr/learn/courses/30/lessons/86491
def solution(sizes):
    mx_width = 0
    mx_height = 0
    for i in range(len(sizes)):
        long = max(sizes[i][0], sizes[i][1])
        short = min(sizes[i][0], sizes[i][1])
        
        mx_width = max(mx_width, long)
        mx_height = max(mx_height, short)
    return mx_width * mx_height

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))
