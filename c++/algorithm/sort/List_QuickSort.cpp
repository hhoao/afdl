# include <stdio.h>
# include <stdlib.h>
# include <malloc.h>

typedef struct Node
{
	int data;
	struct Node * pNext;
}NODE, * PNODE;

PNODE create_list(void);
void traverse_list(PNODE);
bool insert_list(PNODE, int, int);
bool delete_list(PNODE, int, int *);
void sort_list(PNODE, int, int);
int FindPos(PNODE, int, int);
int length_list(PNODE);
bool is_empty(PNODE);

int main(void)
{
	int len;
	int val, pos;
	PNODE pHead = (PNODE)malloc(sizeof(NODE));
	
	pHead = create_list();
	traverse_list(pHead);
	len = length_list(pHead);
	printf("%d\n", len);
	sort_list(pHead, 1, len);
	traverse_list(pHead);
	printf("请输入需要插入的数的位置:");
	scanf("%d", &pos);
	printf("请输入需要插入的数的值:");
	scanf("%d", &val);
	insert_list(pHead, pos, val);
	traverse_list(pHead);
	printf("请输入需要删除的数的位置:");
	scanf("%d", &pos);
	delete_list(pHead, pos, &val);
	printf("删除的数为:%d\n", val);
	traverse_list(pHead);


	return 0;
}

PNODE create_list(void)
{
	int val;
	int i;
	int num;

	PNODE pHead = (PNODE)malloc(sizeof(NODE));
	
	if(pHead == NULL)
	{
		printf("动态内存分配失败程序终止");
		exit(-1);
	}
	
	PNODE pTail = pHead;
	pTail->pNext = NULL;
	
	printf("请输入需要链表的节点的个数:");
	scanf("%d", &num);
	
	for(i=0; i<num; ++i)
	{
		printf("请输入第%d个节点的值:", i+1);
		scanf("%d", &val);
		
		PNODE pNew = (PNODE)malloc(sizeof(NODE));
		if(pNew == NULL)
		{
			printf("动态内存分配失败程序终止");
			exit(-1);
		}
		
		pNew->data = val;
		pTail->pNext = pNew;
		pNew->pNext = NULL;
		pTail = pNew;
	}
	
	return pHead;
}

void traverse_list(PNODE pHead)
{
	PNODE p = pHead->pNext;

	while(p != NULL)
	{
		printf("%d", p->data);
		p = p->pNext;
	}
	printf("\n");

	return;
}

bool is_empty(PNODE pHead)
{
	if(pHead->pNext == NULL)
		return true;
	else
		return false;
}

bool insert_list(PNODE pHead, int pos, int val)
{
	int i = 0;
	PNODE p = pHead;

	if( is_empty(pHead) )
	{
		printf("该链表为空");
		return false;
	}                                                                                                                                                                                                                                                                                                                              
	
	while (i<pos-1 && p->pNext != NULL )
	{
		i++;
		p = p->pNext;
	}
	
	PNODE pNew = (PNODE)malloc(sizeof(NODE));
	if(pNew == NULL)
	{
		printf("动态内存分配失败程序终止");
		exit(-1);
	}

	if(i>pos-1 || p->pNext == NULL)
	{
		return false;
	}
	
	pNew->pNext = p->pNext;
	p->pNext = pNew;
	pNew->data = val;

	return true;
}

bool delete_list(PNODE pHead, int pos, int * val)
{
	PNODE p = pHead;
	int i = 0;
	
	while(i<pos-1 && p->pNext != NULL)
	{
		i++;
		p = p->pNext;
	}

	if(i>pos-1 || p->pNext == NULL)
	{
		return false;
	}

	PNODE q;
	q = p->pNext;
	*val = q->data;
	p->pNext = p->pNext->pNext;

	free(q);
	
	return true;
}

int length_list(PNODE pHead)
{
	PNODE p = pHead;
	int len = 0;
	
	while(p->pNext != NULL)
	{
		len++;
		p = p->pNext;
	}
	
	return len;
}

void sort_list(PNODE pHead, int low, int high)
{
	int pos;

	if(low < high)
	{
		pos = FindPos(pHead, low, high);
		sort_list(pHead, low, pos-1);
		sort_list(pHead, pos+1, high);
	}
	
	return ;
}

int FindPos(PNODE pHead, int low, int high)
{
	int i, j, k, val;

	PNODE q;
	PNODE s;
	PNODE p = pHead;

	for(k=0; k<low; k++)
		p = p->pNext;

	for(i=0, s=pHead->pNext; i<high-1; i++)
		s = s->pNext;

	for(j=0, q=pHead->pNext; j<low-1; j++)
		q = q->pNext;

	val = p->data;

	while(low < high)
	{
		while(low<high && s->data>=val)
		{
			high--;

			for(i=0, s=pHead->pNext; i<high-1; i++)
				s = s->pNext;
		}

		q->data = s->data;

		while(low<high && q->data<=val)
		{
c			low++;
			for(j=0, q=pHead->pNext; j<low-1; j++)
				q = q->pNext;
		}

		s->data = q->data;	
	}

	q->data = val;

	return low;
}