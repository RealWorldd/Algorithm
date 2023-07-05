#include "bits/stdc++.h"
using namespace std;
bool vis[202];
vector<int> adj[202];
int solution(int n, vector<vector<int>> computers) {
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(j <= i) continue;
            if(computers[i][j] == 1){
                adj[i+1].push_back(j+1);
                adj[j+1].push_back(i+1);
            }
        }
    }
    int res = 0;
    for(int i = 1; i <= n; i++){
        if(vis[i] == 1) continue;
        vis[i] = 1;
        stack<int> s;
        s.push(i);
        res++;
        while(!s.empty()){
            int cur = s.top();
            s.pop();
            for(auto node : adj[cur]){
                if(vis[node]) continue;
                s.push(node);
                vis[node] = 1;
            }
        }
    }
    return res;
}