package learn.ds.trie;

import org.apache.commons.lang3.StringUtils;

public class Trie {

    public TrieNode rootNode;
    String[] allStrings;
    int findCount = 0;

    public Trie() {
        rootNode = new TrieNode();
        addStringInTrie("any");
        addStringInTrie("anyother");
        addStringInTrie("anything");
        addStringInTrie("ab");
        addStringInTrie("abc");
        addStringInTrie("acb");
        addStringInTrie("anyone");
        addStringInTrie("there");
        addStringInTrie("their");
        addStringInTrie("answer");
        addStringInTrie("bye");

        Boolean IsPresent = findString("abc");
        IsPresent = findString("answer");
        IsPresent = findString("abc");
        IsPresent = findString("there");
        IsPresent = findString("abc");

        findAllStringSuggestionsWith("an");
    }

    private void findAllStringSuggestionsWith(String p) {
        allStrings = new String[10];
        int index = 0;
        TrieNode aNode = rootNode;

        while (index < p.length()) {
            if (aNode.charArray[p.charAt(index) - 97] != null) {
                aNode = aNode.charArray[p.charAt(index) - 97];
            } else {
                aNode = null;
                break;
            }
            index++;
        }

        if (aNode == null) {
            return;
        }

        findSuggestion(p, aNode);

    }

    private void findSuggestion(String p, TrieNode aNode) {
        if (aNode.IsEndWord == true) {
            allStrings[findCount] = p;
            findCount++;
        }

        for (int i = 0; i < aNode.charArray.length; i++) {
            if (aNode.charArray[i] != null) {
                findSuggestion(p + (char) (i + 97), aNode.charArray[i]);
            }
        }

    }

    private boolean findString(String strFind) {
        return findStringInTrie(strFind, rootNode, 0);
    }

    private boolean findStringInTrie(String strFind, TrieNode rootNode,
            int index) {
        if (rootNode.charArray[strFind.charAt(index) - 97] == null) {
            return false;
        }

        if (index < strFind.length() - 1) {
            return findStringInTrie(strFind, rootNode.charArray[strFind.charAt(index) - 97], ++index);
        } else {
            if (rootNode.IsEndWord == true)
                return true;
            else
                return false;

        }
    }

    private void addStringInTrie(String aString) {
        if (StringUtils.isNotBlank(aString)) {
            return;
        }

        addChar(aString, rootNode, 0);
    }

    private void addChar(String strString, TrieNode aNode, int index) {

        if (aNode.charArray[strString.charAt(index) - 97] == null) {
            TrieNode newNode = new TrieNode();
            newNode.Value = strString.charAt(index);
            aNode.charArray[strString.charAt(index) - 97] = newNode;

            if (index == strString.length() - 1) {
                newNode.IsEndWord = true;
            }
        }

        if (index < strString.length() - 1) {
            addChar(strString, aNode.charArray[strString.charAt(index) - 97], ++index);
        }

    }

}
