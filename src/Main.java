import java.util.Scanner;

/**
 * Demonstrates the use of the Command pattern with a simple text editor.
 *
 * @author Shivaun Bartoo
 * @version 1.0
 */
public class Main
{
    private static final CommandStack STACK = new CommandStack();
    private static final StringBuilder DOCUMENT = new StringBuilder();
    private static final int EMPTY = 0;

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
        boolean running;
        String input;

        scan = new Scanner(System.in);
        running = true;

        System.out.println("Enter an input, \"undo\" to undo, or \"quit\" to quit.");
        while(running)
        {
            input = scan.nextLine();

            switch(input.strip().toLowerCase())
            {
                case "quit" -> running = false;
                case "undo" -> STACK.undo();
                case "redo" -> STACK.redo();
                default -> STACK.run(getDocumentCommand(input));
            }

            System.out.println(DOCUMENT);
        }
    }

    /**
     * Creates a {@link Command} that appends the given string to the document,
     * and can undo the operation by removing the appended text.
     *
     * @param str the string to append to the document
     * @return a {@code Command} for appending and undoing the append
     */
    private static Command getDocumentCommand(final String str)
    {
        final Runnable execute;
        final Runnable undo;

        execute = () -> DOCUMENT.append(str);
        undo    = () ->
        {
            final int start;
            start = DOCUMENT.length() - str.length();
            if (start >= EMPTY)
            {
                DOCUMENT.delete(start, DOCUMENT.length());
            }
        };
        return new Command(execute, undo);
    }
}
