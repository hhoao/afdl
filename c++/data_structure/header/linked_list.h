//
// Created by hhoa on 22-9-28.
//

#ifndef DATA_STRUCTURE_LINKED_LIST_H
#define DATA_STRUCTURE_LINKED_LIST_H

/**
 * 链表
 * @tparam type 存储类
 */
template <class type>
class linked_list
{
private:
    class _list_node;
public:
    _list_node* _node;
    linked_list();
    ~linked_list();
    /**
     * 插入
     * @param index 位置
     * @param value 值
     * @return 是否成功
     */
    bool insert(int index, type value);
    /**
     * 添加
     * @param value 添加的值
     * @return 是否成功
     */
    bool add(type value);
    /**
     * 获取
     * @param index 下标
     * @return 获取的值
     */
    type get(int index);
    /**
     * 获取链表大小
     * @return 链表大小
     */
    int size();
    /**
     * 是否为空
     * @return 是否为空
     */
    bool is_empty();
    /**
     * 移除元素
     * @param index 下标
     * @return 是否移除成功
     */
    bool remove(int index);
};

#endif //DATA_STRUCTURE_LINKED_LIST_H
