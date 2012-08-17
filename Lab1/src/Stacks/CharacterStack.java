package Stacks;

public class CharacterStack {

    char[] items;
    int   maxItems;
    int   top;
    
    /**
     * New stack of characters.
     * @param stringSize
     */
    public CharacterStack(int stringSize) {
        
        maxItems = stringSize + 1;
        items = new char[maxItems];
        top   = -1;     
    }
    
    /**
     * Check if the stack is empty.
     * @return <code>true</code> if the stack is empty, otherwise return <code>false</code>   
     */
    public boolean isEmpty() {
        
        if (top == -1)
        	return true;
        else
            return false;
    }
    
    /**
     * Check if the stack is full.
     * @return <code>true</code> if the stack is full, otherwise return <code>false</code>
     */
    public boolean isFull() {
        
        if (top == maxItems - 1)
            return true;
        else
            return false;
    }
    
    /**
     * Pop the topmost character from the stack and move the top of the stack to the next item down.
     * @return The character on the top of the stack.
     */
    public char pop() {
        
        char charToReturn;
        
        charToReturn = items[top];
        top--;
        
        return charToReturn;
    }
    
    /**
     * Push a character onto the stack and move top to the new character.
     * @param character
     */
    public void push(char character) {
        
        top++;
        items[top] = character;
        //return;
    }
    
    /**
     * Show the character on the top of the stack.
     * @return The character on the top of the stack without changing top.
     */
    public char peek() {
    	
    	char charToShow;
    	
    	charToShow = items[top];
    	
    	return charToShow;
    }
    
    public int size() {
    	
    	int size;
    	
    	size = top + 1;
    	
    	return size;
    }
}
