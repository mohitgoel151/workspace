package learn.ds.dp;

import org.apache.commons.lang3.StringUtils;

public class LongestPalindromicSubstring {
    
    public LongestPalindromicSubstring() {
        // TODO Auto-generated constructor stub
    }
    
    public void execute() {
        String str = "forgeekaskeegfor";
        String result = getString(str);
    }
    
    private String getString(String str) {
        String result = StringUtils.EMPTY;
        if(StringUtils.isBlank(str)) {
            System.out.println("Invalid string");
            return result;
        }
        
        
        int strLength = str.length();
        int[][] array = new int[strLength + 1][strLength + 1];
        
        for (int i = 0; i < array.length; i++) {
            
            array[i][0] = 0;
        }
        
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = 0;
        }
        int max = 0;
        
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                if(str.charAt(i-1) == str.charAt(strLength - j)) {
                    array[i][j] = array[i-1][j-1] + 1;//Math.min(array[i-1][j], array[i][j-1]) + 1;
                    if(array[i][j] > max) {
                        max = array[i][j];
                    }
                } else {
                    //array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
                }
            }
        }
        
        int lastCell = array[array.length-1][array[0].length - 1];
        System.out.println("String size = " + max);
        
        
        return result;
        
    }
    

}
