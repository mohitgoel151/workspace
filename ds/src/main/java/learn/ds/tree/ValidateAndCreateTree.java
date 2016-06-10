package learn.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.StringUtils;

public class ValidateAndCreateTree {
    
    public ValidateAndCreateTree() {
        
    }
    
    //{z-null-1}  ==> current- parent - value 
    public void execute() {
        
        String input = "{z-null-1}{a-z-a}{b-z-b}{c-b-a}{d-c-b}{e-a-d}{f-a-d}{g-d-a}{h-d-f}{i-f-f}{j-g-e}{k-j-e}{l-j-e}{m-k-e}{n-e-e‬‬}";
        if(StringUtils.isBlank(input)) {
            return;
        }
        String truncateString = input.substring(1, input.length() - 1);
        
        String[] nodes = truncateString.split("\\}\\{");
        if(nodes == null || nodes.length == 0) {
            return;
        }
        
        SplTreeNode root = createTree(nodes);
        
        if(root == null) {
            System.out.println("Bad tree");
            System.exit(0);
        }
        
        System.out.println("Preorder Traversal if tree");
        printTree(root);
        int height = getHeight(root, 0, 0);
        System.out.println("");
        System.out.println("height of Tree = " + height);
    }
    
    private Integer getHeight(SplTreeNode root, int height, Integer max) {
        
        if(root != null) {
            if(max <= height) 
                max++;
            max = getHeight(root.getLeftChild(), height + 1, max);
            max = getHeight(root.getRightChild(), height + 1, max);
        } 
        
        return max;
    }

    private SplTreeNode createTree(String[] nodes) {
        SplTreeNode root = null;
        Map<String, List<SplTreeNode>> map = new HashMap<String, List<SplTreeNode>>();
        for (String node : nodes) {
            String[] details = node.split("-");
            SplTreeNode treeNode = new SplTreeNode(details[0], details[1], details[2]);
            
            if(details[1].equals("null")) {
                root = treeNode;
            }
            
            if(map.containsKey(details[1])) {
                map.get(details[1]).add(treeNode);
            } else {
                List<SplTreeNode> nodeList = new ArrayList<SplTreeNode>();
                nodeList.add(treeNode);
                map.put(details[1], nodeList);
            }
        }
        
        createTreeFromMap(root, map);
        
        if(map.size() > 1) {
            System.out.println("Bad Tree");
            System.exit(0);
        }
        
        return root;
    }
    
    private void createTreeFromMap(SplTreeNode node, Map<String, List<SplTreeNode>> map) {
        
        if(node == null) {
            return;
        }
        
        List<SplTreeNode> list = map.get(node.getName());
        if(list != null) {
            for (SplTreeNode splTreeNode : list) {
                node.addChild(splTreeNode);
                createTreeFromMap(splTreeNode, map);
                
            }
        }
        map.remove(node.getName());
        
        
    }
    
    private void printTree(SplTreeNode node) {
        if(node == null) {
            return;
        }
        
        printTree(node.getLeftChild());
        System.out.print(node.getName() + " ");
        printTree(node.getRightChild());
    }

}

class SplTreeNode {
    
    private String name;
    private String value;
    private String parentName;
    
    private SplTreeNode leftChild;
    private SplTreeNode rightChild;
    
    public SplTreeNode(String name, String parent, String value) {
        this.name = name;
        this.parentName = parent;
        this.value = value;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
    public SplTreeNode getLeftChild() {
        return leftChild;
    }
    private void setLeftChild(SplTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public SplTreeNode getRightChild() {
        return rightChild;
    }
    private void setRightChild(SplTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public void addChild(SplTreeNode child) {
        if(leftChild == null) {
            leftChild = child;
        } else if (rightChild == null) {
            rightChild = child;
        } else {
            System.out.println("Failed to add child node = " + child.name);
            System.out.println("As all child nodes already assigned to node name = " + this.name);
            throw new RuntimeErrorException(null, "failed to add child node");
        }
    }
    
    
}
