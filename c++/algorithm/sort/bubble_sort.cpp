/*
ʱ�䣺2020��4��27��18:28:08
ð��������İ棬������
*/

# include <stdio.h>
# include <stdlib.h>

void Swap(int * i, int j, int k)//��������
{
	int f;
	
	f = i[j];
	i[j] = i[k];
	i[k] = f;
}

void Sort(int * k, int pnum)//������
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

void OutputSort(int * k, int pnum)//�������
{
	int i;

	printf("������Ϊ:");
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

	printf("��������Ҫ��������������");
	scanf("%d", &num);

	i = (int *)malloc(num*sizeof(int));//������̬����

	for(j=0; j<num; j++)
	{
		printf("����������:");
		scanf("%d", &i[j]);
	}

	printf("׼���Ը������������:");
	
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
��Vc++6.0�е��������ǣ�
--------------------------------------

--------------------------------------
*/