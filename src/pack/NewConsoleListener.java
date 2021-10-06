package pack;

import java.util.Scanner;

public class NewConsoleListener implements IConsoleListener
{
    private final Scanner in = new Scanner(System.in);
    private final Console console;
    private final Contract contract;

    private final IAction action1;
    private final IAction action2;
    private final IAction action3;
    private final IAction action4;
    private final IAction exitAction;
    private final IAction printAction;
    private final IAction changeAction;
    private final IAction secretAction;

    private IAction actionA;
    private IAction actionB;
    private IAction actionC;
    private IAction actionD;
    private IAction actionE;
    private IAction actionP;
    private IAction actionR;

    public NewConsoleListener(Console console, Contract contract)
    {
        this.console = console;
        this.contract = contract;

        action1 = new Action1();
        action2 = new Action2();
        action3 = new Action3();
        action4 = new Action4();
        exitAction = new ExitAction(this);
        printAction = new PrintAction(this);
        changeAction = new ChangeAction(this);
        secretAction = new SecretAction(this);

        actionA = action1;
        actionB = action2;
        actionC = action3;
        actionD = action4;
        actionE = exitAction;
        actionP = printAction;
        actionR = changeAction;
    }

    public NewConsoleListener(Console console)
    {
        this(console, null);
    }

    @Override
    public void update(ConsoleListenerEvents event)
    {
        switch (event)
        {
            case KEY_A_PRESSED -> actionA.doAction();
            case KEY_B_PRESSED -> actionB.doAction();
            case KEY_C_PRESSED -> actionC.doAction();
            case KEY_D_PRESSED -> actionD.doAction();
            case KEY_E_PRESSED -> actionE.doAction();
            case KEY_P_PRESSED -> actionP.doAction();
            case KEY_R_PRESSED -> actionR.doAction();
            case PRINT_CONTROL_REQUESTED -> printControl();
        }
    }

    public void getEventFromActions(IAction sender, EventsFromActions event)
    {
        if(sender == exitAction)
        {
            if (event == EventsFromActions.EXIT)
            {
                exitFromConsole();
            }
        }
        else if (sender == printAction)
        {
            if (event == EventsFromActions.PRINT_CONTROL)
            {
                printControl();
            }
        }
        else if (sender == changeAction)
        {
            if (event == EventsFromActions.CHANGE_CONTROL)
            {
                changeControl();
            }
        }
        else if (sender == secretAction)
        {
            if(event == EventsFromActions.SECRET_ACTION)
            {
                console.getSecretEvent(SecretConsoleEvents.EVENT1, contract);
            }
        }
    }

    private void exitFromConsole()
    {
        console.getEvent(this, ConsoleEvents.STOP);
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
            case "secret" -> newAction = secretAction;
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

}
