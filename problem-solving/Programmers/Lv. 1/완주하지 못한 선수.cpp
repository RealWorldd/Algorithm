//프로그래머스 Lv.1 https://school.programmers.co.kr/learn/courses/30/lessons/42576
#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_multiset<string> s;
    for(auto i : participant){
        s.insert(i);
    }
    for(auto i : completion){
        s.erase(s.find(i));
    }
    vector<string> v(s.begin(), s.end());
    return v[0];
}