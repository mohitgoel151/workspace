package learn.ds.misc;

public class CombinationOfParanthesis {
    
    public void execute() {
        print(3,3,"");
    }
    
    private void print(int leftRem, int rightRem, String str) {
        if(leftRem > 0) {
            print(leftRem -1, rightRem, str+'{');
        }
        if(leftRem < rightRem) {
            print(leftRem, rightRem - 1, str+'}');
        }
        if(leftRem == 0 && rightRem == 0) {
            System.out.println(str);
        }
    }

}
