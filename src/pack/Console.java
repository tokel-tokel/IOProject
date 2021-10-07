package pack;

import java.util.Scanner;

public class Console
{
    private boolean isConsoleWorking;

    private final Scanner in = new Scanner(System.in);
    private IConsoleListener listener;
    private final Controller controller;

    private final Contract contract = new Contract();

    public Console(Controller controller)
    {
        listener = new NewConsoleListener(this, contract);
        this.controller = controller;
    }

    public void setListener(IConsoleListener listener)
    {
        this.listener = listener;
    }

    public void start()
    {
        isConsoleWorking = true;
        listener.update(ConsoleListenerEvents.PRINT_CONTROL_REQUESTED);
        char c;
        do
        {
            c = in.next().charAt(0);
            switch (c)
            {
                case 'a' -> listener.update(ConsoleListenerEvents.KEY_A_PRESSED);
                case 'b' -> listener.update(ConsoleListenerEvents.KEY_B_PRESSED);
                case 'c' -> listener.update(ConsoleListenerEvents.KEY_C_PRESSED);
                case 'd' -> listener.update(ConsoleListenerEvents.KEY_D_PRESSED);
                case 'e' -> listener.update(ConsoleListenerEvents.KEY_E_PRESSED);
                case 'p' -> listener.update(ConsoleListenerEvents.KEY_P_PRESSED);
                case 'r' -> listener.update(ConsoleListenerEvents.KEY_R_PRESSED);
                case 'o' -> listener.update(ConsoleListenerEvents.KEY_O_PRESSED);
            }

        } while (isConsoleWorking);
    }

    public void getEvent(IConsoleListener sender, ConsoleEvents event)
    {
        if (sender == listener)
        {
            if(event == ConsoleEvents.STOP)
            {
                stopConsole();
            }
        }
    }

    public void getEventFromController(Controller sender, ConsoleEvents event)
    {
        if (sender == controller)
        {
            if (event == ConsoleEvents.STOP)
            {
                stopConsole();
            }
        }
    }

    public void getEvent(IConsoleListener sender, ConsoleEvents event, String chosenConsole)
    {
        if (sender == listener)
        {
            if (event == ConsoleEvents.CHANGE_CONSOLE)
            {
                controller.getEventFromConsole(this, ControllerEvents.CHANGE_CONSOLE, chosenConsole);
            }
        }
    }

    public void getSecretEvent(SecretConsoleEvents event, Contract contract)
    {
        if (this.contract == contract)
        {
            if (event == SecretConsoleEvents.EVENT1)
            {
                System.out.println("You found a secret");
            }
        }
    }

    private void stopConsole()
    {
        isConsoleWorking = false;
    }
}
