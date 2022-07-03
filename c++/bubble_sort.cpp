/*
时间：2020年4月27日18:28:08
冒泡排序更改版，更形象
*/

# include <stdio.h>
# include <stdlib.h>

void Swap(int * i, int j, int k)//交换函数
{
	int f;
	
	f = i[j];
	i[j] = i[k];
	i[k] = f;
}

void Sort(int * k, int pnum)//排序函数
{
	int i;
	int j;

	for(i=0; i<pnum; i++)
	{
		for(j=0; j<pnum-1-i; j++)
		{
			if(k[j] < k[j+1])
				Swap(k, j, j+1);
		}
	}
}

void OutputSort(int * k, int pnum)//输出函数
{
	int i;

	printf("排序结果为:");
	for(i=0; i<pnum; i++)
	{
		printf("%d   ", k[i]);
	}
	printf("\n");
}

int main(void)
{
	int * i;
	int num;
	int j;

	printf("请输入需要排序数字数量：");
	scanf("%d", &num);

	i = (int *)malloc(num*sizeof(int));//构建动态数组

	for(j=0; j<num; j++)
	{
		printf("请输入数字:");
		scanf("%d", &i[j]);
	}

	printf("准备对该数组进行排序:");
	
	for(j=0; j<num; j++)
	{
		printf("%d  ", i[j]);
	}

	printf("\n");
	
	Sort(i, num);

	OutputSort(i, num);

	return 0;
}

/*
在Vc++6.0中的输出结果是：
--------------------------------------

--------------------------------------
*/