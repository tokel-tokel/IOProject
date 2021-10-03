package pack;

public class Action2 implements IAction
{
    @Override
    public void doAction()
    {
        System.out.println("Action 2");
    }

    @Override
    public String getActionName()
    {
        return "Action2";
    }


}
