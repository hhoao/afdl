#include "tree.h"
//
// Created by hhoa on 22-9-28.
//
int main()
{
    struct BTNode * pT = CreateBTree();
//	PreTraverseBTree(pT);
//	InTraverseBTree(pT);
    PostTraverseBTree(pT);
    return 0;
}
