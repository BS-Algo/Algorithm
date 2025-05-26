import sys
from collections import defaultdict
from itertools import permutations
input = sys.stdin.readline


for tc in range(int(input())):
    clothes = defaultdict(list)
    clothes_list = []
    n = int(input())
    
    for _ in range(n):
        cloth, cloth_type = input().split()
        clothes[cloth_type].append(cloth)
        
    for cloty_type, cloth in clothes_list:
        clothes[cloth_type].append(cloth)
    
    result = 1
    
    for val in clothes.values():
        result *= len(val) + 1
    
    print(result-1)