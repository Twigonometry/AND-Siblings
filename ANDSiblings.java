import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ANDSiblings {

    private static ArrayList<String> siblings = new ArrayList<String>();
    
    public static void main(String[] args) {
        ANDSiblings andSiblings = new ANDSiblings();
        
        Console console = System.console();
        
        //input string
        System.out.println("Enter string:\n");
        String startString = console.readLine();

        //find siblings, passing empty list of indices
        ArrayList<Integer> indices = new ArrayList<Integer>();
        andSiblings.findSiblings(startString, indices);

        //test buildstring
        /*
        ArrayList<Integer> indices = new ArrayList<Integer>(Arrays.asList(1,0,2));
        andSiblings.findSiblings("abc", indices);
        */

        ListIterator<String> iterator = siblings.listIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /* take string and build new strings from permutations
    for each starting index, concatenate with each of remaining indices not already in string
    base case: all letters used - check not already in siblings before adding */
    private void findSiblings(String startString, ArrayList<Integer> indices) {
        //NEED CASE FOR EMPTY STRINGS
        //can we remove brackets in if statements?
        
        //BASE CASE: if all letters have been used, build and return string
        if (indices.size() == startString.length()) {
            System.out.println("match");
            
            String siblingString = buildString(startString, indices);
            if (!(siblings.contains(siblingString))) {
                siblings.add(siblingString);
            }
        }
        
        //RECURSIVE CASE: call on rest of string with updated indices
        //where should _indices be defined?
        else {
            for(int i = 0; i < startString.length(); i++) {
                if(!(indices.contains(i))) {
                    //create new list and add next index to it, making sure not to change original list
                    ArrayList<Integer> _indices = new ArrayList<Integer>();
                    for (Integer index : indices) {
                        _indices.add(index);
                    }
                    _indices.add(i);

                    //recursive call with new indices
                    this.findSiblings(startString, _indices);
                }
            }
        }
    }

    private String buildString(String startString, ArrayList<Integer> indices) {
        String siblingString = new String("");
        
        for (Integer i : indices) {
            siblingString = siblingString.concat(String.valueOf(startString.charAt(i)));
        }

        return siblingString;
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