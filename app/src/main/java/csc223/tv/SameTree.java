package csc223.tv;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public boolean isSameTree(TreeNode p, TreeNode q) {

        int[] Tree1 =new  int[9000];
        Tree1 = treeAppend(p,Tree1,0);
        int[] Tree2 =new  int[9000];
        Tree2 = treeAppend(q,Tree2,0);
        if ((p == null | q == null) && (p != q)){
            return false;
        }
        return sameTree(Tree1,Tree2);
    }

    int[] treeAppend(TreeNode p,  int[] Tree, int idx){
        if (idx >= 9000){
            return Tree;
        }
        if (p == null){
            Tree[idx] = -2;
            return Tree;
        }
        else{
            Tree[idx] = p.val;
            if (Tree[idx] == -1 && (p.left == null && p.right == null)){
                return Tree;
            }
            Tree = treeAppend(p.left,Tree,2*idx+1);
            Tree = treeAppend(p.right,Tree,2*idx+2);
        }
        return Tree;
    }

    boolean sameTree(int[] Tree1Array, int[] Tree2Array){
        for (int i = 0; i<8999; i++){
            System.out.println(Tree1Array[i]);
            if (Tree1Array[i] != Tree2Array[i]){
                return false;
            }
        }
        return true;
    }
};