package ap_assignment03;

public class BinarySearchTree {
	private String data;
    private BinarySearchTree left;
    private BinarySearchTree right;
 
    public BinarySearchTree() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
     
    public BinarySearchTree(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
 
    public static BinarySearchTree createTree( String content ) {
        BinarySearchTree bstree = new BinarySearchTree();
        if( content != null ) {
            //
            // Remove the punctuation from the content
            //
            content = content.replaceAll("(\\w+)\\p{Punct}(\\s|$)", "$1$2");
            String[] words = content.split( " " );
            bstree = new BinarySearchTree();
            for( int i = 0; i < words.length; i++ ) {
                bstree.addNode( words[i]);
            }
        }
        return bstree;
    }
 
     
    // As a convention, if the key to be inserted is less than the key of root
    // node, then key is inserted in
    // left sub-tree; If key is greater, it is inserted in right sub-tree. If it
    // is equal, as a convention, it
    // is inserted in right sub-tree
    public void addNode(String data) {
        if (this.data == null) {
            this.data = data;
        } else {
            if (this.data.compareTo(data) < 0) {
                if (this.left != null) {
                    this.left.addNode(data);
                } else {
                    this.left = new BinarySearchTree(data);
                }
 
            } else {
                if (this.right != null) {
                    this.right.addNode(data);
                } else {
                    this.right = new BinarySearchTree(data);
                }
 
            }
        }
    }
     
    public void traversePreOrder() {
        System.out.println(this.data);
        if (this.left != null) {
            this.left.traversePreOrder();
        }
        if (this.right != null) {
            this.right.traversePreOrder();
        }
    }
 
    public void traverseInOrder() {
        if (this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.println(this.data);
        if (this.right != null) {
            this.right.traverseInOrder();
        }
    }
 
 
    public boolean SearchPostOrder(String d) {
        if (this.left!=null&&this.left.data != d) {
            this.left.SearchPostOrder(d);
        }
        else {
        	return true;
        }
        
        if (this.right!=null&&this.right.data != d) {
            this.right.SearchPostOrder(d);
        } else {
        	return true;
        }
        
        return false;
    }
}
