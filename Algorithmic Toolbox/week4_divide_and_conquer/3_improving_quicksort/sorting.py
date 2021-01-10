# Uses python3
import sys
import random

def partition3(a, l, r):
    lessThan=l
    i=l
    greaterThan=r
    pivot=a[l]
    m=[]
    while i<=greaterThan:
        if a[i]<pivot:
            #swap
            a[lessThan],a[i]=a[i],a[lessThan]
            lessThan+=1
            i+=1
        elif a[i]>pivot:
            #swap
            a[greaterThan],a[i]=a[i],a[greaterThan]
            greaterThan-=1
        else:
            i+=1
    m.append(lessThan)
    m.append(greaterThan)
    return m

def randomized_quick_sort(a, l, r):
    #print(a)
    if l >= r:
        return
    k = random.randint(l, r)
    a[l], a[k] = a[k], a[l]
    #use partition3
    m = partition3(a, l, r)
    randomized_quick_sort(a, l, m[0]-1);
    randomized_quick_sort(a, m[1]+1, r);


if __name__ == '__main__':
    n=int(input())
    input=sys.stdin.readline()
    a=list(map(int,input.split()))
    randomized_quick_sort(a, 0, n - 1)
    for x in a:
        print(x, end=' ')
