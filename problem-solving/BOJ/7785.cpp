#include "bits/stdc++.h"
using namespace std;
unordered_set<string> s;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    while(n--){
        string name, status;
        cin >> name >> status;
        if (status == "enter") {
            s.insert(name);
            continue;
        }
        s.erase(name);
    }
    vector<string> ans(s.begin(), s.end());
    sort(ans.begin(), ans.end(), greater<string>());
    for(auto x : ans) cout << x << '\n';
}