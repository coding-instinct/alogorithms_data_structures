#include <iostream>
#include <climits>
using namespace std;
 
int knapsack(int values[], int weights[], int items, int capacity)
{

    if (capacity < 0) {
        return INT_MIN;
    }
 
    if (items < 0 || capacity == 0) {
        return 0;
    }
 
    int include = values[items] + knapsack(values, weights, items - 1, capacity - weights[items]);
    int exclude = knapsack(values, weights, items - 1, capacity);
    return max(include, exclude);
}
 
int main()
{
    int n,i,W;
    cout << "Enter number of items";
    cin >> n;
    int v[n],w[n];
    cout<<  " Input a set of items values";
    for(i=0;i<n;i++)
    {
        cin >> v[i];
    }
    cout<<  " Input a set of items weight";
    for(i=0;i<n;i++)
    {
        cin >> w[i];
    }
 
    cout << "Enter knapsack capacity";
    cin >> W;
    cout << "Knapsack value is " << knapsack(v, w, n - 1, W);
    return 0;
}