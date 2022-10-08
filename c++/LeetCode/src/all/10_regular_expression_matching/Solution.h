//
// Created by hhoa on 22-9-23.
//
#include <string>

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H
using namespace std;

//10. 正则表达式匹配
//        给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//'.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
class Solution {
public:
    /**
     * 10.正则表达式匹配
     * @param s 输入的字符串
     * @param p 输入的匹配模式
     * @return 是否匹配
     */
    bool isMatch(string s, string p);
};


#endif //LEETCODE_SOLUTION_H
