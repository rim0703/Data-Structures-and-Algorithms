#Uses python3

import sys

def lcs3(a, b, c):
    #write your code here
    #compare list a and list b
    dp=[[0]*(len(a)+1) for i in range(len(b)+1)]
    for i in range(1,len(a)+1):
        for j in range(1,len(b)+1):
            if a[i-1]==b[j-1]:
                dp[j][i]=1+dp[j-1][i-1]
            else:
                dp[j][i]=max(dp[j-1][i],dp[j][i-1])

    #compare list b and list c
    dp2=[[0]*(len(b)+1) for i in range(len(c)+1)]
    for i in range(1,len(b)+1):
        for j in range(1,len(c)+1):
            if b[i-1] == c[j-1]:
                dp2[j][i] = 1+dp2[j-1][i-1]
            else:
                dp2[j][i] = max(dp2[j - 1][i], dp2[j][i - 1])

    #compare list c and list a
    dp3=[[0]*(len(c)+1) for i in range(len(a)+1)]
    for i in range(1,len(c)+1):
        for j in range(1,len(a)+1):
            if c[i-1]==a[j-1]:
                dp3[j][i]=1+dp3[j-1][i-1]
            else:
                dp3[j][i]=max(dp3[j-1][i],dp3[j][i-1])

    return min(len(set(a)&set(b)&set(c)),dp[len(b)][len(a)],dp2[len(c)][len(b)],dp3[len(a)][len(c)])

if __name__ == '__main__':

    input = sys.stdin.read()
    data = list(map(int, input.split()))
    an = data[0]
    data = data[1:]
    a = data[:an]
    data = data[an:]
    bn = data[0]
    data = data[1:]
    b = data[:bn]
    data = data[bn:]
    cn = data[0]
    data = data[1:]
    c = data[:cn]
    print(lcs3(a, b, c))
