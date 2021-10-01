#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    string countAndSay(int n) {
        string a="11",b,c;
        if(n==1){return "1";}
        if(n==2){return "11";}
        for(int i=2;i<n;i++)
        {
            int nt=a.length();
            b="";
            int count=1;
            for(int j=1;j<nt;j++)
            {
                if(a[j]==a[j-1]){
                    count++;
                }
                else{
                    b=b+to_string(count)+a[j-1];
                    count=1;
                }
            }
            b=b+to_string(count)+a[nt-1];
            a=b;
        }
        return a;
    }
};
int main() 
{
   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
   	cin >> t;
   	while(t--)
   	{
   		int  n;
   		cin >> n;

   	    Solution ob;

   		cout<<ob.countAndSay(n);
   	}

    return 0;
}