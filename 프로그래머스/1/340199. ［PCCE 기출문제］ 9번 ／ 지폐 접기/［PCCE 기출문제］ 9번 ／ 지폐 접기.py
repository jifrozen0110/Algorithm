def solution(wallet, bill):
    answer = 0
    bill_max=max(bill)
    bill_min=min(bill)
    wallet_max=max(wallet)
    wallet_min=min(wallet)
    
    while (bill_min>wallet_min or bill_max>wallet_max):
        if bill[0]>bill[1]:
            bill[0]=bill[0]//2
        else:
            bill[1]=bill[1]//2
        bill_max=max(bill)
        bill_min=min(bill)
        answer+=1
        
    return answer