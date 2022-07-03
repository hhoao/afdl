# include <stdio.h>
# include <malloc.h>
# include  <stdlib.h>

typedef struct Node
{
	int data;
	struct Node * pNext;
}NODE, * PNODE;

typedef struct Stack
{
	PNODE pTop;
	PNODE pBottom;
}STACK, *PSTACK;

void init(PSTACK);
void push(PSTACK , int );
void traverse(PSTACK);
bool empty(PSTACK );
void clear(STACK);
bool pop(PSTACK, int *);

int main(void)
{
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

void init(PSTACK pS)
{
	pS->pTop = (PNODE)malloc(sizeof(NODE));
	if(pS->pTop == NULL)
	{
		printf("¶¯Ì¬ÄÚ´æ·ÖÅäÊ§°Ü!\n");
		exit(-1);
	}
	else
	{
		pS->pBottom = pS->pTop;
		pS->pTop->pNext = NULL;
	}
}

void push(PSTACK pS, int val)
{
	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	pNew->data = val;
	pNew->pNext = pS->pTop;
	pS->pTop = pNew;

	return ;
}

void traverse(PSTACK pS)
{
	PNODE p = pS->pTop;

	while(p != pS->pBottom)
	{
		printf("%d ", p->data);
		p = p->pNext;
	}
	printf("\n");

	return;
}

bool empty(PSTACK pS)
{
	if (pS->pTop == pS->pBottom)
		return true;
	else
		return false;

}

bool pop(PSTACK pS, int * pVal)
{
	if( empty(pS) )
	{
		return false;
	}
	else
	{
		PNODE r = pS->pTop;
		*pVal = r->data;

		pS->pTop = r->pNext;
		free(r);
		r = NULL;

		return true;
	}
}

void clear(PSTACK pS)
{
	if(empty(pS))
	{
		return ;
	}
	else
	{
		PNODE p = pS->pTop;
		PNODE q = p->pNext;

		while(p != pS->pBottom)
		{
			q = p->pNext;
			free(p);
			p = q;	
		}
		pS->pTop = pS->pBottom;
	}
}