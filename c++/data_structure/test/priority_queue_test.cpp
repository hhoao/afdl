//#include "../header/priority_queue.h"
#include <cstdio>
#include "priority_queue.h"

int main() {
	PriorityQueue queue;
	queue.offer(9);
	queue.offer(8);
	queue.offer(7);
	queue.offer(6);
	queue.offer(5);
	queue.offer(4);
	queue.offer(3);
	queue.offer(2);
	queue.offer(1);
	printf("%d ", queue.poll());
	printf("%d ", queue.poll());
	printf("%d ", queue.poll());
	printf("%d ", queue.poll());
	printf("%d ", queue.poll());
	printf("%d ", queue.poll());
	printf("%d ", queue.poll());
}
