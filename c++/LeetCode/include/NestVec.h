//
// Created by hhoa on 22-10-9.
//
#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

#ifndef LEETCODE_NESTVEC_H
#define LEETCODE_NESTVEC_H
using namespace std;

class NestedVec {
public:
    /**
     * 字符串转化为三维数组
     * @param s 格式[[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]]
     * @return 二维数组
     */
    static vector<vector<vector<int>>> vec_three(string s);

    /**
     * 字符串转化为二维数组
     * @param s 格式[[1, 2], [3, 4]]
     * @return 二维数组
     */
    static std::vector<std::vector<int>> vec_two(string s);

    /**
     * 字符串转化为一维数组
     * @param s 格式[1, 2, 5, 3, 4]类
     * @return 一维数组
     */
    static std::vector<int> vec_one(string s);

private:
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

    [[nodiscard]] const std::vector<NestedVec> &getList() const {
        return vn;
    }

    bool valid;
    int _value;
    vector<NestedVec> vn;

    static NestedVec dfs(const string &s, int &pos);

    static NestedVec deserialize(string s);

    static std::vector<int> nestVecToVecOne(const NestedVec &nVec);

    static std::vector<std::vector<int>> nestVecToVecTwo(const NestedVec &nVec);

    static vector<vector<vector<int>>> nestVecToVecThree(const NestedVec &nVec);
};

vector<vector<vector<int>>> NestedVec::vec_three(string s) {
    NestedVec nestedVec = deserialize(s);
    return nestVecToVecThree(nestedVec);
}

std::vector<std::vector<int>> NestedVec::vec_two(string s) {
    NestedVec nestedVec = deserialize(s);
    return nestVecToVecTwo(nestedVec);
}

std::vector<int> NestedVec::vec_one(string s) {
    NestedVec nestedVec = deserialize(s);
    return nestVecToVecOne(nestedVec);
}

NestedVec NestedVec::dfs(const string &s, int &pos) {
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

NestedVec NestedVec::deserialize(string s) {
    if (s[0] != '[') {
        return NestedVec(stoi(s));
    }
    int pos = 0;
    return dfs(s, pos);
}

// 一维
std::vector<int> NestedVec::nestVecToVecOne(const NestedVec &nVec) {
    std::vector<int> res;
    for (auto &nv: nVec.getList()) {
        res.emplace_back(nv.getInteger());
    }
    return res;
}

// 二维
std::vector<std::vector<int>> NestedVec::nestVecToVecTwo(const NestedVec &nVec) {
    vector<vector<int>> res;
    for (int i = 0; i < nVec.getList().size(); ++i) {
        res.push_back(nestVecToVecOne(nVec.getList()[i]));
    }
    return res;
}

// 三维
vector<vector<vector<int>>> NestedVec::nestVecToVecThree(const NestedVec &nVec) {
    vector<vector<vector<int>>> res;
    for (int i = 0; i < nVec.getList().size(); ++i) {
        res.push_back(nestVecToVecTwo(nVec.getList()[i]));
    }
    return res;
}

#endif //LEETCODE_NESTVEC_H
