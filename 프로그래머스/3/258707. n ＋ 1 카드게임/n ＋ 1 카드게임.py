from collections import deque

def check(deck1,deck2,target):
    targetCards=set(deck2)
    for card in deck1:
        if (target-card) in targetCards:
            deck1.remove(card)
            deck2.remove(target-card)
            return True
    return False

def solution(coin, cards):
    answer = 0
    hand=cards[:len(cards)//3]
    deck=deque(cards[len(cards)//3:])
    pending=[]
    n=len(cards)
    game_round=1
    while (coin>=0 and deck):
        pending.append(deck.popleft())
        pending.append(deck.popleft())
        if check(hand,hand,n+1):
            pass
        elif coin>=1 and check(hand,pending,n+1):
            coin-=1
        elif coin>=2 and check(pending,pending,n+1):
            coin-=2
        else:
            break;
        game_round+=1
    
    
    return game_round