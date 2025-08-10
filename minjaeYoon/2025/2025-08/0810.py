# 종이접기 - dfs로 풀기
def dfs(width, height):
    width, height = min(width, height), max(width, height)
    
    if width == 1 and height == 1:
        return 0
    
    return 1 + dfs(width, height//2) + dfs(width, height-height//2)


