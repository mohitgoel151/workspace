package learn.ds.tree;

import java.util.Stack;

public class PrintZigZag {
    public PrintZigZag(TreeNode RootNode)
    {
        if (RootNode == null)
            return;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        boolean useS1 = true;
        s1.push(RootNode);

        while (s1.size() > 0 || s2.size() > 0)
        {
            if (true == useS1)
            {
                while (s1.size() > 0)
                {
                    TreeNode aNode = s1.pop();
                    System.out.println(aNode.getValue());

                    if (null != aNode.getLeft())
                        s2.push(aNode.getLeft()); 

                    if (null != aNode.getRight())
                        s2.push(aNode.getRight());

                }
                useS1 = false;
            }
            else
            {
                while (s2.size() > 0)
                {
                    TreeNode aNode = s2.pop();
                    System.out.println(aNode.getValue());

                    if (null != aNode.getRight())
                        s1.push(aNode.getRight());

                    if (null != aNode.getLeft())
                        s1.push(aNode.getLeft());

                }
                useS1 = true;
            }
        }
    }
}
