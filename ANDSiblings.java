import java.io.Console;
import java.util.ArrayList;

public class ANDSiblings {

    private ArrayList<String> siblings = new ArrayList<String>();
    public static void main(String[] args) {
        ANDSiblings andsiblings = new ANDSiblings();
        
        Console console = System.console();
        
        //input string
        System.out.println("Enter string:\n");
        String siblingString = console.readLine();

        //find siblings, passing empty list of indices
        ArrayList<Integer> indices = new ArrayList<Integer>();
        andsiblings.findSiblings(siblingString, indices);
    }

    /*take string and build new strings from permutations
    for each starting index, concatenate with each of remaining indices not already in string
    base case: check not already in siblings */
    public String findSiblings(String siblingString, ArrayList<Integer> indices) {

    }
}