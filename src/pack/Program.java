package pack;

public class Program
{
    public static void main(String[] args)
    {
        Console console1 = new Console();
        console1.start();

        Console console2 = new Console();
        console2.setListener(new IConsoleListener()
        {
            @Override
            public void update(ConsoleListenerEvents event)
            {
                switch (event)
                {
                    case KEY_A_PRESSED -> System.out.println("A Pressed");
                    case KEY_E_PRESSED -> console2.getEvent(this, ConsoleEvents.STOP);
                }
            }
        });
        console2.start();

        Console console3 = new Console();
        console3.setListener(new NewConsoleListener(console3));
        console3.start();

    }
}
