package learn.ds.tree;

public class ClosestAnsestor {

    boolean v1, v2;

    public TreeNode findLCAUtil(TreeNode root, TreeNode n1, TreeNode n2) {
        // Base case
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (root.getValue() == n1.getValue()) {
            v1 = true;
            return root;
        }
        if (root.getValue() == n2.getValue()) {
            v2 = true;
            return root;
        }

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCAUtil(root.getLeft(), n1, n2);
        TreeNode right_lca = findLCAUtil(root.getRight(), n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && (right_lca != null))
            return root;
        else if (left_lca != null) {
            return left_lca;
        } else {
            return right_lca;
        }

    }

}
