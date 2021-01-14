#Uses python3

import sys

def lcs2(a, b):
    #write your code here
    #print(a,b)
    dp=[[0]*(len(a)+1) for i in range(len(b)+1)]
    for i in range(1,len(a)+1):
        for j in range(1,len(b)+1):
            if a[i-1]==b[j-1]:
                dp[j][i]=1+dp[j-1][i-1]
            else:
                dp[j][i]=max(dp[j-1][i],dp[j][i-1])
    #Print the map
    #for i in range(len(dp)):
    #    print(dp[i])

    return dp[len(b)][len(a)]

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))

    n = data[0]
    data = data[1:]
    a = data[:n]

    data = data[n:]
    m = data[0]
    data = data[1:]
    b = data[:m]
    #print(a,b)
    print(lcs2(a, b))
