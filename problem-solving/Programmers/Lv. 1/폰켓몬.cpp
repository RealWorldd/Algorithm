//프로그래머스 Lv.1 https://school.programmers.co.kr/learn/courses/30/lessons/1845
#include <vector>
#include <unordered_set>
using namespace std;
int solution(vector<int> nums)
{
    int size = nums.size();
    unordered_set<int> s;
    for(auto i : nums){
        s.insert(i);
    }
    if(s.size() >= size / 2){
        return size / 2;
    }
    return s.size();
}

