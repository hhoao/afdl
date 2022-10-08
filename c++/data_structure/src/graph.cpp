#include <iostream>
#include <stdio.h>
#include<stdlib.h>
#include "graph.h"
//顶点(vertex) 弧(arc)


Status createGraph(MGraph* graph);
Status createDN(MGraph* graph);
Status createDG(MGraph* graph);
Status createUDG(MGraph* graph);
Status createUDN(MGraph* graph);

int main(){ 
	MGraph graph;
	if (createGraph(&graph)) {
		printf("图构造成功!\n");
	}
	
	printf("%d", graph.vexs[0]);
	return 0;
}
Status createGraph(MGraph *graph) {
	printf("请输入图的类型:");
	scanf("%d", &graph->kind);
	getchar();
	switch (graph->kind) {
		case DG: return createDG(graph); break;
		case DN: return createDN(graph); break;
		case UDG: return createUDG(graph); break;
		case UDN: return createUDN(graph); break;
	}
	return 0;
}
Status createDG(MGraph *graph) {
	return false;
}
Status createDN(MGraph *graph) {
	return false;
}
Status createUDG(MGraph *graph) {
	printf("请输入顶点的个数:");
	scanf("%d", &graph->vexnum);
	getchar();
	printf("请输入弧的数量:");
	scanf("%d", &graph->arcnum);
	getchar();
	for (int i = 0; i < graph->vexnum; ++i) {//构造顶点向量
		printf("请输入顶点向量第%d个的值:", i+1);
		scanf("%d", &graph->vexs[i].value);
		getchar();
	}
	for (int i = 0; i < graph->vexnum; ++i) {//初始化邻接矩阵
		for (int j = 0; j < graph->vexnum; ++j) {
			graph->arcs[i][j] = { WEIGMAX, NULL };
		}
	}
	for (int k = 0; k < graph->arcnum; ++k) {
		int v1, v2, w;
		printf("第%d个弧的顶点1:", k);
		scanf("%d", &v1);
		getchar();
		printf("第%d个弧的顶点2:", k);
		scanf("%d", &v2);
		getchar();
		printf("第%d个弧的权值:", k);
		scanf("%d", &w);
		getchar();
		graph->arcs[v1][v2].adj = w;
		graph->arcs[v2][v1].adj = w;
	}
	return true;
}
Status createUDN(MGraph *graph) {
	return false;
}
VertexType locateVex(MGraph* graph, int v) {
	return graph->vexs[v];
}