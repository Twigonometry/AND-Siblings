import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ANDSiblings {

    private static ArrayList<String> siblings = new ArrayList<String>();
    
    public static void main(String[] args) throws NumberFormatException {
        ANDSiblings andSiblings = new ANDSiblings();
        String formattedString = new String();
        
        Console console = System.console();
        
        //input string
        System.out.println("Enter string:\n");
        String startString = console.readLine();

        //attempt to format string
        try {
            formattedString = formatString(startString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String result = findSiblings(formattedString, "", "");

        System.out.println(result.substring(0, result.length() - 1));
    }
    
    /**
     * recursive function that finds permutations of given string and concatenates them
     * @param input : string to recursively find siblings for
     * @param partSibling : part of a permutation
     * @param partSolution : solution so far
     * @return string containing all siblings
     */
    public static String findSiblings(String input, String partSibling, String partSolution) {
    	//BASE CASE: if all numbers in input have been used, we have constructed full sibling
    	if (input.length() == 0) {
    		if (!partSolution.contains(partSibling)) {
    			return partSolution.concat(partSibling + ",");
    		} else {
    			return "";
    		}
    	} 
    	
    	//RECURSIVE CASE: calculate remaining permutations from each starting point in input
    	else {
    		//empty string of permutations to add to solution
    		String permsFound = new String("");
    		
    		//iterate over each 'starting point' in input
    		for (int i = 0; i < input.length(); i++) {
    			//remove a character from input and add it to partSibling, then recurse
    			String _partSibling = partSibling.concat(Character.toString(input.charAt(i)));
    			String reducedInput = input.substring(0, i) + input.substring(i + 1);
    			permsFound = permsFound.concat(findSiblings(reducedInput, _partSibling, partSolution));
    		}
    		
    		return permsFound;
    	}
    }

    /**
     * attempt to format the string, removing non-numeric characters
     * if no numeric characters found, throw an exception
     * @return formatted string
     */
    public static String formatString(String input) throws NumberFormatException {
        //replace all non numeric characters with empty strings
        String result = input.replaceAll("[^0-9]", "");

        //check string is not empty
        if(result.length() == 0) {
            throw new NumberFormatException();
        } else {
            return result;
        }
    }
}