#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    string editdistance(string s,string t) {
        int n1=s.length();
        int n2=t.length();
        int a[26]={0};
        int b[26]={0};
        for(int i=0;i<n1;i++){
            int temp = s[i];
            a[97-temp]++;
        }
        for(int i=0;i<n2;i++){
            int temp = t[i];
            a[97-temp]++;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){ans++;}
        }

        return s;
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
   		string  s,t;
   		cin >> s;
        cin >> t;
   	    Solution ob;

   		cout<<ob.editdistance(s,t);
   	}

    return 0;
}