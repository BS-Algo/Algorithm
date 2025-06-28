# 직사각형 넓이 구하기
def solution(dots):
    x_coords = [dot[0] for dot in dots]
    y_coords = [dot[1] for dot in dots]
    
    width = max(x_coords) - min(x_coords)
    height = max(y_coords) - min(y_coords)
    
    return width * height

dots = [[-1, -1], [1, 1], [1, -1], [-1, 1]]	

print(solution(dots))

