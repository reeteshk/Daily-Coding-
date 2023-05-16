  public int coinChange(int[] coins, int amount) {
        
        int dp[][]=new int[coins.length][amount+1];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        // int ans = coinchangerec(coins,amount,coins.length-1,dp);
        //  if(ans >= (int)Math.pow(10,9)) return -1;
        // return ans;
         
        //  int ans =coinchangeRec(coins,amount,coins.length-1);
        //   if(ans >= (int)Math.pow(10,9)) return -1;
        // return ans;

        // int ans =coinchangeMemoization(coins,amount,coins.length-1,dp);
        //      if(ans >= (int)Math.pow(10,9)) return -1;
        // return ans;

      //  return coinchangeDP(coins,amount);
        return coinchangeDPOptimized(coins,amount);
         //return minimumElements(coins,amount);


        //S30 SOLUTION
        // return helper(coins,0,amount,0);
    }

//Recursive Approach
      public int coinchangeRec(int coins[],int amount,int n)
    {
        if(n==0)
        {
            if(amount%coins[n]==0)

            {
                return amount/coins[0];
            }
            else
            {
                return (int)Math.pow(10,9);
            }
        }

        int nottake=0+coinchangeRec(coins,amount,n-1);
        int take= (int)Math.pow(10,9);

        if(coins[n]<=amount)
        {
            take=1+coinchangeRec(coins,amount-coins[n],n);
        }
        return Math.min(take,nottake);
    }
//Recursive Approach with Memoization
    public int coinchangeMemoization(int coins[],int amount,int n,int dp[][])
    {
        if(n==0)
        {
            if(amount%coins[n]==0)

            {
                return amount/coins[0];
            }
            else
            {
                return (int)Math.pow(10,9);
            }
        }
        if(dp[n][amount]!=-1)
        {
            return dp[n][amount];
        }
        int nottake=0+coinchangeMemoization(coins,amount,n-1,dp);
        int take= (int)Math.pow(10,9);

        if(coins[n]<=amount)
        {
            take=1+coinchangeMemoization(coins,amount-coins[n],n,dp);
        }
        return dp[n][amount] =Math.min(take,nottake);
    }
//Dynamic Programming Approach
    public int coinchangeDP(int coins[],int amount)
    {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int A=0;A<=amount;A++)
        {
            if(A%coins[0]==0) dp[0][A]=A/coins[0];
            else  dp[0][A]=(int)1e9;
        }
        for(int i=1;i<n;i++)
        {
            for(int A=0;A<=amount;A++)
            {
                int nottake=0+dp[i-1][A];
                 int take= (int)Math.pow(10,9);

                    if(coins[i]<=A)
             {
                          take=1+dp[i][A-coins[i]];
            }
                dp[i][A] =Math.min(take,nottake);
            }

        }

        int ans=dp[n-1][amount];
        if(ans>=1e9) return -1;
        return ans;
    }
//Dynamic Programming Approach Optimized
     public int coinchangeDPOptimized(int coins[],int amount)
    {
        int n=coins.length;
        int prev[]=new int[amount+1];
        int curr[]=new int[amount+1];

      //  int dp[][]=new int[n][amount+1];
        for(int A=0;A<=amount;A++)
        {
            if(A%coins[0]==0) prev[A]=A/coins[0];
            else  prev[A]=(int)1e9;
        }
        for(int i=1;i<n;i++)
        {
            for(int A=0;A<=amount;A++)
            {
                int nottake=0+prev[A];
                 int take= (int)Math.pow(10,9);

                    if(coins[i]<=A)
             {
                          take=1+curr[A-coins[i]];
            }
                curr[A] =Math.min(take,nottake);
            }
            prev=curr;


        }

        int ans=prev[amount];
        if(ans>=1e9) return -1;
        return ans;
    }