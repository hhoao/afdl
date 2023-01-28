//
// Created by hhoa on 22-9-28.
//

#ifndef DATA_STRUCTURE_TREE_H
#define DATA_STRUCTURE_TREE_H
struct BTNode
{
    int data;
    struct BTNode * left;
    struct BTNode * right;
};

struct BTNode * CreateBTree();
void PreTraverseBTree(struct BTNode *);
void InTraverseBTree(struct BTNode *);
void PostTraverseBTree(struct BTNode *);
#endif //DATA_STRUCTURE_TREE_H
