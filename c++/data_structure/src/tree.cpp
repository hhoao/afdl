/*
	时间:2020年6月22日20:12:14
	二叉树前中后序遍历
*/

# include <malloc.h>
#include "tree.h"


struct BTNode *CreateBTree() {
    auto *pA = (struct BTNode *) malloc(sizeof(struct BTNode));
    auto *pB = (struct BTNode *) malloc(sizeof(struct BTNode));
    auto *pC = (struct BTNode *) malloc(sizeof(struct BTNode));
    auto *pD = (struct BTNode *) malloc(sizeof(struct BTNode));
    auto *pE = (struct BTNode *) malloc(sizeof(struct BTNode));

    pA->data = 'A';
    pB->data = 'B';
    pC->data = 'C';
    pD->data = 'D';
    pE->data = 'E';

    pA->left = pB;
    pA->right = pC;
    pB->left = pB->right = nullptr;
    pC->left = pD;
    pC->right = nullptr;
    pD->left = nullptr;
    pD->right = pE;
    pE->left = pE->right = nullptr;

    return pA;
}

void PreTraverseBTree(struct BTNode *pT) {
    if (pT != nullptr) {
        printf("%c", pT->data);
        if (pT->left != nullptr)
            PreTraverseBTree(pT->left);
        if (pT->right != nullptr) {
            PreTraverseBTree(pT->right);
        }
    }
}

BTNode* InTraverseBTreeIsSort(struct BTNode *pT, struct BTNode* parentNode) {
    if (nullptr != pT) {
        if (parentNode != nullptr) {
            if (pT->data < parentNode->data) {
                printf("err");
            }
        }
        if (nullptr != pT->left) {
            BTNode *ret = InTraverseBTreeIsSort(pT->left, pT);
            if (ret->data > pT->data) {
                printf("err");
            }
        }

        printf("%c", pT->data);

        if (nullptr != pT->right) {
            InTraverseBTreeIsSort(pT->right, pT);
        }
    }
}
void InTraverseBTree(struct BTNode *pT) {
    if (nullptr != pT) {
        if (nullptr != pT->left)
            InTraverseBTree(pT->left);

        printf("%c", pT->data);

        if (nullptr != pT->right)
            InTraverseBTree(pT->right);
    }
}

void PostTraverseBTree(struct BTNode *pT) {
    if (nullptr != pT) {
        if (nullptr != pT->left)
            PostTraverseBTree(pT->left);

        if (nullptr != pT->right)
            PostTraverseBTree(pT->right);

        printf("%c", pT->data);
    }
}
