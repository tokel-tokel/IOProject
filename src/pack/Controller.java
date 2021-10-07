package pack;

public class Controller
{
    private Console currConsole;
    private final Console console1;
    private final Console console2;
    private final Console console3;

    public Controller()
    {
        console1 = new Console(this);
        console2 = new Console(this);
        console3 = new Console(this);

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
        console3.setListener(new NewConsoleListener(console3));

        currConsole = console1;
    }

    public void start()
    {
        currConsole.start();
    }

    public void getEventFromConsole(Console console, ControllerEvents event, String chosenConsole)
    {
        if (console == console1 || console == console2 || console == console3)
        {
            if(event == ControllerEvents.CHANGE_CONSOLE)
            {
                Console oldCurrConsole = currConsole;
                switch (chosenConsole)
                {
                    case "console1" -> currConsole = console1;
                    case "console2" -> currConsole = console2;
                    case "console3" -> currConsole = console3;
                    default -> {
                        System.out.println("Такой консоли нет!");
                        return;
                    }
                }
                oldCurrConsole.getEventFromController(this, ConsoleEvents.STOP);
                currConsole.start();
            }
        }
    }
}
