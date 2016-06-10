package learn.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTreeDiagonally {

    public void execute() {
        TreeNode root = TreeFactory.getDefaultTree();
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        
        print(root, map, 0);
        
        for (Integer key : map.keySet()) {
            List<String> list = map.get(key);
            System.out.print(key + " : ");
            list.forEach(System.out::println);
            System.out.println();
        }
    }
    
    private void print(TreeNode node, Map<Integer, List<String>> map, int level){
        if(node == null) {
            return;
        }
        
        List<String> list = map.get(level);
        if(list == null) {
            list = new ArrayList<String>();
            map.put(level, list);
        }
        list.add(node.getId());
        
        print(node.getLeft(), map, level + 1);
        print(node.getRight(), map, level);
        
    }

}
