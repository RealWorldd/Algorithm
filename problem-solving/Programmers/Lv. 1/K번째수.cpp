//https://school.programmers.co.kr/learn/courses/30/lessons/42748
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> ans;
    for(auto i : commands){
        vector<int> v;
        for(int j = i[0] - 1; j < i[1]; j++){
            v.push_back(array[j]);
        }
        sort(v.begin(), v.end());
        ans.push_back(v[i[2]-1]);
    }
    return ans;
}