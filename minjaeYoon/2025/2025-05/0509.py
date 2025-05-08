# 뒤에서 5등 위로
def solution(num_list):
    return sorted(num_list)[5:]

num_list = [12, 4, 15, 46, 38, 1, 14, 56, 32, 10]

print(solution(num_list))

# 전국 대회 선발 고사
def solution(rank, attendance):
    ranking = []
    for i in range(len(attendance)):
        if attendance[i]:
            ranking.append((rank[i], i))
    
    ranking.sort()
    
    a, b, c = ranking[0][1], ranking[1][1], ranking[2][1]
    
    return 10000*a + 100*b + c

rank = [3, 7, 2, 5, 4, 6, 1]
attendance = [False, True, True, True, True, False, False]

print(solution(rank, attendance))