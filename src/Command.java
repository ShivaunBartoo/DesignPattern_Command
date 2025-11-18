/**
 * This class is a lightweight implementation of the Command pattern.
 * Represents an executable operation paired with an undo operation.
 *
 * <p>
 * A Command is constructed by providing two {@link Runnable} instances:
 * one to perform the operation and one to reverse it. The Command simply
 * delegates {@link #execute()} and {@link #undo()} to those runnables.
 * </p>
 * @author Shivaun Bartoo
 * @version 1.0
 * @since 1.0
 */
public class Command
{
    private final Runnable execute;
    private final Runnable undo;

    /**
     * Creates a new Command with the given execute and undo actions.
     *
     * @param execute the {@code Runnable} to run when {@link #execute()} is invoked;
     * @param undo    the {@code Runnable} to run when {@link #undo()} is invoked;
     */
    public Command(final Runnable execute,
                   final Runnable undo)
    {
        this.execute = execute;
        this.undo = undo;
    }

    /**
     * Execute the command by running the execute action.
     */
    public void execute()
    {
        execute.run();
    }

    /**
     * Undo the command by running to the undo action.
     */
    public void undo()
    {
        undo.run();
    }
}
