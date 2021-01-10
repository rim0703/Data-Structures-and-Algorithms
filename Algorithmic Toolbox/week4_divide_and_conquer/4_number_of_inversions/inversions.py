# Uses python3
import sys

def get_number_of_inversions(a, b, left, right):
    number_of_inversions = 0
    if right - left <= 1:
        return number_of_inversions
    ave = (left + right) // 2
    number_of_inversions += get_number_of_inversions(a, b, left, ave)
    number_of_inversions += get_number_of_inversions(a, b, ave, right)

    #write your code here
    number_of_inversions += merge(a,b,left,right)

    return number_of_inversions

def merge(a,b,l,r):
    mid=(l+r)//2

    count=0
    i=l
    k=l
    j=mid
    while i<mid and j<r:
        if a[i]<=a[j]:
            b[k]=a[i]
            i+=1
            k+=1
        else:
            count+=mid-i
            b[k]=a[j]
            k+=1
            j+=1
    while i<mid:
        b[k] = a[i]
        i += 1
        k += 1
    while j<r:
        count += mid - i
        b[k] = a[j]
        k += 1
        j += 1
    for x in range(l,r):
        a[x]=b[x]
    return count

if __name__ == '__main__':

    n = int(input())
    input=sys.stdin.readline()
    a = list(map(int,input.split()))
    b = n * [0]
    print(get_number_of_inversions(a, b, 0, len(a)))
