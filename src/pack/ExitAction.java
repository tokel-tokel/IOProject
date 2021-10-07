package pack;

public class ExitAction implements IAction
{
    private final INewConsoleListener consoleListener;

    public ExitAction(INewConsoleListener consoleListener)
    {
        this.consoleListener = consoleListener;
    }

    @Override
    public void doAction()
    {
        consoleListener.getEventFromActions(this, EventsFromActions.EXIT);
    }

    @Override
    public String getActionName()
    {
        return "Exit";
    }
}
