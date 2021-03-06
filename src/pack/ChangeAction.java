package pack;

public class ChangeAction implements IAction
{
    private final INewConsoleListener consoleListener;

    public ChangeAction(INewConsoleListener consoleListener)
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
