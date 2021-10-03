package pack;

public class Action1 implements IAction
{
    @Override
    public void doAction()
    {
        System.out.println("Action 1");
    }

    @Override
    public String getActionName()
    {
        return "Action1";
    }


}
