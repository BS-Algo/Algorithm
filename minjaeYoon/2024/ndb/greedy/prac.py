def knight(coor):
    row = int(coor[1])
    column = int(ord(coor[0])) - int(ord('a')) + 1
    
    steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
    
    result = 0
    for step in steps:
        nxt_row = row + step[0]
        nxt_column = column + step[1]
        
        if nxt_row >= 1 and nxt_row <= 8 and nxt_column >= 1 and nxt_column <= 8:
            result += 1 
    return result

coor = 'a1'
print(knight(coor))