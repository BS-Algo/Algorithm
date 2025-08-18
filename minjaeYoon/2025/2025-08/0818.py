# 평행
def solution(dots):
    
    def slope(p1, p2):
        return (p2[1] - p1[1]) / (p2[0] - p1[0])
    
    combinations = [
        [(0, 1), (2, 3)],
        [(0, 2), (1, 3)],
        [(0, 3), (1, 2)]
    ]
    
    for combo in combinations:
        slope1 = slope(dots[combo[0][0]], dots[combo[0][1]])
        slope2 = slope(dots[combo[1][0]], dots[combo[1][1]])
        if slope1 == slope2:
            return 1
    
    return 0


print(solution([[1, 4], [9, 2], [3, 8], [11, 6]]))