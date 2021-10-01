#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    void longestPallindromeSubString(string S) {
        int n=S.length();
        int l=0,h=0;
        for (int i=0;i<n;i++){
            int count=1;
            int temp=i;
            int set=0,tl,th;
            //cout<<"i"<<i<<endl;
            for(int j=n-1;j>=i;j--)
            {
                //cout<<"j"<<j<<" i "<<i<<endl;
                if(S[j]==S[temp]){

                    if(set==0){
                        set=1;
                        //cout<<"1l"<<tl<<" h"<<th<<endl;
                        tl=i;
                        th=j;
                       //cout<<"2l"<<tl<<" h"<<th<<endl;
                        }
                    if(temp==j || temp==j-1){
                        //cout<<"l"<<tl<<" h"<<th<<endl;
                        if((h-l)<(th-tl)){
                            l=tl;
                            h=th;
                        }
                    }
                    temp++;
                }
                else{
                    if(S[i]==S[j]){
                        cout<<"yes";
                        th=j;
                        temp=i+1;
                    }
                    else{
                        temp=i;
                        set=0;
                    }

                    
                }
            }
            if(count==n-i){

            }
        }
    for(int i=l;i<=h;i++){
        cout<<S[i];
    }
    cout<<endl;

    }

    //void brute force solution done by 3 for loops
    void lpsBruteForce(string S) {
        int n=S.length();
        int l=0,h=0;
        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                //pallindorme check algo 
                int count=0;
                for(int k=i;k<=j;k++){
                    if(S[k]==S[j-k+i]){
                        count++;
                    }
                    else{k=j+1;}
                }
                if(count==(j-i+1)){
                    if((h-l)<(j-i)){
                        l=i;
                        h=j;
                    }
                }

            }
        }
    for(int i=l;i<=h;i++){
        cout<<S[i];
    }
    cout<<endl;

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
   		string  s;
   		cin >> s;
   	    Solution ob;
   		ob.lpsBruteForce(s);
        ob.longestPallindromeSubString(s);
   	}

    return 0;
}