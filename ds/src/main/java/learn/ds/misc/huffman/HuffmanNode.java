package learn.ds.misc.huffman;

public class HuffmanNode {
    
    public char Value;
    public float frequency;
    public HuffmanNode LeftNode;
    public HuffmanNode RightNode;


    public HuffmanNode()
    {
        Value = '\0';
        frequency = 0;
        LeftNode = null;
        RightNode = null;
    }

    public HuffmanNode(char val, float fFreq, HuffmanNode left, HuffmanNode right)
    {
        Value = val;
        frequency = fFreq;
        LeftNode = left;
        RightNode = right;
    }
    
}
