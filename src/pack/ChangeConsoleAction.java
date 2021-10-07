package pack;

public class ChangeConsoleAction implements IAction
{
    private final INewConsoleListener consoleListener;

    public ChangeConsoleAction(INewConsoleListener consoleListener)
    {
        this.consoleListener = consoleListener;
    }

    @Override
    public void doAction()
    {
        consoleListener.getEventFromActions(this, EventsFromActions.CHANGE_CONSOLE);
    }

    @Override
    public String getActionName()
    {
        return "ChangeConsoleAction";
    }
}
