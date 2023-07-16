#include "bits/stdc++.h"
using namespace std;
int n, m, k, x; //n: 도시 개수, m: 도로 개수, k: 거리 정보, x: 출발 도시 번호
vector<int> adj[300005];
bool vis[300005];
int dis[300005];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m >> k >> x;
    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        adj[from].push_back(to);
    }
    queue<int> q;
    q.push(x);
    vis[x] = true;
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int nxt: adj[cur]) {
            if(vis[nxt]) continue;
            dis[nxt] = dis[cur] + 1;
            q.push(nxt);
            vis[nxt] = true;
        }
    }
    vector<int> res;
    for (int i = 1; i <= n; i++) {
        if(i != x && dis[i] == k) {
            res.push_back(i);
        }
    }
    if(res.empty()){
        cout << -1;
        return 0;
    }
    sort(res.begin(), res.end());
    for (auto i: res) {
        cout << i << "\n";
    }
}