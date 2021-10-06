package pack;

public class ExitAction implements IAction
{
    private final NewConsoleListener consoleListener;

    public ExitAction(NewConsoleListener consoleListener)
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
