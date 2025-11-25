/**
 * A command that appends text to a document and can undo the operation.
 *
 * @author Shivaun Bartoo
 * @version 1.0
 */
public class TextCommand implements Command
{
    private final StringBuilder document;
    private final String edit;

    /**
     * Constructs a TextCommand.
     *
     * @param document the document to edit
     * @param edit the text to append
     */
    public TextCommand(final StringBuilder document,
                       final String edit)
    {
        this.document = document;
        this.edit = edit;
    }

    /**
     * Appends the edit text to the document.
     */
    @Override
    public void execute()
    {
        document.append(edit);
    }

    /**
     * Undoes the last append operation by removing the edit text.
     */
    @Override
    public void undoCommand()
    {
        final int editStart;
        final int editEnd;

        editStart = document.length() - edit.length();
        editEnd   = document.length();

        document.delete(editStart, editEnd);
    }
}