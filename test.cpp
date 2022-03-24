#include<bits/stdc++.h>
using namespace std;

void solve(vector<int>& arr){
    int n = arr.size();
    sort(arr.begin(), arr.end());
    int lo = 0, hi = n-1;
    int curr = (int)1e9, f, s;
    while(lo < hi){
        int val = abs(arr[lo] + arr[hi]);
        if(val <= curr ){
            curr= val;
            f= arr[lo];
            s = arr[hi];
        }else {
            lo++;
        }
    }
    while(lo < hi){
        int val = abs(arr[lo] + arr[hi]);
        if(val <= curr ){
            curr= val;
            f= arr[lo];
            s = arr[hi];
        }else {
            hi--;
        }
    }
    cout<<f<<" "<<s;
}

int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0; i<n; i++){
        cin>>arr[i];
    }
    solve(arr);
}