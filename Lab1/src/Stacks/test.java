package Stacks;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String	w;
		char charA;
		int		maxItems;
		CharacterStack	stack;
		
		w = "ABABABABABA";
		charA = w.charAt(0);
		maxItems = w.length();
		
		stack = new Stacks.CharacterStack(maxItems);
		
		for (int i = 0; i < w.length(); i++) {
			
			char ch = w.charAt(i);
			
			if (ch != '\u0000')
				stack.push(ch);
		}
		
		System.out.println(stack.peek());
		System.out.println();
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
