package pack;

public class SecretAction implements IAction
{
    private NewConsoleListener consoleListener;

    public SecretAction(NewConsoleListener consoleListener)
    {
        this.consoleListener = consoleListener;
    }

    @Override
    public void doAction()
    {
        consoleListener.getEventFromActions(this, EventsFromActions.SECRET_ACTION);
    }

    @Override
    public String getActionName()
    {
        return "SecretAction";
    }
}
