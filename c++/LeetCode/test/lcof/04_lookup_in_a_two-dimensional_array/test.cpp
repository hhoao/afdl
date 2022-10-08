#include <string>
#include "Solution.h"

#include <iostream>
#include <utility>
#include <string>
#include <cstring>
#include <vector>
#include <map>
#include <set>
#include <stack>
#include <queue>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <numeric>

using namespace std;

class NestedVec {
public:
    NestedVec() {
        valid = false;
        _value = 0;
    }

    explicit NestedVec(int value) {
        valid = true;
        _value = value;
    }

    bool isInteger() const {
        return valid;
    }

    int getInteger() const {
        return _value;
    }

    void setInteger(int value) {
        valid = true;
        _value = value;
    }

    void add(const NestedVec &ni) {
        vn.push_back(ni);
    }

    [[nodiscard]] const vector<NestedVec> &getList() const {
        return vn;
    }

private:
    bool valid;
    int _value;
    vector<NestedVec> vn;
};

NestedVec dfs(const string &s, int &pos) {
    NestedVec ne;
    ++pos;
    while (pos < s.size()) {
        if (isdigit(s[pos]) || s[pos] == '-') {
            string cur;
            if (s[pos] == '-') {
                cur.push_back(s[pos++]);
            }
            while (isdigit(s[pos])) {
                cur.push_back(s[pos++]);
            }
            ne.add(NestedVec(stoi(cur)));
            cur.clear();
        }
        if (s[pos] == ',' || s[pos] == ' ' || s[pos] == '\n') {
            ++pos;
        }
        if (s[pos] == '[') {
            NestedVec temp = dfs(s, pos);
            ne.add(temp);
        }
        if (s[pos] == ']') {
            ++pos;
            break;
        }
    }
    return ne;
}

NestedVec deserialize(string s) {
    if (s[0] != '[') {
        return NestedVec(stoi(s));
    }
    int pos = 0;
    return dfs(s, pos);
}

// 一维
vector<int> nestVecToVecOne(const NestedVec &nVec) {
    vector<int> res;
    for (auto &nv : nVec.getList()) {
        res.emplace_back(nv.getInteger());
    }
    return res;
}

// 二维
vector<vector<int>> nestVecToVecTwo(const NestedVec &nVec) {
    vector<vector<int>> res;
    for (int i = 0; i < nVec.getList().size(); ++i) {
        res.push_back(nestVecToVecOne(nVec.getList()[i]));
    }
    return res;
}

// 三维
vector<vector<vector<int>>> nestVecToVecThree(const NestedVec &nVec) {
    vector<vector<vector<int>>> res;
    for (int i = 0; i < nVec.getList().size(); ++i) {
        res.push_back(nestVecToVecTwo(nVec.getList()[i]));
    }
    return res;
}

//
// Created by hhoa on 22-9-26.
//
int main(){
    string str = "[\n"
                 "  [1,   4,  7, 11, 15],\n"
                 "  [2,   5,  8, 12, 19],\n"
                 "  [3,   6,  9, 16, 22],\n"
                 "  [10, 13, 14, 17, 24],\n"
                 "  [18, 21, 23, 26, 30]\n"
                 "]\n";

    vector<vector<int>> arr = nestVecToVecTwo(deserialize(str));
    cout << Solution::findNumberIn2DArray(arr, 5) << endl;

    cout << Solution::findNumberIn2DArray(arr, 20) << endl;
}