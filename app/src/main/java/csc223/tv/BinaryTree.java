package csc223.tv;




public class BinaryTree implements Tree {
    
    int size;
    int height;
    TreeNode root;

    //constructor
    public BinaryTree() {
        this.size = 0;
        this.height = 0;
        this.root = null;
    }

     /** Get the level order traversal of the tree
    *
    * For example, the level order traversal of the following tree:
    *
    *    A
    *   / \
    *  B   C
    *
    * is "ABC"
    */
   public String levelorder() {
        if (this.root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        LLQueue queue = new LLQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.dequeue();
            result.append(curr.data);   

            if (curr.left != null){
                queue.enqueue(curr.left);

            }
            if (curr.right != null) {
                queue.enqueue(curr.right);
            }
        }

        return result.toString();
   }


   /** Get the preorder traversal of the tree: root -> left -> right
    *
    * For example, the preorder traversal of the following tree:
    *
    *     A
    *    / \
    *  B   C
    * / \
    * D E
    *
    * is "ABDEC"
    */
   public String preorder() {
        StringBuilder result = new StringBuilder();

        preorder(root, result);
        return result.toString();
   }

   private void preorder(TreeNode node, StringBuilder result){
        if (node == null) {
            return;
        }
        result.append(node.data);
        preorder(node.left, result);
        preorder(node.right, result);
   }



   /** Get the inorder traversal of the tree: left -> root -> right
    *
    * For example, the inorder traversal of the following tree:
    *
    *        A
    *       / \
    *      B   C
    *     / \
    *    D   E
    *
    * is "DBEAC"
    */
   public String inorder() {
        StringBuilder str = new StringBuilder();
        inorderHelp(root, str);
        return str.toString();
   }

   private void inorderHelp(TreeNode node, StringBuilder str){
        if (node == null){
            return;
        }

        inorderHelp(node.left, str);
        str.append(node.data);
        inorderHelp(node.right, str);
   }


   /**
    * Get the postorder traversal of the tree:
    *  left -> right -> root
    *
    * For example, the postorder traversal of the following tree:
    *
    *      A
    *     / \
    *   B   C
    *  / \
    *  D E
    *
    * is "DEBCA"
    */
   public String postorder(){
        StringBuilder str = new StringBuilder();
        postorderHelp(root, str);
        return str.toString();

   }

   private void postorderHelp(TreeNode node, StringBuilder str){
        if (node == null){
            return;
        }

        postorderHelp(node.left, str);
        postorderHelp(node.right, str);
        str.append(node.data);
   }


   /**
    * Insert an item into the tree,
    * using level order traversal to find the correct position
    * If the tree is empty, insert the item at the root node.
    */


    public void insert(char item) {
        TreeNode newnode = new TreeNode(item);

        if (this.root == null) {
            this.root = newnode;
            this.height = 1;
        } else {
            LLQueue queue = new LLQueue();
            queue.enqueue(this.root);
            while ( !queue.isEmpty()) {
                TreeNode curr = queue.dequeue();

                if (curr.left == null) {
                    curr.left = newnode;
                    break;
                } else {
                    queue.enqueue(curr.left);
                }

                if (curr.right == null) {
                    curr.right = newnode;
                    break;
                } else {
                    queue.enqueue(curr.right);
                }
                
            }
            this.height = calculateheight(this.root);
        }
        this.size += 1;

    } 

    private int calculateheight(TreeNode node){
        if (node == null){
            return 0;   
        }

        int leftHeight = calculateheight(node.left);
        int rightHeight = calculateheight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    
    // Check if the tree contains an item
    public boolean search(char item) {
        if (this.root == null) {
            return false;
        }
        LLQueue queue = new LLQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.top();
            queue.dequeue();
            if (curr.data == item) {
                return true;
            }

            if (curr.left != null){
                queue.enqueue(curr.left);
            }
            if (curr.right != null){
                queue.enqueue(curr.right);
            }
        }

        return false;
    }

    
    
    // Get the number of nodes in the tree
    public int size() {
        return this.size;
    }
    
    
    // Check if the tree is empty
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    
    // Get the height of the tree (number of nodes along the longest path from the root node down to the farthest leaf node)
    public int height() {
        return this.height;
    }

}
