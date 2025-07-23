from collections import deque

def solution(maps):
    dt = ((1, 0), (-1, 0), (0, 1), (0, -1))
    global n
    n = len(maps)
    global m
    m = len(maps[0])
    
    answer = []
    maps = [list(row) for row in maps]
    
    # def dfs(x, y):
    #     global n, m, cnt
    #     for dx, dy in dt:
    #         nx, ny = x+dx, y+dy
    #         if 0 <= nx < n and 0 <= ny < m:
    #             if maps[nx][ny] != 'X':
    #                 cnt += int(maps[nx][ny])
    #                 maps[nx][ny] = 'X'
    #                 dfs(nx, ny)
    
    def bfs(x, y):
        result = int(maps[x][y])
        q = deque([(x, y)])
        maps[x][y] = 'X'
        
        while q:
            x, y = q.popleft()
            
            for dx, dy in dt:
                nx, ny = x+dx, y+dy
                if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] != 'X':
                    result += int(maps[nx][ny])
                    maps[nx][ny] = 'X'
                    q.append((nx, ny))
        return result
        
        
    for x in range(n):
        for y in range(m):
            if maps[x][y] != 'X':
                answer.append(bfs(x, y))
                
    if answer:
        answer.sort()
    else:
        answer.append(-1)
    return answer