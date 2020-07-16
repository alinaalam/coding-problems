import java.util.Stack;

public class ParanthesesExpression {
	
	public static void main(String[] args) {
		assert isBalanced("{{[()]}}") == true;
		assert isBalanced("") == true;
		assert isBalanced("[") == false;
		assert isBalanced("}") == false;
	}
	
	private static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		
		for (char c : str.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			}
			else if (c == '[') {
				stack.push(']');
			}
			else if (c == '{') {
				stack.push('}');
			}
			else {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != c) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}
