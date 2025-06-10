import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

tree = []
result = []
while True:
    try:
        tree.append(int(input()))
    except Exception:
        break
n = len(tree)
        
def postorder(start, end):
    global n
    
    if start > end:
        return
    
    root = tree[start]
    
    right_idx = end + 1
    for i in range(start + 1, end + 1):
        if tree[i] > root:
            right_idx = i
            break
    
    postorder(start+1, right_idx-1)
    postorder(right_idx, end)
    print(root)
    
postorder(0, n-1)