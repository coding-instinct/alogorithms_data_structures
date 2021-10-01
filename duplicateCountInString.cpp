#include <bits/stdc++.h>
using namespace std;
class Solution{
public:	
	
	
	void duplicateFinder(string S)
	{
	    // Your code goes here
	    int n = S.length();
        int a[26]={0};
        for(int i=0;i<n;i++){
            a[((int) S[i])-97]++;
        }
        for(int i=0 ;i<26;i++){
            if(a[i]>1){
                cout<<char(97+i)<<" count ="<<a[i]<<endl;
            }
            
        }
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
   		string s;
   		cin >> s;

   	    Solution ob;

   		ob.duplicateFinder(s);
   	}

    return 0;
}