//
// Created by hhoa on 22-9-28.
//

#ifndef DATA_STRUCTURE_GRAPH_H
#define DATA_STRUCTURE_GRAPH_H
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

#endif //DATA_STRUCTURE_GRAPH_H
