# Uses python3
import sys

def get_majority_element(a):
    a.sort()
    count=0
    if len(a)==1:
        return 1
    else:
        for i in range(len(a)-1):
            if a[i]==a[i+1]:
                count+=1
                if (count + 1 > len(a) / 2):
                    return 1
            else:
                count=0

    return -1

if __name__ == '__main__':
    n=int(input())
    a=[]
    a.extend(input().split())
    if get_majority_element(a) == 1:
        print(1)
    else:
        print(0)
