# include <stdio.h>
# include  <stdlib.h>
#include "stack.h"



void init(PSTACK pS) {
    pS->pTop = (PNODE) malloc(sizeof(NODE));
    if (pS->pTop == NULL) {
        printf("动态内存分配失败!\n");
        exit(-1);
    } else {
        pS->pBottom = pS->pTop;
        pS->pTop->pNext = NULL;
    }
}

void push(PSTACK pS, int val) {
    PNODE pNew = (PNODE) malloc(sizeof(NODE));
    pNew->data = val;
    pNew->pNext = pS->pTop;
    pS->pTop = pNew;

    return;
}


bool empty(PSTACK pS) {
    if (pS->pTop == pS->pBottom)
        return true;
    else
        return false;

}

bool pop(PSTACK pS, int *pVal) {
    if (empty(pS)) {
        return false;
    } else {
        PNODE r = pS->pTop;
        *pVal = r->data;

        pS->pTop = r->pNext;
        free(r);
        r = NULL;

        return true;
    }
}

void clear(PSTACK pS) {
    if (empty(pS)) {
        return;
    } else {
        PNODE p = pS->pTop;
        PNODE q = p->pNext;

        while (p != pS->pBottom) {
            q = p->pNext;
            free(p);
            p = q;
        }
        pS->pTop = pS->pBottom;
    }
}