#include "vector"

//
// Created by hhoa on 22-9-28.
//

#ifndef DATA_STRUCTURE_B_TREE_H
#define DATA_STRUCTURE_B_TREE_H
/**
 * B树是为磁盘或其他直接存取的辅助存储设备而设计的一种平衡搜索树
 * B树和红黑树的不同之处在于B树的节点可以有很多个孩子，从数个到数千个
 * B树性质:
 * 1. 每个节点有以下属性:
 * a. x.n, 当前存储在节点x中的关键字个数。
 * b. x.n个关键字本身 x.key₁, x.key₂, ..., x.keyₓ.ₙ, 以非降序存放a。
 * c. x.leaf, 一个布尔值，如果x是叶结点，则为TRUE; 如果x为内部节点，则为FALSE。
 * 2. 每个内部节点 x 还包含x.n+1个指向其孩子的指针 x.c₁， x.c₂， ...， x.cₓ.ₙ₊₁。叶结点没有孩子，所以他们的 cᵢ属性没有定义。
 * 3. 关键字 x.keyᵢ 对存储在各子树中的关键字范围加以分割： 如果 kᵢ 为任意一个存储在以 x.cᵢ为根的子树中的关键字，那么:
 *          k₁ <= x.key₁ <= k₂ <= x.key₂ <= ... <= x.keyₓ.ₙ <= kₓ.ₙ₊₁
 * 4. 每个叶结点具有相同的深度，即树的高度h。
 * 5. 每个叶结点所包含的关键字个数有上界和下界。用一个被成为B树的最小度数(minmum degree) 的固定整数 t >=2 来表示这些界:
 * a. 除了根节点以外的每个节点必须至少有 t-1 个关键字。因此，除了根节点以外的每个内部节点至少有 t 个孩子。如果树非空，根节点至少有一个关键字。
 * b. 每个节点至多可包含 2t-1 个关键字。因此，一个内部节点至多可有 2t 个孩子。 当一个节点恰好有 2t-1 个关键字时，称该节点是满的。
 *
 */
class b_tree {
private:
    // 节点
    class _tree_node;
    // 最小度数
    int _minmum_degree{2};
    _tree_node* _root;
    /**
     * 搜索
     * @param root 根节点
     * @param key  关键字
     * @return 搜索到的value
     */
    int search(_tree_node *root, int key);
    /**
     * 分裂节点
     */
    void split_child(_tree_node* x, int index) const;
    /**
     * 插入非满节点
     * @param x 当前节点
     * @param key 关键字
     */
    void insert_non_full(_tree_node *x, int key, int value);
    /**
     * 移除 key
     * @param key key
     * @param node node
     */
    std::pair<int, int> remove(int key, _tree_node* node);
public:
    /**
     * 遍历
     * @return 遍历的值
     */
    std::vector<std::pair<int, int>> traverse();

    /**
     * 初始化
     */
    b_tree();
    /**
     * 析构
     */
    ~b_tree();
    /**
     * 搜索
     * @param key 关键字
     * @return 值
     */
    int search(int key);
    /**
     * 插入关键字
     * @param key 关键字
     */
    void put(int key, int value);
    /**
     * 移除 key
     * @param key key
     */
    void remove(int key);
};
#endif //DATA_STRUCTURE_B_TREE_H
