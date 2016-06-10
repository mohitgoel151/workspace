package learn.ds.misc.huffman;

public class HuffmanPQueue {

    public HuffmanNode[] huffmanQueue;
    private  int ArraySize = 100;

    public HuffmanPQueue()
    {
        huffmanQueue = new HuffmanNode[ArraySize];
        huffmanQueue[0] = new HuffmanNode('\0', 0, null, null);
    }

    public boolean HasOneNode()
    {
        if (huffmanQueue[0].frequency == 1)
            return true;
        else
            return false;
    }

    public void Add(HuffmanNode addNode)
    {
        if (huffmanQueue[0].Value == ArraySize - 1)
        {
            //Console.WriteLine("Array is full");
            return;
        }

        // Array not full
        huffmanQueue[0].frequency += 1;

        huffmanQueue[(int)huffmanQueue[0].frequency] = addNode;

        //bubble Up
        int NodeCount = (int)huffmanQueue[0].frequency;

        //if (NodeCount % 2 == 0)
        //{
        //    if (huffmanQueue[NodeCount - 1].frequency > huffmanQueue[NodeCount].frequency)
        //    {
        //        HuffmanNode Temp = huffmanQueue[NodeCount - 1];
        //        huffmanQueue[NodeCount - 1] = huffmanQueue[NodeCount];
        //        huffmanQueue[NodeCount] = Temp;
        //    }
        //}

        for (int i = NodeCount / 2; i > 0; i--)
        {
            // Will do when nount count is even
            if (huffmanQueue[i].frequency > huffmanQueue[(i * 2)].frequency)
            {
                HuffmanNode Temp = huffmanQueue[i];
                huffmanQueue[i] = huffmanQueue[(i * 2)];
                huffmanQueue[(i * 2)] = Temp;
            }

            if(NodeCount >= (2*i + 1))
            {
                if (huffmanQueue[i].frequency > huffmanQueue[(2*i + 1)].frequency)
                {
                    HuffmanNode Temp = huffmanQueue[i];
                    huffmanQueue[i] = huffmanQueue[(2*i + 1)];
                    huffmanQueue[(2*i + 1)] = Temp;
                }

                if (huffmanQueue[2*i].frequency > huffmanQueue[2*i+1].frequency)
                {
                    HuffmanNode Temp = huffmanQueue[2*i];
                    huffmanQueue[2*i] = huffmanQueue[2*i+1];
                    huffmanQueue[2 * i + 1] = Temp;
                }
            }
        }

    }

    public HuffmanNode RemoveMin()
    {
        if (huffmanQueue[0].frequency == 0)
        {
            
            return null;
        }

        HuffmanNode temp = huffmanQueue[1];
        huffmanQueue[1] = huffmanQueue[(int)huffmanQueue[0].frequency];
        huffmanQueue[(int)huffmanQueue[0].frequency] = null;
        huffmanQueue[0].frequency -= 1;

        // Restore up
        int NodeCount = (int)huffmanQueue[0].frequency;



        for (int i = 1; i <= NodeCount/2; i++)
        {
            if (huffmanQueue[i].frequency > huffmanQueue[(i * 2)].frequency)
            {
                HuffmanNode Temp = huffmanQueue[i];
                huffmanQueue[i] = huffmanQueue[(i * 2)];
                huffmanQueue[(i * 2)] = Temp;
            }

            if (NodeCount >= (2 * i + 1))
            {
                if (huffmanQueue[i].frequency > huffmanQueue[(2 * i + 1)].frequency)
                {
                    HuffmanNode Temp = huffmanQueue[i];
                    huffmanQueue[i] = huffmanQueue[(2 * i + 1)];
                    huffmanQueue[(2 * i + 1)] = Temp;
                }
            }
        }


        return temp;
    }
    
}
