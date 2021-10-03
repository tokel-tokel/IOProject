package pack;

import java.util.Scanner;

public class Console
{
    private boolean isConsoleWorking;
    private boolean isUserConstructor = false;
    private final Scanner in = new Scanner(System.in);
    private final IKeyListener listener;

    public Console()
    {
        listener = new ConsoleListener(this);
    }
    public Console(IKeyListener listener)
    {
        this.listener = listener;
        isUserConstructor = true;
    }

    public void start()
    {
        isConsoleWorking = true;
        listener.doOnP();
        char c;
        do
        {
            c = in.next().charAt(0);

            if (!isUserConstructor)
            {
                switch (c)
                {
                    case 'a' -> listener.doOnA();
                    case 'b' -> listener.doOnB();
                    case 'c' -> listener.doOnC();
                    case 'd' -> listener.doOnD();
                    case 'e' -> listener.doOnE();
                    case 'p' -> listener.doOnP();
                    case 'r' -> listener.doOnR();
                }
            }

            else
            {
                switch (c)
                {
                    case 'a' -> listener.doOnA();
                    case 'b' -> listener.doOnB();
                    case 'c' -> listener.doOnC();
                    case 'd' -> listener.doOnD();
                    case 'e' -> stopConsole();
                }
            }

        } while (isConsoleWorking);
    }

    public void stopConsole()
    {
        isConsoleWorking = false;
    }
}
