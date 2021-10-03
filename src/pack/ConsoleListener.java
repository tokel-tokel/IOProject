package pack;

public class ConsoleListener implements IKeyListener
{
    private Console console;

    private final IAction action1;
    private final IAction action2;
    private final IAction action3;
    private final IAction action4;
    private final IAction exitAction;

    private IAction actionA;
    private IAction actionB;
    private IAction actionC;
    private IAction actionD;
    private IAction actionE;

    public ConsoleListener(Console console)
    {
        this.console = console;

        action1 = new Action1();
        action2 = new Action2();
        action3 = new Action3();
        action4 = new Action4();
        exitAction = new ExitAction(this.console);

        actionA = action1;
        actionB = action2;
        actionC = action3;
        actionD = action4;
        actionE = exitAction;
    }

    @Override
    public void doOnA()
    {
        actionA.doAction();
    }

    @Override
    public void doOnB()
    {
        actionB.doAction();
    }

    @Override
    public void doOnC()
    {
        actionC.doAction();
    }

    @Override
    public void doOnD()
    {
        actionD.doAction();
    }

    @Override
    public void doOnE()
    {
        actionE.doAction();
    }

    public void changeControl(String param)
    {
        IAction newAction;
        String[] params = param.split("-");

        switch (params[1])
        {
            case "1" -> newAction = action1;
            case "2" -> newAction = action2;
            case "3" -> newAction = action3;
            case "4" -> newAction = action4;
            case "exit" -> newAction = exitAction;
            default -> throw new IllegalStateException("Unexpected value: " + params[1]);
        }

        switch (params[0])
        {
            case "a" -> actionA = newAction;
            case "b" -> actionB = newAction;
            case "c" -> actionC = newAction;
            case "d" -> actionD = newAction;
            case "e" -> actionE = newAction;
        }
    }

    public void printControl()
    {
        System.out.println("a - " + actionA.getActionName());
        System.out.println("b - " + actionB.getActionName());
        System.out.println("c - " + actionC.getActionName());
        System.out.println("d - " + actionD.getActionName());
        System.out.println("e - " + actionE.getActionName());
        System.out.println("p - Print Control");
        System.out.println("r - Change Control");
    }
}
