//프로그래머스 Lv. 2 https://school.programmers.co.kr/learn/courses/30/lessons/1844
#include<vector>
#include<queue>
using namespace std;
int dist[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, -1, 0, 1};
int solution(vector<vector<int> > maps){
    queue<pair<int, int>> Q;
    Q.push({0, 0});
    for(int i = 0; i < maps.size(); i++){
        for(int j = 0; j < maps[0].size(); j++){
            if(maps[i][j] == 1) dist[i][j] = -1;
        }
    }
    while(!Q.empty()){
        pair<int, int> cur = Q.front();
        Q.pop();
        dist[0][0] = 1;
        for(int i = 0; i < 4; i++){
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if(nx < 0 || nx >= maps[0].size() || ny < 0 || ny >= maps.size()) continue;
            if(dist[ny][nx] >= 0) continue;
            dist[ny][nx] = dist[cur.second][cur.first] + 1;
            Q.push({nx, ny});
        }
    }
    if(dist[maps.size()-1][maps[0].size() - 1] == 0) return -1;
    return dist[maps.size()-1][maps[0].size()-1];
}