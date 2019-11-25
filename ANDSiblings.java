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
        //ArrayList<Integer> indices = new ArrayList<Integer>();
        //andSiblings.findSiblings(startString, indices);

        //test buildstring
        ArrayList<Integer> indices = new ArrayList<Integer>(Arrays.asList(1,0,2));
        andSiblings.findSiblings("abc", indices);

        ListIterator<String> iterator = siblings.listIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /* take string and build new strings from permutations
    for each starting index, concatenate with each of remaining indices not already in string
    base case: all letters used - check not already in siblings before adding */
    private void findSiblings(String startString, ArrayList<Integer> indices) {
        //BASE CASE: if all letters have been used, build and return string
        if (indices.size() == startString.length()) {
            String siblingString = buildString(startString, indices);
            if (!(siblings.contains(siblingString))) {
                siblings.add(siblingString);
            }
        }
        
        /* TO COMPLETE: RECURSIVE CASE
        for(int i = 0; i < startString.length; i++) {

        }
        */
    }

    private String buildString(String startString, ArrayList<Integer> indices) {
        String siblingString = new String("");
        
        for (Integer i : indices) {
            siblingString = siblingString.concat(String.valueOf(startString.charAt(i)));
        }

        return siblingString;
    }
}