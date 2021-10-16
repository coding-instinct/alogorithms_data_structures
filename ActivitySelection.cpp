#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    int maxMeetings(int start[], int end[], int n)
    {
        vector<pair<int, int>> a;
        for (int i=0;i<n;i++)
            a.push_back(make_pair(end[i], start[i]));
        sort(a.begin(), a.end());
        int ctr=1;
        int j=0;
        for (int i=1;i<n&&j<n-1;i++)
        {
            if (a[j].first < a[i].second)
            {
                ctr++;
                j = i;
            }
        }
        return ctr;
        // Your code here
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int start[n], end[n];
        for (int i = 0; i < n; i++) cin >> start[i];

        for (int i = 0; i < n; i++) cin >> end[i];

        Solution ob;
        int ans = ob.maxMeetings(start, end, n);
        cout << ans << endl;
    }
    return 0;
}  // } Driver Code Ends
