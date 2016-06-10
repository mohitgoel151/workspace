package learn.ds.misc.huffman;

public class Huffman {

    public HuffmanPQueue aQueue = new HuffmanPQueue();
    int[] frequencyArray = new int[26];

    // Imp ref to checK http://huffman.ooz.ie/

    public Huffman() {
        aQueue.Add(new HuffmanNode('d', 5, null, null));
        aQueue.Add(new HuffmanNode('b', 10, null, null));
        aQueue.Add(new HuffmanNode('e', 20, null, null));
        aQueue.Add(new HuffmanNode('c', 50, null, null));
        aQueue.Add(new HuffmanNode('A', 70, null, null));
        aQueue.Add(new HuffmanNode('f', 300, null, null));

        PerformOperation();
    }

    public Huffman(String aStr) {

        aStr = aStr.toLowerCase();
        aStr.replaceAll(" ", "");

        for (int index = 0; index < aStr.length(); index++) {
            char aChar = aStr.charAt(index);
            frequencyArray[aChar - 97] = frequencyArray[aChar - 97] + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (0 != frequencyArray[i]) {
                aQueue.Add(new HuffmanNode((char) (i + 97), frequencyArray[i], null, null));
            }
        }

        PerformOperation();
    }

    private void PerformOperation() {
        while (aQueue.HasOneNode() == false) {
            HuffmanNode left = aQueue.RemoveMin();
            HuffmanNode right = aQueue.RemoveMin();

            if (right != null) {
                aQueue.Add(new HuffmanNode('\0', left.frequency + right.frequency, left, right));
            } else {
                aQueue.Add(new HuffmanNode('\0', left.frequency, left, right));
            }

        }
    }

}
