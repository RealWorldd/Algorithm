#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int n, m, s, e; //n: 도시의 개수, m: 버스의 개수, s: 출발 도시 번호, e: 도착 도시 번호
vector<pair<int, int>> adj[1005];
const int INF = 1e9 + 10;
int d[1005];
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    fill(d, d + n + 1,INF);
    for (int i = 0; i < m; i++) {
        int from, to, cost;
        cin >> from >> to >> cost;
        adj[from].push_back({cost, to});
    }
    cin >> s >> e;
    priority_queue<pair<int, int>,
            vector<pair<int, int>>> pq;
    d[s] = 0;
    pq.push({d[s], s});
    while (!pq.empty()) {
        auto cur = pq.top(); pq.pop();
        if(d[cur.Y] != cur.X) continue;
        for (auto nxt: adj[cur.Y]) {
            if(d[nxt.Y] <= d[cur.Y] + nxt.X) continue;
            d[nxt.Y] = d[cur.Y] + nxt.X;
            pq.push({d[nxt.Y], nxt.Y});
        }
    }
    cout << d[e];
}