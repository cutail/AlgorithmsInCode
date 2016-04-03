
import java.util.*;

/**
 * This algorithm is from geeksforgeeks. below is my java implementation
 * Algorithms to find the length of the maximum match parenthesis substring.

 * 1) Create an empty stack and push -1 to it. The first elemen
   *of stack is used to provide base for next valid string.

 * 2) Initialize result as 0.

 * 3) If the character is '(' i.e. str[i] == '('), push index 
 * 'i' to the stack. 

   
 * 4) Else (if the character is ')')
 *   a) Pop an item from stack (Most of the time an opening bracket)
 *   b) If stack is not empty, then find length of current valid
 *     substring by taking difference between current index and
 *    top of the stack. If current length is more than result,
 *    then update the result.
 *   c) If stack is empty, push current index as base for next
 *    valid substring.

 * 5) Return result.
 *
 */
public class MaxMatchSubString {

    public static void main(String[] args) {
	calc("()(()))))");
    }
    
    public static void calc(String str) {
	char[] chs = str.toCharArray();
	ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	stack.push(-1);
	int result = 0;
	
	for (int i = 0; i < chs.length; i++) {
	    if (chs[i] == '(') {
		stack.push(i);
	    } else {
		int tmp = stack.pop();
		if (!stack.isEmpty()) {
		    int tmpmax = i - stack.peek();
		    if (tmpmax > result) result = tmpmax;
		} else {
		    stack.push(i);
		}
	    }
	}

	System.out.println("max parenthesis match substring length: " + result);
    }
}
