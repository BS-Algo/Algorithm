import sys
input = sys.stdin.readline

sudoku = [list(map(int, input().rstrip())) for _ in range(9)]

# 체크용 set
rows, cols, boxes = [set() for _ in range(9)], [set() for _ in range(9)], [set() for _ in range(9)]

#3 X 3 박스 인덱스용 set 좌표 구하기
def get_box_index(x, y):
    return (x//3)*3 + (y//3)
    
    
# 초기값 삽입
for i in range(9):
    for j in range(9):
        if sudoku[i][j] != 0:
            rows[i].add(sudoku[i][j])
            cols[j].add(sudoku[i][j])
            boxes[get_box_index(i, j)].add(sudoku[i][j])


# 빈 칸 찾기
empty_cools = []
for i in range(9):
    for j in range(9):
        if sudoku[i][j] == 0:
            empty_cools.append((i, j))
            

#빈 칸에 가능한 값들의 모임
def get_possible_numbers(x, y):
    possible = []
    for num in range(1, 10):
        if num not in rows[x] and num not in cols[y] and num not in boxes[get_box_index(x, y)]:
            possible.append(num)
    return possible


# 빈 칸을 가능한 숫자 개수 기준으로 정렬
empty_cools.sort()


def dfs(idx):

    #종료조건
    if idx == len(empty_cools):
        for i in range(9):
            print(''.join(map(str, sudoku[i])))
        sys.exit(0)
        return
        
    #가능한 라인인지 확인
    x, y = empty_cools[idx]
    possible_nums = get_possible_numbers(x, y)
    
    
    # 가능한 숫자가 없으면 가지치기
    if not possible_nums:
        return
        
    possible_nums.sort()
    
    # 적합 여부 확인
    for num in possible_nums:
        sudoku[x][y] = num
        rows[x].add(num)
        cols[y].add(num)
        boxes[get_box_index(x, y)].add(num)
        
        dfs(idx + 1)
        
        sudoku[x][y] = 0
        rows[x].remove(num)
        cols[y].remove(num)
        boxes[get_box_index(x, y)].remove(num)
            
dfs(0)