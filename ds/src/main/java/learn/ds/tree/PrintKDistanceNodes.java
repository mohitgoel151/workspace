package learn.ds.tree;

public class PrintKDistanceNodes {

    public void PrintNodes(TreeNode Root, int requiredNode, int iDistance) {
        PrintNodesAtKDistance(Root, requiredNode, iDistance);
    }

    public int PrintNodesAtKDistance(TreeNode root, int requiredNode, int iDistance) {
        if ((root == null) || (iDistance < 0))
            return -1;

        int lPath = -1, rPath = -1;

        if (root.getValue() == requiredNode) {
            PrintChildNodes(root, iDistance);
            return iDistance - 1;
        }

        lPath = PrintNodesAtKDistance(root.getLeft(), requiredNode, iDistance);
        rPath = PrintNodesAtKDistance(root.getRight(), requiredNode, iDistance);

        if (lPath > 0) {
            PrintChildNodes(root.getRight(), lPath - 1);
            return lPath - 1;
        } else if (lPath == 0) {
            System.out.println(root.getValue());
        }

        if (rPath > 0) {
            PrintChildNodes(root.getLeft(), rPath - 1);
            return rPath - 1;
        } else if (rPath == 0) {
            System.out.println(root.getValue());
        }

        return -1;
    }

    public void PrintChildNodes(TreeNode aNode, int iDistance) {
        if (aNode == null)
            return;

        if (iDistance == 0) {
            System.out.println(aNode.getValue());
        }

        PrintChildNodes(aNode.getLeft(), iDistance - 1);
        PrintChildNodes(aNode.getRight(), iDistance - 1);
    }

}
