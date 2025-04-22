package csc223.tv;
/**
 * 1028. Recover from preorder traversal
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/?envType=problem-list-v2&envId=tree
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

 
    public TreeNode recoverFromPreorder(String traversal) {

        Stack<TreeNode> stack = new Stack<>();

        int i = 0;

 

        // for each node

        while (i < traversal.length()) {

            int depth = 0;

 

            // get depth

            while (i < traversal.length() && traversal.charAt(i) == '-') {

                depth++;

                i++;

            }

 

           

            int value = 0;

            // while the current char is a digit

            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {

                // get digit at current character by manipulating ascii values

                int digitValue = traversal.charAt(i) - '0';

 

                // update value if longer than one char

                value = value * 10 + digitValue;

                i++;

            }

 

            // make treenode for the value

            TreeNode node = new TreeNode(value);

 

            // pop nodes from the stack until we reach the correct depth

            while (stack.size() > depth) {

                stack.pop();

            }

 

            // if the stack is not empty, link current node to parent

            if (!(stack.isEmpty())) {

                TreeNode parent = stack.peek();

                if (parent.left == null) {

                    parent.left = node; 

                } else {

                    parent.right = node; 

                }

            }

 

            // push current node to stack

            stack.push(node);

        }

 

        // return root

        return stack.get(0);

   

    }

       

}