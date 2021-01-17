# Uses python3
import sys
import itertools

def partition3(A):
    """
    for c in itertools.product(range(3), repeat=len(A)):
        sums = [None] * 3
        for i in range(3):
            sums[i] = sum(A[k] for k in range(len(A)) if c[k] == i)
        if sums[0] == sums[1] and sums[1] == sums[2]:
            return 1
    return 0
    """
    num_items=len(A)
    subset_sum=sum(A)/3
    if subset_sum%1!=0 or max(A)>subset_sum:
        return 0
    subset_sum=int(subset_sum)

    value=[[[False for _ in range(subset_sum+1)]for _ in range(subset_sum+1)]for _ in range(num_items+1)]
    value[0][0][0]=True

    for i in range(1,num_items+1):
        next_item_weight=A[i-1]
        for x in range(subset_sum+1):
            for y in range(subset_sum+1):
                value[i][x][y]=((value[i-1][x-next_item_weight][y] and next_item_weight<=x) or
                                (value[i-1][x][y-next_item_weight] and next_item_weight<=y) or
                                value[i-1][x][y])
    return int(value[num_items][subset_sum][subset_sum])

if __name__ == '__main__':
    input = sys.stdin.read()
    n, *A = list(map(int, input.split()))
    print(partition3(A))

