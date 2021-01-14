# Uses python3
def edit_distance(s, t):
    #write your code here
    s=list(s)
    t=list(t)

    dp=[[0]*(len(s)+1) for i in range(len(t)+1)]
    for i in range(len(s)+1):
        dp[0][i]=i
    for j in range(len(t)+1):
        dp[j][0]=j

    for i in range(len(s)):
        for j in range(len(t)):
            insertion=dp[j+1][i]+1
            deletion=dp[j][i+1]+1
            match=dp[j][i]
            mismatch=dp[j][i]+1
            if s[i]==t[j]:
                dp[j+1][i+1]=min(insertion,deletion,match)
            else:
                dp[j+1][i+1]=min(insertion,deletion,mismatch)
    #Print the map
    """
    for i in range(len(dp)):
        print(dp[i])"""
    return dp[len(t)][len(s)]

if __name__ == "__main__":
    print(edit_distance(input(), input()))
