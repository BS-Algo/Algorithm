# 자물쇠와 열쇠
def route(a):
    n = len(a)
    m = len(a[0])
    res = [[0] for _ in range(m)]
    for i in range(n):
        for j in range(m):
            res[j][n-i-1] = a[i][j]
    return res

def check(new):
    lock = len(new) // 3
    for i in range(lock, lock*2):
        for j in range(lock, lock*2):
            if new[i][j] != 1:
                return False
    return True

def solution(key, lock):
    n = len(lock)
    m = len(key)
    new_lock = [[0] * (n*3) for _ in range(n*3)]
    
    for i in range(n):
        for j in range(n):
            new_lock[i+n][j+n] = lock[i][j]
        
    for rot in range(4):
        key = route(key)
        for x in range(n*2):
            for y in range(n*2):
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j] += key[i][j]
                
                if check(new_lock) == True:
                    return True
                
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j] -= key[i][j]
    return False