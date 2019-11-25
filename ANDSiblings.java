import java.io.Console;
import java.util.ArrayList;

public class ANDSiblings {
    public static void main(String[] args) {
        Console console = System.console();
        
        System.out.println("Enter string:\n");
        String siblingString = console.readLine();
        System.out.println(siblingString);

        ArrayList<String> siblings = new ArrayList<String>();
    }
}