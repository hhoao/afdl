#include<stdio.h>
#include <stdlib.h>

#include <deque.h>

int peek(PDEQUE pDeque);
int poll(PDEQUE pDeque);
bool isEmpty(PDEQUE pDeque);
void offer(PDEQUE pDeque, int value);
void offer(PDEQUE pDeque, PDEQUEITEM pItem);
int pop(PDEQUE pDeque);
void push(PDEQUE pDeque, int value);
void push(PDEQUE pDeque, PDEQUEITEM pItem);

int main() {
	return 0;
}

int pop(PDEQUE pDeque) {
	if (isEmpty(pDeque)) {
		return -1;
	}
	PDEQUEITEM head = pDeque->head;
	pDeque->head = pDeque->head->nextItem;
	int value = head->data;
	return value;
}

void push(PDEQUE pDeque, int value) {
	PDEQUEITEM item = (PDEQUEITEM)malloc(sizeof(DEQUE));
	item->data = value;
	item->nextItem = NULL;
	push(pDeque, item);
}

void push(PDEQUE pDeque, PDEQUEITEM pItem) {
	if (isEmpty(pDeque)) {
		pDeque->head = pItem;
		pDeque->tail = pItem;
	}
	else {
		PDEQUEITEM head = pDeque->head;
		pDeque->head = pItem;
		pItem->nextItem = head;
	}
}

int peek(PDEQUE PDEQUE) {
	return isEmpty(PDEQUE) ? -1 : PDEQUE->head->data;
}

int poll(PDEQUE PDEQUE) {
	if (isEmpty(PDEQUE)) {
		return -1;
	}
	PDEQUEITEM head = PDEQUE->head;
	int value = head->data;
	if (PDEQUE->size == 1) {
		PDEQUE->head = NULL;
		PDEQUE->tail = NULL;
	}
	else {
		PDEQUE->head = PDEQUE->head->nextItem;
	}
	free(head);
	(PDEQUE->size)--;
	return value;
}

bool isEmpty(PDEQUE PDEQUE) {
	return PDEQUE->size == 0;
}

void offer(PDEQUE PDEQUE, int value) {
	PDEQUEITEM pItem = (PDEQUEITEM)malloc(sizeof(DEQUEITEM));
	pItem->data = value;
	pItem->nextItem = NULL;
	offer(PDEQUE, pItem);
}

void offer(PDEQUE PDEQUE, PDEQUEITEM pItem) {
	if (PDEQUE->head == NULL) {
		PDEQUE->head = pItem;
		PDEQUE->tail = pItem;
	}
	else {
		PDEQUE->tail->nextItem = pItem;
		PDEQUE->tail = pItem;
	}
	PDEQUE->size++;
}

PDEQUE createQueue() {
	PDEQUE pDeque = (PDEQUE)malloc(sizeof(DEQUE));
	pDeque->head = NULL;
	pDeque->tail = NULL;
	pDeque->size = 0;
	return pDeque;
}