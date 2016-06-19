package learn.ds.math;

/**
 * 
 * when the input size is odd, we take the middle element of sorted data. If the input size is even, 
 * we pick average of middle two elements in sorted stream.
 *
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 */

public class MedianOfStreamOfNumbers {
	
	//Method 1
	//Use insertion sort
	
	//Method 2
	//Make balances binary search tree where we keep track of no of nodes in left and right subtree instead of height.
	//Rotations need to be done of insertion of every new elements
	
	
	//Method 3
	//Use max and min heap.
	//we can use a max heap on left side to represent elements that are less than effective median, 
	//and a min heap on right side to represent elements that are greater than effective median.
	/*
	 * After processing an incoming element, the number of elements in heaps differ utmost by 1 element. 
	 * When both heaps contain same number of elements, we pick average of heaps root data as effective median. 
	 * When the heaps are not balanced, we select effective median from the root of heap containing more elements.
	 */
	
	// Function implementing algorithm to find median so far.
//	int getMedian(int e, int &m, Heap &l, Heap &r)
//	{
//	    // Are heaps balanced? If yes, sig will be 0
//	    int sig = Signum(l.GetCount(), r.GetCount());
//	    switch(sig)
//	    {
//	    case 1: // There are more elements in left (max) heap
//	 
//	        if( e < m ) // current element fits in left (max) heap
//	        {
//	            // Remore top element from left heap and
//	            // insert into right heap
//	            r.Insert(l.ExtractTop());
//	 
//	            // current element fits in left (max) heap
//	            l.Insert(e);
//	        }
//	        else
//	        {
//	            // current element fits in right (min) heap
//	            r.Insert(e);
//	        }
//	 
//	        // Both heaps are balanced
//	        m = Average(l.GetTop(), r.GetTop());
//	 
//	        break;
//	 
//	    case 0: // The left and right heaps contain same number of elements
//	 
//	        if( e < m ) // current element fits in left (max) heap
//	        {
//	            l.Insert(e);
//	            m = l.GetTop();
//	        }
//	        else
//	        {
//	            // current element fits in right (min) heap
//	            r.Insert(e);
//	            m = r.GetTop();
//	        }
//	 
//	        break;
//	 
//	    case -1: // There are more elements in right (min) heap
//	 
//	        if( e < m ) // current element fits in left (max) heap
//	        {
//	            l.Insert(e);
//	        }
//	        else
//	        {
//	            // Remove top element from right heap and
//	            // insert into left heap
//	            l.Insert(r.ExtractTop());
//	 
//	            // current element fits in right (min) heap
//	            r.Insert(e);
//	        }
//	 
//	        // Both heaps are balanced
//	        m = Average(l.GetTop(), r.GetTop());
//	 
//	        break;
//	    }
//	 
//	    // No need to return, m already updated
//	    return m;
//	}

}
