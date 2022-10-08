/*
	时间:2020年6月20日20:13:59
	快速排序
*/
# include <stdio.h>

void QuickSort(int *, int, int);
int FindPos(int *, int, int);

int main(void)
{
	int arr[3] = {1, 5, 1};

	QuickSort(arr, 0, 2);

	int j;
	for(j=0; j<3; j++)
	{
		printf("%d ", arr[j]);
	}
	printf("\n");

	return 0;
}

void QuickSort(int * arr, int low, int high)
{
	int pos;
	if(low < high)
	{
		pos = FindPos(arr, low, high);
		QuickSort(arr, low, pos-1);
		QuickSort(arr, pos+1, high);
	}

	return ;
}

int FindPos(int * arr, int low, int high)
{
	int val = arr[low];
	
	while(low < high)
	{
		while (low<high && arr[high]>=val)
			--high;
		arr[low] = arr[high];
		
		while (low<high && arr[low]<=val)
			++low;
		arr[high] = arr[low];
	}
	arr[high] = val;

	return high;
}