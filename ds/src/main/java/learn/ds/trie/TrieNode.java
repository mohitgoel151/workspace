package learn.ds.trie;

public class TrieNode
{

    public char Value;
    public boolean IsEndWord;
    public TrieNode[] charArray;

    public TrieNode()
    {
        IsEndWord = false;
        charArray = new TrieNode[26];
    }

    public TrieNode(char aChar)
    {
        this();
        Value = aChar;
    }

}
