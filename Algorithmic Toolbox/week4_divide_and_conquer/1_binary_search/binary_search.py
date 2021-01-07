# Uses python3
"""
def binary_search(a, x, low=None, high=None):
    low,high=low or 0, high or len(a)-1
    # write your code here
    if low>high:
        return -1;
    mid=(low+high)//2
    if a[mid]>x:
        return binary_search(a,x,low,mid)
    if a[mid]==x:
        return mid
    if a[mid]<x:
        return binary_search(a,x,mid+1,high)
"""
def binary_search(seq, elt, r):
    l = 0
    while l<=r:
        m = (l+r)//2
        if elt > seq[m]:
            l = m + 1
        elif elt < seq[m]:
            r = m - 1
        else:
            return m
    return -1

if __name__ == '__main__':

    data = list(map(int, input().split()))
    n = data[0]
    m = data[1: ]
    data = list(map(int, input().split()))
    a = data[1 : ]

    for x in a:
        # replace with the call to binary_search when implemented
        print(binary_search(m, x, n-1), end = ' ')
