package learn.ds.tree;

import java.util.Stack;

/**
 * 
 * @author mohit
 *
 *         http://stackoverflow.com/questions/18907391/finding-if-a-number-is-
 *         equal-to-sum-of-2-nodes-in-a-binary-search-tree
 */
public class SumOfNodesK {
    
    public void execute() {
        TreeNode root = TreeFactory.getDefaultTree();
        System.out.println(sum(root, 19));
    }

    private int sum(TreeNode A, int B) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode cur1 = A;
        TreeNode cur2 = A;

        while (!stack1.isEmpty() || !stack2.isEmpty() || cur1 != null || cur2 != null) {
            if (cur1 != null || cur2 != null) {
                if (cur1 != null) {
                    stack1.push(cur1);
                    cur1 = cur1.getLeft();
                }

                if (cur2 != null) {
                    stack2.push(cur2);
                    cur2 = cur2.getRight();
                }
            } else {
                int val1 = Integer.valueOf(stack1.peek().getId());
                int val2 = Integer.valueOf(stack2.peek().getId());

                // need to break out of here
                if (stack1.peek() == stack2.peek())
                    break;

                if (val1 + val2 == B)
                    return 1;

                if (val1 + val2 < B) {
                    cur1 = stack1.pop();
                    cur1 = cur1.getRight();
                } else {
                    cur2 = stack2.pop();
                    cur2 = cur2.getLeft();
                }
            }
        }

        return 0;
    }

}
