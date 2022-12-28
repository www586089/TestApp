package com.zfang.testapp.node;

import androidx.annotation.NonNull;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;
    public int deep;

    TreeNode() {

    }
    public TreeNode(int value) {
        this.value = value;
    }
    TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
//                "left=" + left +
//                ", right=" + right +
                ", value=" + value +
//                ", deep=" + deep +
                '}';
    }
}
