package pack;

public interface INewConsoleListener extends IConsoleListener
{
    void getEventFromActions(IAction sender, EventsFromActions event);
}
