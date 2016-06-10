package learn.ds.tree;

public class DiameterOfATree {

    public int CalcDiameter(TreeNode node) {
        Integer Dia = 0;
        return FindDia(node, Dia);
    }

    private int FindDia(TreeNode aNode, Integer iHeight) {
        if (aNode == null)
            return 0;

        Integer lh = 0, rh = 0, ld = 0, rd = 0;

        ld = FindDia(aNode.getLeft(), lh);
        rd = FindDia(aNode.getRight(), rh);

        iHeight = 1 + Math.max(lh, rh);

        return Math.max(lh + rh + 1, Math.max(ld, rd));

    }
}
