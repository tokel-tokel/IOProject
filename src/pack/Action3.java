package pack;

public class Action3 implements IAction
{
    @Override
    public void doAction()
    {
        System.out.println("Action 3");
    }

    @Override
    public String getActionName()
    {
        return "Action3";
    }

}
