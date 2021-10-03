package pack;

public class Program
{
    public static void main(String[] args)
    {
        Console console1 = new Console();
        console1.start();

        Console console2 = new Console(new IKeyListener()
        {

        });

        console2.start();
    }
}
