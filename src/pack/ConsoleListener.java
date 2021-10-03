package pack;

import java.util.Scanner;

public class ConsoleListener implements IKeyListener
{
    Scanner in = new Scanner(System.in);

    private final Console console;

    private final IAction action1;
    private final IAction action2;
    private final IAction action3;
    private final IAction action4;
    private final IAction exitAction;
    private final IAction printAction;
    private final IAction changeAction;

    private IAction actionA;
    private IAction actionB;
    private IAction actionC;
    private IAction actionD;
    private IAction actionE;
    private IAction actionP;
    private IAction actionR;

    public ConsoleListener(Console console)
    {
        this.console = console;

        action1 = new Action1();
        action2 = new Action2();
        action3 = new Action3();
        action4 = new Action4();
        exitAction = new ExitAction(this.console);
        printAction = new PrintAction();
        changeAction = new ChangeAction();

        actionA = action1;
        actionB = action2;
        actionC = action3;
        actionD = action4;
        actionE = exitAction;
        actionP = printAction;
        actionR = changeAction;
    }

    @Override
    public void doOnA()
    {
        checkAndDo(actionA);
    }

    @Override
    public void doOnB()
    {
        checkAndDo(actionB);
    }

    @Override
    public void doOnC()
    {
        checkAndDo(actionC);
    }

    @Override
    public void doOnD()
    {
        checkAndDo(actionD);
    }

    @Override
    public void doOnE()
    {
        checkAndDo(actionE);
    }

    @Override
    public void doOnP()
    {
        checkAndDo(actionP);
    }

    @Override
    public void doOnR()
    {
        checkAndDo(actionR);
    }

    private void changeControl()
    {
        String param = in.next();
        IAction newAction;
        String[] params = param.split("-");

        switch (params[1])
        {
            case "1" -> newAction = action1;
            case "2" -> newAction = action2;
            case "3" -> newAction = action3;
            case "4" -> newAction = action4;
            case "exit" -> newAction = exitAction;
            case "print" -> newAction = printAction;
            case "change" -> newAction = changeAction;
            default -> throw new IllegalStateException("Unexpected value: " + params[1]);
        }

        switch (params[0])
        {
            case "a" -> actionA = newAction;
            case "b" -> actionB = newAction;
            case "c" -> actionC = newAction;
            case "d" -> actionD = newAction;
            case "e" -> actionE = newAction;
            case "p" -> actionP = newAction;
            case "r" -> actionR = newAction;
        }
    }

    private void printControl()
    {
        System.out.println("a - " + actionA.getActionName());
        System.out.println("b - " + actionB.getActionName());
        System.out.println("c - " + actionC.getActionName());
        System.out.println("d - " + actionD.getActionName());
        System.out.println("e - " + actionE.getActionName());
        System.out.println("p - " + actionP.getActionName());
        System.out.println("r - " + actionR.getActionName());
    }

    private void checkAndDo(IAction action)
    {
        if (action == printAction)
        {
            printControl();
        }
        else if (action == changeAction)
        {
            changeControl();
        }
        else
        {
            action.doAction();
        }
    }

}
