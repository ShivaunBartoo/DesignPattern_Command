import java.util.Scanner;

/**
 * Demonstrates the use of the Command pattern with a simple text editor.
 *
 * @author Shivaun Bartoo
 * @version 2.0
 */
public class Main
{
    /**
     * Entry point for the application.
     * <p>
     * Reads user input from the console and processes commands to append text,
     * undo, redo, or quit the application.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args)
    {
        final Scanner scan;
        final StringBuilder document;
        final CommandStack stack;
        boolean running;
        String input;

        document = new StringBuilder();
        stack = new CommandStack();
        scan = new Scanner(System.in);
        running = true;

        System.out.println("Enter a text input or a command: \"undo\", \"redo\", or \"quit\".");
        while(running)
        {
            input = scan.nextLine();

            switch(input.strip().toLowerCase())
            {
                case "quit" -> running = false;
                case "undo" -> stack.undo();
                case "redo" -> stack.redo();
                default -> stack.run(new TextCommand(document, input));
            }

            System.out.println(document);
        }
    }
}
