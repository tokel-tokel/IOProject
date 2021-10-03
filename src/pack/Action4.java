package pack;

public class Action4 implements IAction
{
    @Override
    public void doAction()
    {
        System.out.println("Action 4");
    }

    @Override
    public String getActionName()
    {
        return "Action4";
    }
}
