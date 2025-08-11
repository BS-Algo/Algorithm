# 종이접기 - bfs
from collections import deque

def bfs(width, height):
    width, height = min(width, height), max(width, height)
    
    if width == 1 and height == 1:
        return 0
    
    queue = deque([(width, height)])
    cut_count = 0
    
    while queue:
        level_size = len(queue)
        
        for _ in range(level_size):
            w, h = queue.popleft()
            
            if w == 1 and h == 1:
                continue
            
            w, h = min(w, h), max(w, h)
            
            piece1_h = h // 2
            piece2_h = h - piece1_h
            
            queue.append((w, piece1_h))
            queue.append((w, piece2_h))
        
        if queue:
            cut_count += 1
    
    return cut_count