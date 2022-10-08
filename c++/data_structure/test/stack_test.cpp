#include "stack.h"
#include "stdio.h"
//
// Created by hhoa on 22-9-28.
//
void traverse(PSTACK pS) {
    PNODE p = pS->pTop;

    while (p != pS->pBottom) {
        printf("%d ", p->data);
        p = p->pNext;
    }
    printf("\n");

    return;
}

int main() {
    int val;
    STACK S;
    init(&S);
    push(&S, 3);
    push(&S, 4);
    push(&S, 5);
    push(&S, 6);
    traverse(&S);
    pop(&S, &val);
    traverse(&S);
    printf("%d\n", val);
    return 0;
}