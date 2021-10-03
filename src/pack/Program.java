package pack;

public class Program
{
    public static void main(String[] args)
    {
        Console console1 = new Console();
        console1.start();

        Console console2 = new Console(new IKeyListener()
        {
            @Override
            public void doOnA()
            {

            }

            @Override
            public void doOnB()
            {

            }

            @Override
            public void doOnC()
            {

            }

            @Override
            public void doOnD()
            {

            }

            @Override
            public void doOnE()
            {
                throw new IllegalArgumentException();
            }

            @Override
            public void printControl()
            {

            }

            @Override
            public void changeControl(String param)
            {
                throw  new IllegalArgumentException();
            }
        });

        console2.start();
    }
}
