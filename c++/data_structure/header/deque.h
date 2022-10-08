//
// Created by hhoa on 22-9-28.
//

#ifndef DATA_STRUCTURE_DEQUE_H
#define DATA_STRUCTURE_DEQUE_H
typedef struct DequeItem {
    int data;
    struct DequeItem* nextItem;
}DEQUEITEM, *PDEQUEITEM;

typedef struct Deque {
    PDEQUEITEM head;
    PDEQUEITEM tail;
    int size;
}DEQUE, *PDEQUE;

#endif //DATA_STRUCTURE_DEQUE_H
