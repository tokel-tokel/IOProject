package pack;

import java.util.Scanner;

public class Console
{
    private boolean isConsoleWorking;
    private final Scanner in = new Scanner(System.in);
    private final ConsoleListener listener = new ConsoleListener(this);

    public void start()
    {
        isConsoleWorking = true;
        listener.printControl();
        char c;
        do
        {
            c = in.next().charAt(0);
            switch (c)
            {
                case 'a' -> listener.doOnA();
                case 'b' -> listener.doOnB();
                case 'c' -> listener.doOnC();
                case 'd' -> listener.doOnD();
                case 'e' -> listener.doOnE();
                case 'p' -> listener.printControl();
                case 'r' -> {
                    String param = in.next();
                    listener.changeControl(param);
                }
            }
        } while (isConsoleWorking);
    }

    public void stopConsole()
    {
        isConsoleWorking = false;
    }
}
