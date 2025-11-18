import java.util.Stack;

/**
 * Manages a stack of {@link Command} objects to provide undo and redo functionality.
 * <p>
 * The {@code CommandStack} allows commands to be executed, undone, and redone in sequence.
 * When a new command is run, any commands above the current position are discarded.
 * Undo and redo operations move the current position backward and forward, respectively,
 * executing or undoing the corresponding command.
 * </p>
 *
 * @author Shivaun Bartoo
 * @version 1.0
 */
public class CommandStack
{
    private static final int EMPTY = 0;
    public static final int INDEX_OFFSET = -1;

    private final Stack<Command> stack;
    private int current;

    /**
     * Constructs an empty {@code CommandStack}.
     */
    public CommandStack()
    {
        stack = new Stack<>();
        current = EMPTY;
    }

    /**
     * Executes the given command, adds it to the stack, and updates the current position.
     * Any commands above the current position are removed before the new command is pushed.
     *
     * @param command the {@link Command} to execute and add to the stack
     */
    public void run(final Command command)
    {
        while(stack.size() > current)
        {
            stack.pop();
        }
        command.execute();
        stack.push(command);
        current++;
    }

    /**
     * Undoes the most recently executed command, if possible.
     */
    public void undo()
    {
        if(current > EMPTY)
        {
            stack.get(current + INDEX_OFFSET).undo();
            current--;
        }
        else
        {
            System.out.println("Undo queue is empty.");
        }
    }

    /**
     * Redoes the next command in the stack, if possible.
     */
    public void redo()
    {
        if(current < stack.size())
        {
            stack.get(current).execute();
            current++;
        }
        else
        {
            System.out.println("Nothing to redo.");
        }
    }
}
