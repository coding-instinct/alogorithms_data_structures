#include<iostream>
using namespace std;
int main(){
int n;
cin>>n;
int a[n];
for(int i=0;i<n;i++)
    cin>>a[i];
int key;
cout<<"Enter Key "<<endl;
cin>>key;
int s = 0,e = n-1;
while(s<=e){
    int m = (s+e)/2;
    if(a[m]==key){
        cout<<key<<" present at "<<m<<endl;
        break;
    }
    else{
        if(a[m]<key){
            s = m+1;
        }
        if(a[m]>key){
            e = m-1;
        }
    }
}

if(s>e){
    cout<<"Key is not present"<<endl;
}


}
