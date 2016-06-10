package learn.ds.stack;

import java.util.Stack;

public class fish {

    private Stack<Integer> stack = null;
    
    public fish() {
        int[] A = new int[5];
        int[] B = new int[5];
        A[0] = 4;    B[0] = 1;
        A[1] = 3;    B[1] = 0;
        A[2] = 2 ;   B[2] = 0;
        A[3] = 10  ;  B[3] = 1;
        A[4] = 5   ; B[4] = 0;
        
        System.out.println(solution(A,B));
    }

    public int solution(int[] A, int[] B) {
        int result = 0;
        if (A.length == 0 || B.length == 0)
            result = 0;

        stack = new Stack<Integer>();
        checkAndPush(A, B);
        System.out.println("input = " + A.length + " and result = " + stack.size());
        return stack.size();
    }

    private void checkAndPush(int[] A, int[] B) {

        for (int i = 0; i < B.length; i++) {

            stack.push(i);
            while (stack.size() > 1) {
                int pop = stack.pop();
                int peek = stack.peek();

                if (B[pop] == 0 && B[peek] == 1) {
                    if (A[pop] > A[peek]) {
                        stack.pop();
                        stack.push(pop);
                    }
                } else {
                    stack.push(pop);
                    break;
                }
            }
        }

    }

}
