package com.so;

import com.so.Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 第60题
 * 之字形打印二叉树
 *
 * @author qgl
 * @date 2017/08/30
 */
public class ZTreePrint60 {
    /**
     * 解法一：迭代
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> Print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 如果为空节点直接返回
        if (root == null) {
            return res;
        }
        // 使用队列进行存储，这里使用队列可以做到添加到队列后取出的时候从队列移除，
        // 后面再次添加的时候保证队列中的数据可进入下一次循环
        Queue<TreeNode> queue = new LinkedList<>();
        // 存储头节点
        queue.add(root);
        // 深度记录
        int depth = 0;
        // 循环遍历队列
        while (!queue.isEmpty()) {
            // 创建临时存储列表
            LinkedList<Integer> tmp = new LinkedList<>();
            // 获取队列的大小
            int size = queue.size();
            // 循环取出队列的数据
            for (int i = 0; i < size; i++) {
                // 取出队列的数据
                TreeNode node = queue.poll();
                // 判断循环深度是否是2的整倍数，如果是，tmp记录节点的值
                if (depth % 2 == 0) {
                    tmp.add(node.val);
                }
                // 如果不是2的整倍数，添加到列表头部
                else {
                    tmp.addFirst(node.val);
                }
                // 因为是"之"字型，所以先判断左边
                // 当前节点的左边有数据的时候，将其添加到队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 当前节点的右树有数据的时候，将其添加到队列中
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 循环完成将列表添加到结果集合中
            res.add(tmp);
            // 深度++
            depth++;
        }
        // 返回结果
        return res;
    }

    /**
     * 解法二：递归
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, TreeNode root, int depth) {
        // 判断跟节点是否有数据
        if (root == null) {
            return;
        }
        // 判断结果的res列表的长度是否与深度相等
        if (res.size() == depth) {
            // 相等的时候创建空集合
            res.add(new LinkedList<>());
        }
        // 深度是2的倍数的时候将值添加到对应的深度的列表中
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        }
        // 深度不是2的倍数的时候将值添加到对应的深度的列表的头部
        else {
            res.get(depth).add(0, root.val);
        }
        // 先遍历左节点，深度+1
        helper(res, root.left, depth + 1);
        // 在遍历右边节点，深度+1
        helper(res, root.right, depth + 1);
    }
}
