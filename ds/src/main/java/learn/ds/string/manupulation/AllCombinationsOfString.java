package learn.ds.string.manupulation;

import java.util.HashSet;
import java.util.Set;

public class AllCombinationsOfString {
    
    public void execute() {
        Set<String> combi = printcombinations("abc");
        for (String string : combi) {
            System.out.println(string);
        }
    }
    
    
    private Set<String> printcombinations(String str) {
        Set<String> result = new HashSet<String>();
        
        if(str == null || str.length() == 0) {
            return result;
        }
        
        if(str.length() == 1) {
            result.add(str);
            return result;
        }
        
        char first = str.charAt(0);
        String subString = str.substring(1);
        
        Set<String> combinations = printcombinations(subString);
        
        for (String string : combinations) {
            for (int i = 0; i <= string.length(); i++) {
                String a = string.substring(0, i) + first + string.substring(i);
                result.add(a);
            }
        }

        //Uncomment below lines if want to print for all length
        //example: a,b,c,ab,ac,bc,ba,ca,cb,abc,acb,........
        //result.add(String.valueOf(first));
        //result.addAll(combinations);
        
        return result;
    }
    
     

}
