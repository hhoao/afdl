//
// Created by hhoa on 22-9-28.
//

#ifndef DATA_STRUCTURE_STACK_H
#define DATA_STRUCTURE_STACK_H

typedef struct Node {
    int data;
    struct Node *pNext;
} NODE, *PNODE;

typedef struct Stack {
    PNODE pTop;
    PNODE pBottom;
} STACK, *PSTACK;

void init(PSTACK);

void push(PSTACK, int);

bool empty(PSTACK);

void clear(STACK);

bool pop(PSTACK, int *);

#endif //DATA_STRUCTURE_STACK_H

