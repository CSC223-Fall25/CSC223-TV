package csc223.tv;


public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    //Insert a node in the tree
    public void insert(int value){
        if (this.root == null){
            this.root = new BSTNode(value);
        } else {
            insert(this.root, value);
        }
    }

    private void insert(BSTNode curr, int value){
        if (value < curr.data) {
            if (curr.left == null) {
                curr.left = new BSTNode(value);
            } else {
                insert(curr.left, value);
            }
        } else if (value > curr.data){ 
            if (curr.right == null) {
                curr.right = new BSTNode(value);
            } else {
                insert(curr.right, value);
            }

        }
    }

    //Delete fucntion
    public void delete(int value){
        root = delete(root, value);
    }

    private BSTNode delete(BSTNode curr, int value){
        if (curr == null){
            return null;
        }
        if (value < curr.data) {
            curr.left = delete(curr.left, value);
        } else if (value > curr.data) {
            curr.right = delete(curr.right, value);
        } else {
            //Case 1: Node with only one child
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            }

            //Case 2: node with two children
            curr.data = getMin(curr.right);

            //replace the value of the node
            curr.right = delete(curr.right, curr.data);

        }
        return curr;
    }

    private int getMin(BSTNode curr){

        if (curr.left == null){
            return curr.data;
        } 
        return getMin(curr.left);
        
    }

    //Searching Function
    public boolean search(int value){
        return search(this.root, value);
    }

    private boolean search(BSTNode curr, int value){
        if (curr == null) {
            return false;
        }

        if (curr.data == value){
            return true;
        }
        
        if (curr.data < value) {
            return search(curr.right, value);
        } else {
            return search(curr.left, value);
        }
        
    }

    //Update using delete and insert
    public void update(int oldValue, int newValue){
        if (search(oldValue)){
            delete(oldValue);
            insert(newValue);
        }
    }


    // Return a string using inOrder Traversal
    public String inOrder() {
        StringBuilder str = new StringBuilder();
        inorderHelp(root, str);
        return str.toString();
    }

    private void inorderHelp(BSTNode curr, StringBuilder str){
        if (curr == null) {
            return;
        }

        inorderHelp(curr.left, str);
        str.append(curr.data);
        inorderHelp(curr.right, str);
    }



    //Return the root node of the tree from the array input
    public BSTNode sortedArrayToBST(int[] values) {
        return sortedArraytoBST(values, 0, values.length -1);

    }

    private BSTNode sortedArraytoBST(int[] values, int left, int right){
        if (left > right) {
            return null;
        }

        //find the middle index
        int mid = left + (right -left) / 2;

        // Create a new node with the middle element
        BSTNode node = new BSTNode(values[mid]);

        //rescursively build the left and right subtrees
        node.left = sortedArraytoBST(values, left, mid -1);
        node.right = sortedArraytoBST(values, mid + 1, right);

        return node; 
    }

    //Returns the lowest common ancestor of two elements in the BST
    public int lowestCommonAncestor(int p, int q){
        //Check if p and q exist in the tree
        if (!search(q) || !search(p)){
            return -1;
        }

        BSTNode lcaNode = lowestCommonAncestor(this.root, p, q);

        if (lcaNode != null) {
            return lcaNode.data;
        } else {
            return -1;
        }

    }

    private BSTNode lowestCommonAncestor(BSTNode curr, int p, int q){
        if (curr == null) {
            return null;
        }
        //If both p and q less than curr.data, LCANode is in the left sub tree
        if (p < curr.data && q < curr.data){
            return lowestCommonAncestor(curr.left, p, q);
        // if both are greater than curr.data, LCANode is in the right sub tree
        } else if (p > curr.data && q > curr.data) {
            return lowestCommonAncestor(curr.right, p, q);
        } else {
            return curr;
        }


    }

}

