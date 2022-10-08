//
// Created by hhoa on 22-10-7.
//
#include <Solution.h>
#include <cassert>
#include <iostream>

int main(){
    string ans = Solution::replaceSpace("We are happy.");
    assert(ans == "We%20are%20happy.");
}