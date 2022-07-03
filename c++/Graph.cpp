#include <iostream>
#include <stdio.h>
#include<stdlib.h>
//顶点(vertex) 弧(arc)

#define MAX_VERTEX_NUM 20
#define WEIGMAX 10

typedef bool Status;
typedef int VRType; //顶点关系类型

typedef enum GraphKind{
	DG = 0, DN, UDG, UDN //有向图、有向网、无向图、无向网
} GraphKind; //图的类别

typedef struct VertexType{
	int value;
}VertexType;

typedef struct InfoType {
	int value;
}InfoType;//该弧相关信息的指针

typedef struct ArcCell {
	VRType adj;
	InfoType* info; 
}ArcCell, AdjMatrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM];//邻接矩阵

typedef struct {
	VertexType vexs[MAX_VERTEX_NUM];//顶点向量
	AdjMatrix arcs;
	int vexnum, arcnum;//图的当前顶点数和弧数
	GraphKind kind;//
}MGraph;//图
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
	scanf_s("%d", &graph->kind);
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
	scanf_s("%d", &graph->vexnum);
	getchar();
	printf("请输入弧的数量:");
	scanf_s("%d", &graph->arcnum);
	getchar();
	for (int i = 0; i < graph->vexnum; ++i) {//构造顶点向量
		printf("请输入顶点向量第%d个的值:", i+1);
		scanf_s("%d", &graph->vexs[i].value);
		getchar();
	}
	for (int i = 0; i < graph->vexnum; ++i) {//初始化邻接矩阵
		for (int j = 0; j < graph->vexnum; ++j) {
			graph->arcs[i][j] = { WEIGMAX, NULL };
		}
	}
	for (int k = 0; k < graph->arcnum; ++k) {
		int v1, v2, w;
		printf_s("第%d个弧的顶点1:", k);
		scanf_s("%d", &v1);
		getchar();
		printf_s("第%d个弧的顶点2:", k);
		scanf_s("%d", &v2);
		getchar();
		printf_s("第%d个弧的权值:", k);
		scanf_s("%d", &w);
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