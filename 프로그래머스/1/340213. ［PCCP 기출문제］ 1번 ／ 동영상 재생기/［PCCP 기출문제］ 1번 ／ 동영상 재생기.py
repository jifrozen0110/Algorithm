
def solution(video_len, pos, op_start, op_end, commands):
    def translateMin(h,m):
        return h*60+m
    def translateClock(sec):
        h=sec//60
        m=sec-60*h
        answer=f'{translateString(h)}:{translateString(m)}'
        return answer
        
    def translateString(number):
        if 0<=number<=9:
            return "0"+str(number)
        return str(number)
    answer = ''
    # 현재 위치가 오프닝지점인지 먼저 확인
    # next prev 실행
    
    video_h,video_m=map(int,video_len.split(":"))
    pos_h,pos_m=map(int,pos.split(":"))
    end_h,end_m=map(int,video_len.split(":"))
    op_start_h,op_start_m=map(int,op_start.split(":"))
    op_end_h,op_end_m=map(int,op_end.split(":"))
    
    pos=translateMin(pos_h,pos_m)
    end=translateMin(end_h,end_m)
    op_start=translateMin(op_start_h,op_start_m)
    op_end=translateMin(op_end_h,op_end_m)
    video=translateMin(video_h,video_m)

    if op_start<=pos<=op_end:
        pos=op_end
        
    for command in commands:
        # 10초 뒤 재생
        if command=="next":
            pos=pos+10
            if pos>video:
                pos=video
        # 10초 전 재생    
        elif command=="prev":
            pos=pos-10
            if pos<0:
                pos=0
        if op_start<=pos<=op_end:
            pos=op_end
                
    
    answer=translateClock(pos)
    return answer