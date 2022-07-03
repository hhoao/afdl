#include <stdio.h>
#include <stdlib.h>

/*
堆排序
*/
typedef struct Array {
	int* arr;
	int size;
	int heap_size;
	int length;
	int DEFAULT_INCREASE_SIZE = 10;
	float DEFAULT_INCREASE_FACTOR = 0.75f;
}ARRAY, * PARRAY;

void add(PARRAY pArray, int value);
void traversal(PARRAY pArray);
PARRAY createArray();
PARRAY createArray(int size);
int PARENT(int i);
int LEFT(int i);
int RIGHT(int i);
void MAX_HEAPIFY(PARRAY arr, int index);
void BUILD_MAX_HEAP(PARRAY arr);
void HEAPSORT(PARRAY arr);

int main() {
	PARRAY pArray = createArray();
	add(pArray, 10);
	add(pArray, 25);
	add(pArray, 1);
	add(pArray, 22);
	add(pArray, 4);
	add(pArray, 5);
	add(pArray, 22);
	traversal(pArray);
	HEAPSORT(pArray);
	traversal(pArray);

	return 0;
}

void add(PARRAY pArray, int value) {
	int* arr = pArray->arr;
	arr[pArray->length] = value;
	pArray->length++;
}

void traversal(PARRAY pArray) {
	int length = pArray->length;
	int* arr = pArray->arr;
	printf("\n遍历结果为:");
	for (int i = 0; i < length; i++) {
		printf("%5d", arr[i]);
	}
	printf("\n");
}

PARRAY createArray() {
	int DEFAULT_SIZE = 10;
	return createArray(10);
}

PARRAY createArray(int size) {
	PARRAY array = (PARRAY)malloc(sizeof(ARRAY));
	int* dummy_arr = (int*)malloc(sizeof(int)*size);
	array->arr = dummy_arr;
	array->size = size;
	array->length = 0;
	return array;
}

int PARENT(int i) {
	return (i-1)/2;
}
int LEFT(int i) {
	return i*2+1;
}
int RIGHT(int i) {
	return i*2 +2;
}

void MAX_HEAPIFY(PARRAY pArray, int index) {
	int l, r;
	if (index == 0) {
		l = 1;
		r = 2;
	}
	else {
		l = LEFT(index);
		r = RIGHT(index);
	}
	
	int* arr = pArray->arr;
	int largest = index;
	if (l <= pArray->heap_size && arr[l] > arr[largest]) {
		largest = l;
	}
	if (r <= pArray->heap_size && arr[r] > arr[largest]) {
		largest = r;
	}
	if (largest != index) {
		arr[index] ^= arr[largest];
		arr[largest] ^= arr[index];
		arr[index] ^= arr[largest];
		MAX_HEAPIFY(pArray, largest);
	}
}
void BUILD_MAX_HEAP(PARRAY pArray) {
	pArray->heap_size= pArray->length - 1;
	for (int i = pArray->heap_size/2; i >= 0; i--) {
		MAX_HEAPIFY(pArray, i);
	}
}
void HEAPSORT(PARRAY pArray) {
	BUILD_MAX_HEAP(pArray);
	for (int i= pArray->length -1; i > 0; i--) {
		int* arr = pArray->arr;
		arr[i] ^= arr[0];
		arr[0] ^= arr[i];
		arr[i] ^= arr[0];
		pArray->heap_size--;
		MAX_HEAPIFY(pArray, 0);
	}
}