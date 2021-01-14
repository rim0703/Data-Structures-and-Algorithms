# Uses python3
import sys

def get_change(m):
    #write your code here
    MinNumCoins=[]
    coins=[1,3,4]
    MinNumCoins.append(0)
    for i in range(1,m+1):
        MinNumCoins.append(sys.maxsize)
        for j in range(len(coins)):
            if i>=coins[j]:
                count=MinNumCoins[i-coins[j]]+1
                if count<MinNumCoins[i]:
                    MinNumCoins[i]=count
    #print(MinNumCoins)
    return MinNumCoins[m]

if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
