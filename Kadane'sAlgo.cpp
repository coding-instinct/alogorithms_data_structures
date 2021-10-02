#include<bits/stdc++.h>
using namespace std;
int main(){
int n;
cin>>n;
int a[n];
for(int i=0;i<n;i++)
    cin>>a[i];
int curr = 0;
int maxSum = 0;
for(int i=0;i<n;i++){
    curr = curr + a[i];
    if(curr < 0)
        curr = 0;
    if(curr>maxSum)
        maxSum = curr;
}
cout<<maxSum<<endl;

}
