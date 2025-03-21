from collections import defaultdict
def solution(tickets):
    answer = []
    n=len(tickets)
    my_dict=defaultdict(list)
    for t in tickets:
        my_dict[t[0]].append(t[1]);
        my_dict[t[0]].sort(reverse=True)
    
    stuck=[]
    path=[]
    
    visited=set()
    node_chk=[0]*(n+1)
    
    stuck.append("ICN")
    
    while(len(stuck)>0):
        start=stuck[-1]
        if len(my_dict[start])==0:
            path.append(stuck.pop())
            continue
        end=my_dict[start][-1]
        stuck.append(end)
        my_dict[start]=my_dict[start][:-1]
        
        
    return path[::-1]