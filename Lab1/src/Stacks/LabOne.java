package Stacks;

import java.io.*;

public class LabOne {

    /**
     *  Entry point for the program. All strings are checked for the proper format and checked against each language.
     *  The results of the analysis are output to a text file for easy viewing.
     *  @param args[]   Holds two command line arguments:  the input filename and the output filename.
     */
	public static void main(String[] args) {
				
		BufferedReader	input;
		BufferedWriter	output;
		String			w;
		String			resultOne;
		String			resultTwo;
		String			resultThree;
		String			resultFour;
		String			stringA;
		String			stringB;
		char			charA;
		char			charB;
		char			ch;
		Boolean			languageOneCheck;
		Boolean			languageTwoCheck;
		Boolean			languageThreeCheck;
		Boolean			languageFourCheck;
		LabOne			lab;
		
		
		lab = new LabOne();
		
        //  Check for two command line arguments.
        if (args.length != 2) {
            System.out.println("Usage:  java LabOne [input file]" +
                " [output file]");
            System.exit(1);
        }
        
        //  Open the input and output files.
        try {
            input = new BufferedReader(new FileReader(args[0]));
            output = new BufferedWriter(new FileWriter(args[1]));
        } catch (Exception exception) {
            System.err.println(exception.toString());
            return;
        }
        
        // Pass each string through each language algorithm and write the results to the output file.
		stringA = "A";
		stringB = "B";
		charA = stringA.charAt(0);
		charB = stringB.charAt(0);
		w = lab.readCharacterString(input);
		
    	// check for empty strings before continuing
    	while (w.length() == 0) {
    		w = lab.readCharacterString(input);
    	}
               
        while (w != null) {
        	       	        
        	//Check each string for characters other than A or B. If all strings pass then run them through each method - otherwise throw error.
        	for (int i = 0; i < w.length(); i++) {
        		
        		ch = w.charAt(i);
        		
        		if (ch == charA) {}
        		else if (ch == charB) {}
        		else if (ch != charA && ch != charB) {
        			System.err.println("ERROR: The string " + '"' + w + '"' + " must only contain A's and B's.");
        			System.exit(1);
        		}
            }
        	
            languageOneCheck = lab.languageOne(w);
            languageTwoCheck = lab.languageTwo(w);
            languageThreeCheck = lab.languageThree(w);
            languageFourCheck = lab.languageFour(w);
            
        	//Check if the string exists in each language.
        	if (languageOneCheck == true)
        		resultOne = "PASSED";
        	else
        		resultOne = "FAILED";
        	            
        	if (languageTwoCheck == true)
        		resultTwo = "PASSED";
        	else
        		resultTwo = "FAILED";
        	
        	if (languageThreeCheck == true)
        		resultThree = "PASSED";
        	else
        		resultThree = "FAILED";
        	
        	if (languageFourCheck == true)
        		resultFour = "PASSED";
        	else
        		resultFour = "FAILED";
        	
        	lab.writeOutput(w, resultOne, resultTwo, resultThree, resultFour, output);
        	w = lab.readCharacterString(input);
        
        	// check for empty strings before continuing
        	if (w == null) {
        		continue;
        	}
        	
        	while (w.length() == 0) {
        		w = lab.readCharacterString(input);
        	}
        }
        
        // Close the input and output files and return to OS.
        try {
            input.close();
            output.close();
        } catch (Exception exception) {
            System.err.println(exception.toString());
        }
        return;
	}
	
	/**
	 * Read in the first string of characters from the input file.
	 * @param input		the first string in the input file.
	 * @return The first string of characters.
	 */
	private String readCharacterString(BufferedReader input) {
		
		String w = "";
		
        try {
            w = input.readLine();
        } catch (IOException ioException) {
            System.err.println(ioException.toString());
            System.exit(2);
        }
        
        return w;
	}
	
	/**
	 * Write the output results to the output file.
	 * @param w
	 * @param output	the output file.
	 */
	private void writeOutput(String w, String resultOne, String resultTwo, String resultThree, String resultFour, BufferedWriter output) {
		
		 try {
			 	output.write("String " + '"' + w + '"' + ":");
			 	output.newLine();
			 	output.newLine();
	            output.write("  " + "Language One = " + resultOne);
	            output.newLine();
	            output.write("  " + "Language Two = " + resultTwo);
	            output.newLine();
	            output.write("  " + "Language Three = " + resultThree);
	            output.newLine();
	            output.write("  " + "Language Four = " + resultFour);
	            output.newLine();
	            output.newLine();
	        } catch (IOException ioException) {
	            System.err.println(ioException.toString());
	            System.exit(3);
	        }
	        
	        return;
	}
	
	/**
	 * Compare the string against the first language.
	 * @param w
	 * @return <code>true</code> if the string matches, otherwise return <code>false</code>
	 */
	public boolean languageOne(String w) {
		
		char 			ch;
		char			nullChar;
		int				maxItems;
		Boolean			stackEmpty;
		CharacterStack 	stack;
		
		maxItems =		w.length();
		
		stack = new Stacks.CharacterStack(maxItems);
		
		// Push all of one character on the stack and pop those characters when the second character is encountered in the string.
		nullChar = '\u0000';
		stackEmpty =	null;
		for (int i = 0; i < w.length(); i++) {

			ch = w.charAt(i);		
			if (ch != nullChar && stack.isEmpty() == true)
				stack.push(ch);
			else if (ch != nullChar && ch == stack.peek())
				stack.push(ch);
			else
				stack.pop();
			
			stackEmpty = stack.isEmpty();
		}
		
		//If the stack is empty after the analysis above then the string passes Language 1.
		if (stackEmpty == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Compare the string against the second language.
	 * @param w
	 * @return <code>true</code> if the string matches, otherwise return <code>false</code>
	 */
	public boolean languageTwo(String w) {
		
		char 	ch;
		char	chZero;
		char 	chValue;
		char	test;
		int		maxItems;
		Boolean	stackOneEmpty;
		Boolean	stackTwoEmpty;
		String	error;
		String  bee;
		
		CharacterStack stackOne;
		CharacterStack stackTwo;
		
		maxItems =		w.length();
		
		stackOne = new Stacks.CharacterStack(maxItems);
		stackTwo = new Stacks.CharacterStack(maxItems);
		
		// Push A's and B's onto separate stacks. If the second character changes back to the first then 
		// break out of the loop and return false (no repeats allowed).
		chZero = w.charAt(0);
		error =	"";
		for (int i = 0; i < w.length(); i++) {

			ch = w.charAt(i);
			
			if (ch == chZero) {
				stackOne.push(ch);
			} 
			else if (ch != chZero) {
				
				// once the character changes, start from the new character's position in the string and 
				// continue processing until it changes again.
				for (int z = i; z < w.length(); z++) {
				
					ch = w.charAt(z);
					
					if (ch != stackOne.peek()) {
						stackTwo.push(ch);
					} 
					else if (ch == chZero) {
						error = "fail";
						break;
					}
				}
			
				break;
			}
		}
		
		// If the characters only changed once then pop each stack an equal number of 
		// times while characters exist in the first stack.
		stackOneEmpty = null;
		stackTwoEmpty = null;
		bee = "B";
		test = stackOne.peek();
		chValue = bee.charAt(0);
		if (error.equals("fail"))
			return false;
		else if (test == chValue)
			return false;
		else 
			while (stackOne.isEmpty() != true) {
				if (stackTwo.isEmpty() != true) {
					stackOne.pop();
					stackTwo.pop();
				}
				else if (stackTwo.isEmpty() == true)
					break;
			
			stackOneEmpty = stackOne.isEmpty();
			stackTwoEmpty = stackTwo.isEmpty();
			}

		//If the stacks are empty after the analysis above then the string passes Language 2.
		if (stackOneEmpty == true && stackTwoEmpty == true)
			return true;
		else
			return false;
	}
	
	public boolean languageThree(String w) {
		
		char 	ch;
		char	chZero;
		int		maxItems;
		Boolean	stackOneEmpty;
		Boolean	stackTwoEmpty;
		String	error;
		
		CharacterStack stackOne;
		CharacterStack stackTwo;
		
		maxItems =		w.length();
		
		stackOne = new Stacks.CharacterStack(maxItems);
		stackTwo = new Stacks.CharacterStack(maxItems);
		
		// Push A's and B's onto separate stacks. If the second character changes back to the first then break out of the loop and return false (no repeats allowed).
		chZero = w.charAt(0);
		error =	"";
		for (int i = 0; i < w.length(); i++) {

			ch = w.charAt(i);
			
			if (ch == chZero) {
				stackOne.push(ch);
			} 
			else if (ch != chZero) {
				
				//once the character changes, start from the new character's position in the string and continue processing until it changes again.
				for (int z = i; z < w.length(); z++) {
				
					ch = w.charAt(z);
					
					if (ch != stackOne.peek()) {
						stackTwo.push(ch);
					} 
					else if (ch == chZero) {
						error = "fail";
						break;
					}
				}
			
				break;
			}
		}
		
		// If the characters only changed once then pop stack One once and stack Two twice while characters exist in the first stack.
		stackOneEmpty = null;
		stackTwoEmpty = null;
		if (error.equals("fail"))
			return false;
		else 
			while (stackOne.isEmpty() != true) {
				if (stackTwo.isEmpty() != true) {
					//return false if an exception is caught during the popping process (this means there are not enough B's for the string to pass language 3.)
					try {
						stackOne.pop();
						stackTwo.pop();
						stackTwo.pop();
			        } catch (Exception exception) {
			            return false;
			        }
				}
				else if (stackTwo.isEmpty() == true)
					break;
			
			stackOneEmpty = stackOne.isEmpty();
			stackTwoEmpty = stackTwo.isEmpty();
			}

		//If the stacks are empty after the analysis above then the string passes Language 2.
		if (stackOneEmpty == true && stackTwoEmpty == true)
			return true;
		else
			return false;
	}
	
	public boolean languageFour(String w) {
		
		char 	ch;
		char	chZero;
		int		maxItems;
		int 	sizeOfOne;
		int		sizeOfTwo;
		int 	nextSizeOne;
		int 	nextSizeTwo;
		String	error;
		
		CharacterStack stackOne;
		CharacterStack stackTwo;
		
		maxItems =	w.length();
		
		stackOne = new Stacks.CharacterStack(maxItems);
		stackTwo = new Stacks.CharacterStack(maxItems);
		
		// Push A's and B's onto separate stacks. If the second character changes back to the first begin processing the next part of the string.
		chZero = w.charAt(0);
		sizeOfOne = 0;
		sizeOfTwo = 0;
		nextSizeOne = 0;
		nextSizeTwo = 0;
		error="";
		for (int i = 0; i < w.length(); i++) {

			ch = w.charAt(i);
			
			if (ch == chZero) {
				stackOne.push(ch);
			} 
			else if (ch != chZero) {
				
				//once the character changes, start from the new character's position in the string and continue processing until it changes again.
				for (int z = i; z < w.length(); z++) {
				
					ch = w.charAt(z);
					
					if (ch != stackOne.peek()) {
						stackTwo.push(ch);
					} 
					else if (ch == chZero) {
						sizeOfOne = stackOne.size();
						sizeOfTwo = stackTwo.size();
						
						while (stackOne.isEmpty() != true) {
							stackOne.pop();
						}
						
						while (stackTwo.isEmpty() != true) {
							stackTwo.pop();
						}
										
						//Once the character changes again, begin iterating through the next part of the string pattern if it exists.
						for (int n = z; n < w.length(); n++) {
							
							ch = w.charAt(n);
							
							if (stackOne.isEmpty() == true || ch == stackOne.peek()) {
								stackOne.push(ch);
							}
							else if (ch != stackOne.peek()) {
								stackTwo.push(ch);
								
								nextSizeOne = stackOne.size();
								nextSizeTwo = stackTwo.size();
							}
						}
						
						//when finished processing the patterns check the stack sizes to see if they are the same - if so then string passes L4.
						if (nextSizeOne == sizeOfOne && nextSizeTwo == sizeOfTwo) {
							error="";
							return true;
						}
						else
							error="fail";
							return false;
					}
				}
			}
		}

		
		//Check the fail conditions for all other strings that do no repeat as required for this string.
		if (error.equals("fail"))
			return false;
		else
			return true;
	}

}
