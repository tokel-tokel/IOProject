package pack;

public class ChangeAction implements IAction
{
    private final NewConsoleListener consoleListener;

    public ChangeAction(NewConsoleListener consoleListener)
    {
        this.consoleListener = consoleListener;
    }

    @Override
    public void doAction()
    {
        consoleListener.getEventFromActions(this, EventsFromActions.CHANGE_CONTROL);
    }

    @Override
    public String getActionName()
    {
        return "ChangeAction";
    }
}
