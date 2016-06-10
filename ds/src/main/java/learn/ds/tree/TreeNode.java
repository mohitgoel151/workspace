package learn.ds.tree;

public class TreeNode {
    
    private String id;
    private TreeNode left;
    private TreeNode right;
    
    private int value;
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    public TreeNode() {
        // TODO Auto-generated constructor stub
    }
    
    public TreeNode(String id){
        this.id = id;
    }

}
