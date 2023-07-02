#include "bits/stdc++.h"
using namespace std;
int n, m;
vector<int> adj[102];
bool vis[102];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 1; i <= m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    int res = 0;
    stack<int> s;
    s.push(1);
    vis[1] = true;
    while (!s.empty()) {
        int cur = s.top();
        s.pop();
        for (auto nxt: adj[cur]) {
            if(vis[nxt]) continue;
            s.push(nxt);
            vis[nxt] = true;
            res++;
        }
    }
    cout << res;
}