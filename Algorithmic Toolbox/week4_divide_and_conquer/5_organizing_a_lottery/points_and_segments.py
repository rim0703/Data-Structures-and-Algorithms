# Uses python3
import sys
from itertools import chain
def fast_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    #write your code here

    """
    1. using the function zip()
    2. using the chain() from the itertools
    """

    starts=zip(starts,['l']*len(starts),range(len(starts)))
    ends=zip(ends,['r']*len(ends),range(len(ends)))
    points=zip(points,['p']*len(points),range(len(points)))

    sort_list=chain(starts,ends,points)
    sort_list=sorted(sort_list)
    i=0
    for num,letter,index in sort_list:
        if letter=='l':
            i+=1
        elif letter=='r':
            i-=1
        else:
            cnt[index]=i

    return cnt

def naive_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    for i in range(len(points)):
        for j in range(len(starts)):
            if starts[j] <= points[i] <= ends[j]:
                cnt[i] += 1
    return cnt

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    m = data[1]
    starts = data[2:2 * n + 2:2]
    ends   = data[3:2 * n + 2:2]
    points = data[2 * n + 2:]
    #use fast_count_segments
    cnt = fast_count_segments(starts, ends, points)
    for x in cnt:
        print(x, end=' ')
