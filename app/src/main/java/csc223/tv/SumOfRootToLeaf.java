package csc223.tv;
/**
 * 1022. Sum of Root to Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/?envType=problem-list-v2&envId=tree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // base case for null graph
        if (root == null){
            return 0;
        }

        return sum(root, 0);
    }

    public int sum(TreeNode curr, int value){
        // Base case 1
        if (curr == null){
            return 0;
        }

        value = (value * 2) + curr.val;

        // base case 2
        if (curr.left == null && curr.right == null){
            return value;
        }

        // recursive call 
        return sum(curr.left, value) + sum(curr.right, value);
    }

    
}