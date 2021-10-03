package pack;

public class ExitAction implements IAction
{
    Console console;

    public ExitAction(Console console)
    {
        this.console = console;
    }

    @Override
    public void doAction()
    {
        console.stopConsole();
    }

    @Override
    public String getActionName()
    {
        return "Exit";
    }
}
