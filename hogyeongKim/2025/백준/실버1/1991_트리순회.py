n = int(input())

def pre_order(v):
    print(v, end='')
    if tree_dict[v][0] != '.': pre_order(tree_dict[v][0])
    if tree_dict[v][1] != '.': pre_order(tree_dict[v][1])

def in_order(v):
    if tree_dict[v][0] != '.': in_order(tree_dict[v][0])
    print(v, end='')
    if tree_dict[v][1] != '.': in_order(tree_dict[v][1])
    
def post_order(v):
    if tree_dict[v][0] != '.': post_order(tree_dict[v][0])
    if tree_dict[v][1] != '.': post_order(tree_dict[v][1])
    print(v, end='')

tree_dict = {}

for _ in range(n):
    v, l, r = input().split()
    tree_dict[v] = [l, r]

pre_order('A')
print()
in_order('A')
print()
post_order('A')