package learn.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class MaxProductCutting {
    
    int maxProduct = 0;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public MaxProductCutting() {
       
        for (int n = 2; n < 50; n++) {
            int prodViaDP = viaDP(n);
            int prodViaRe = viaRecursion(n);
            
            if (prodViaDP != maxProduct) {
                System.out.println("not equal");
            }
        }

    }

    private int viaRecursion(int n) {
        
        if(n <= 1 ) {
            return 1;
        }
        
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int prod = 1;
        
        for (int i = 1; i <= (int)(n/2); i++) {
            prod = Math.max(i * viaRecursion(n - i), i * (n-i));
            if(prod > maxProduct) {
                maxProduct = prod;
            }
        }
        map.put(n, maxProduct);
        return prod;
    }

    private int viaDP(int n) {
        int[] val = new int[n+1];
        val[0] = val[1] = val[2] = 1;
       
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i <= n; i++)
        {
           for (int j = 1; j <= i/2; j++)
              val[i] = Math.max(val[i], Math.max((i-j)*j, j*val[i-j]));

        }
        return val[n];
        
    }

}
