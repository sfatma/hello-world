package dec82012;

import java.util.Stack;

public class Solution {

	public static void main(String[] ar){
		String[] values={"{}[]({)", "{{]}", "{(a,b)}", };
		String[] res = Braces(values);
		for (int i=0; i<res.length; i++){
			System.out.println(res[i]);
		}
	}

	static String[] Braces(String[] values) {
		String[] res= new String[values.length];
		for(int i=0; i<values.length; i++){
			boolean balanced = checkParantheses(values[i]);
			if(balanced){
				res[i] = "YES";
			}else{
				res[i] = "NO";
			}
		}
		
		return res;
	}

	private static boolean checkParantheses(String string) {
		Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);

            }else if(c == ']') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '[') return false;

            }else if(c == ')') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '(') return false;

            }else if(c == '}') {
                if(stack.isEmpty()) return false;
                if(stack.pop() != '{') return false;
            }

        }
        return stack.isEmpty();
	}
}
