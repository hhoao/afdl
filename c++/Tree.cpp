/*
	时间:2020年6月22日20:12:14
	二叉树前中后序遍历
*/

# include <stdio.h>
# include <malloc.h>

struct BTNode
{
	char data;
	struct BTNode * pLchild;
	struct BTNode * pRchild;
};

struct BTNode * CreateBTree(void);
void PreTraverseBTree(struct BTNode *);
void InTraverseBTree(struct BTNode *);
void PostTraverseBTree(struct BTNode *);

int main(void)
{
	struct BTNode * pT = CreateBTree();
//	PreTraverseBTree(pT);
//	InTraverseBTree(pT);
	PostTraverseBTree(pT);

	
	return 0;
}

struct BTNode * CreateBTree(void)
{
	struct BTNode * pA = (struct BTNode *)malloc(sizeof(struct BTNode));
	struct BTNode * pB = (struct BTNode *)malloc(sizeof(struct BTNode));
	struct BTNode * pC = (struct BTNode *)malloc(sizeof(struct BTNode));
	struct BTNode * pD = (struct BTNode *)malloc(sizeof(struct BTNode));
	struct BTNode * pE = (struct BTNode *)malloc(sizeof(struct BTNode));

	pA->data = 'A';
	pB->data = 'B';
	pC->data = 'C';
	pD->data = 'D';
	pE->data = 'E';

	pA->pLchild = pB;
	pA->pRchild = pC;
	pB->pLchild = pB->pRchild = NULL;
	pC->pLchild = pD;
	pC->pRchild = NULL;
	pD->pLchild = NULL;
	pD->pRchild = pE;
	pE->pLchild = pE->pRchild = NULL;
	
	return pA;
}

void PreTraverseBTree(struct BTNode * pT)
{
	if(pT != NULL)
	{
		printf("%c", pT->data);
		if(pT->pLchild != NULL)
			PreTraverseBTree(pT->pLchild);
		if(pT->pRchild != NULL)
			PreTraverseBTree(pT->pRchild);
	}

	return ;
}

void InTraverseBTree(struct BTNode * pT)
{
	if(NULL != pT)
	{
		if(NULL != pT->pLchild)
			InTraverseBTree(pT->pLchild);

		printf("%c", pT->data);

		if(NULL != pT->pRchild)
			InTraverseBTree(pT->pRchild);
	}

	return ;
}

void PostTraverseBTree(struct BTNode * pT)
{
	if(NULL != pT)
	{
		if(NULL != pT->pLchild)
			PostTraverseBTree(pT->pLchild);
		
		if(NULL != pT->pRchild)
			PostTraverseBTree(pT->pRchild);
		
		printf("%c", pT->data);
	}

	return ;
}

/*
在Vc++6.0中的输出结果是：
---------------------------------------------
---------------------------------------------
*/