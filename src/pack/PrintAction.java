package pack;

public class PrintAction implements IAction
{
    private final INewConsoleListener consoleListener;

    public PrintAction(INewConsoleListener consoleListener)
    {
        this.consoleListener = consoleListener;
    }

    @Override
    public void doAction()
    {
        consoleListener.getEventFromActions(this, EventsFromActions.PRINT_CONTROL);
    }

    @Override
    public String getActionName()
    {
        return "PrintAction";
    }
}
