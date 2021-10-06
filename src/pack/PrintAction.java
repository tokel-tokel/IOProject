package pack;

public class PrintAction implements IAction
{
    private final NewConsoleListener consoleListener;

    public PrintAction(NewConsoleListener consoleListener)
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
