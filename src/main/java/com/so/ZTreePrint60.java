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
        // 使用队列进行存储
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;

    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new LinkedList<>());
        }
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        } else {
            res.get(depth).add(0, root.val);
        }
        helper(res, root.left, depth + 1);
        helper(res, root.right, depth + 1);
    }
}
