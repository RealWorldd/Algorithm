#include "bits/stdc++.h"
using namespace std;
string s;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> s;
    if(s.size() % 2 != 0) {
        cout << 0;
        return 0;
    }
    stack<int> st;
    int res = 0;
    int cnt = 1;
    bool cal = true;
    for (auto i: s) {
        if(i == '(' || i == '[') {
            cal = true;
            if(i == '(') cnt *= 2;
            if(i == '[') cnt *= 3;
            st.push(i);
            continue;
        }
        if(i == ')') {
            if(st.empty() || st.top() != '(') {
                cout << 0;
                return 0;
            }
            if(cal) {
                res += cnt;
                cal = false;
            }
            if(!st.empty()) st.pop();
            cnt /= 2;
        }
        if (i == ']') {
            if(st.empty() || st.top() != '[') {
                cout << 0;
                return 0;
            }
            if(cal) {
                res += cnt;
                cal = false;
            }
            if(!st.empty()) st.pop();
            cnt /= 3;
        }
    }
    cout << res;
}