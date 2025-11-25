/**
 * This interface is a simple implementation of the Command pattern.
 * Represents an executable operation paired with an undo operation.
 *
 * @author Shivaun Bartoo
 * @version 2.0
 */
public interface Command
{
    /**
     * Execute the command by running the execute action.
     */
    public void execute();

    /**
     * Undo the command by running to the undo action.
     */
    public void undoCommand();
}
