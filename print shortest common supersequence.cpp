#include<bits/stdc++.h>
#define ll long long int
#define deb(x) cout << #x << " = " << x << endl
#define deb2(x, y) cout << #x << " = " << x << "," << #y << " = " << y << endl
#define endl '\n'
using namespace std;

void lcs(string s1,string s2,int n,int m)
{
    int dp[n+1][m+1],i,j;
    for(i=0;i<n+1;i++)
        for ( j = 0; j < m+1; j++)
        {
            if(i==0||j==0)
                dp[i][j]=0;
        }
    for(i=1;i<n+1;i++)
        for ( j = 1; j < m+1; j++)
        {
            if(s1[i-1]==s2[j-1])
            {
                dp[i][j]=1+dp[i-1][j-1];
            }
            else
            {
                dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
            }
        }
        string str;
        i=n,j=m;
        while(i!=0 && j!=0)
            {
                if(s1[i-1]==s2[j-1])
                {
                    str.push_back(s1[i-1]);
                    i--; j--;
                }
                else
                {
                    if(dp[i-1][j]<dp[i][j-1])
                        {
                            j--;
                            str.push_back(s2[j]);
                        }
                    else
                        {
                            i--;
                            str.push_back(s1[i]);
                        }
                }
            }
        while(i>0)
        {
            str.push_back(s1[i-1]);
            i--;
        }
        while (j>0)
        {
            str.push_back(s2[j-1]);
            j--;
        }
        
            reverse(str.begin(),str.end());
            cout<<str<<endl;
}

void entente()
{
   //start solving 
   int x,y;
   string s1,s2;
   cin>>x>>y;
   cin>>s1>>s2;
   lcs(s1,s2,x,y);
}

int main()
{
    //ios_base::sync_with_stdio(false);cin.tie(NULL);
    int t; cin>>t; while(t--)
    {
        entente();
    }
    return 0;
}