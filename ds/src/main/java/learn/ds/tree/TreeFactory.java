package learn.ds.tree;

public class TreeFactory {

    public static TreeNode getDefaultTree() {
        //       http://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
        TreeNode root = new TreeNode("8");
        TreeNode node1 = new TreeNode("3");
        TreeNode node2 = new TreeNode("1");  
        
        TreeNode node3 = new TreeNode("6");
        TreeNode node4 = new TreeNode("4"); 
        TreeNode node5 = new TreeNode("7");
        TreeNode node6 = new TreeNode("10"); 
        TreeNode node7 = new TreeNode("14");
        TreeNode node8 = new TreeNode("13"); 
        
        node3.setLeft(node4);
        node3.setRight(node5);
        
        node1.setLeft(node2);
        node1.setRight(node3);
        
        node7.setLeft(node8);
        node6.setRight(node7);
        
        root.setLeft(node1);
        root.setRight(node6);
        
        return root;
        
    }
    
}
